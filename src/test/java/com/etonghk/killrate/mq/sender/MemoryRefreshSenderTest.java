package com.etonghk.killrate.mq.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.vo.MemoryRefreshVo;

/**
 * @author Billy.Yu
 * @date 2019年1月23日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemoryRefreshSenderTest {

	@Autowired
	private MemoryRefreshSender sender;
	
	@Test
	public void memoryRefreshTest() {
		sender.sendMemoryRefresh(new MemoryRefreshVo("test memory send"));
	}
	
}
