package com.etonghk.killrate.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCacheTest {

	
	@Autowired
	private RedisCache cache;
	
	@Test
	public void tesSteCache() {
		long l1 = System.currentTimeMillis();
		for(long i=1l;i<100000l;i++) {
			cache.incr("123456");
		}
		long l2 = System.currentTimeMillis();
		System.out.println((l2-l1)/1000);
	}
	
}
