package com.etonghk.killrate.system;

import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import com.etonghk.killrate.cache.RedisCache;
import com.etonghk.killrate.cache.key.RedisHashField;
import com.etonghk.killrate.cache.key.RedisKey;

/**
 * @author Ami.Tsai
 * @date 2019年1月28日
 */
@Component
public class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
	
	@Autowired
	private RedisCache cache;
	
	private final Logger log = LoggerFactory.getLogger(GracefulShutdown.class);
    private volatile Connector connector;
    private final int waitTime = 30;
    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }
	
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		this.connector.pause();
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                    log.warn("Tomcat thread pool did not shut down gracefully within " + waitTime + " seconds. Proceeding with forceful shutdown");
                }
                cache.hdel(RedisKey.getServerCount(), RedisHashField.getServerIpPortField());
            } catch (InterruptedException | UnknownHostException ex) {
                Thread.currentThread().interrupt();
            }
        }
	}
	
	
}
