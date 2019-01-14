package com.etonghk.killrate.awardNmber;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.etonghk.killrate.awardNmber.anootations.AwardComponent;

/**
 * 獎號元件工廠
 * @author Ami
 *
 */
@Service
public class AwardNumberFactory {

	@Autowired
	private ApplicationContext applicationContext;
	
	private Map<String,AwardNumber> awardNumberMap = new HashMap<>();
	
	@PostConstruct
	public void composeAwardNumber() {
		Map<String, AwardNumber> beans = applicationContext.getBeansOfType(AwardNumber.class);
		beans.entrySet().forEach(beanEntry->{
			AwardNumber bean = beanEntry.getValue();
			Class<?> beanClass = bean.getClass();
			Boolean isPresent = beanClass.isAnnotationPresent(AwardComponent.class);
			if(isPresent) {
				AwardComponent awardComponent = beanClass.getAnnotation(AwardComponent.class);
				String[] componentNames = awardComponent.name();
				for(String name:componentNames) {
					awardNumberMap.put(name, bean);
				}
			}
		});
	}
	
	
	/**
	 * 取得獎號元件
	 * @param playMethod
	 * @return
	 */
	public AwardNumber getAwardNumber(String playMethod) {
		return awardNumberMap.get(playMethod);
	}
	
}
