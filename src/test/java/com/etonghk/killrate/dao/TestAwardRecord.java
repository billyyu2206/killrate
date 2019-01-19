/**
 * 
 */
package com.etonghk.killrate.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAwardRecord {

	@Autowired
	private KillrateAwardDao killrateAwardDao;
	
	@Test
	public void testSelect() throws ParseException {
		Page page = new Page();
		page.setPage(0);
		String gameId = "vipssc";
		Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-17");
		Boolean isPush = false;
		List<KillrateAward> list =  killrateAwardDao.selectForRecord(gameId, issueDate, isPush, page);
		System.out.println(list.get(0).getIssue());
		System.out.println(page.getCount());
		System.out.println(page.getNextPageNo());
		page.getPageSize();
		System.out.println(page.getCount());
		System.out.println( Math.max(2, page.getPage() - 2));
	}
}
