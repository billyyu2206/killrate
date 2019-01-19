/**
 * 
 */
package com.etonghk.killrate.dao.page;

import org.springframework.stereotype.Component;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
@Component("mySqlDialect")
public class MySqlDialect extends Dialect{

	public String getLimitString(String sql, boolean hasOffset) {
		return MySqlPageHelper.getLimitString(sql,-1,-1);
	}

	public String getLimitString(String sql, int offset, int limit) {
		return MySqlPageHelper.getLimitString(sql, offset, limit);
	}
	
	@Override
	public int getOffset(Page<?> page) {
		return page.getOffset();
	}

	@Override
	public int getLimit(Page<?> page) {
		return page.getPageSize();
	}

}
