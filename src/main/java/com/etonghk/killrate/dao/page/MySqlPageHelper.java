/**
 * 
 */
package com.etonghk.killrate.dao.page;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
public class MySqlPageHelper {
	/**
	 * 得到分页的SQL
	 * @param offset 	起始筆數
	 * @param limit		最後比數
	 * @return	分页SQL
	 */
	public static String getLimitString(String querySelect,int offset, int limit) {
		
		querySelect		= getLineSql(querySelect);
		
		StringBuilder pagingSelect = new StringBuilder(querySelect.length() + 25);

		pagingSelect.append(querySelect);
		
		pagingSelect.append(" limit "+offset+" , "+limit);
		return pagingSelect.toString();
		
	}
	
	/**
	 * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
	 * 
	 * @param sql SQL语句
	 * @return 如果sql是NULL返回空，否则返回转化后的SQL
	 */
	private static String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}
}
