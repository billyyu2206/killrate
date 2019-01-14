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
		cache.set("123", "1234");
		System.out.println(cache.get("123"));
	}
	
}
