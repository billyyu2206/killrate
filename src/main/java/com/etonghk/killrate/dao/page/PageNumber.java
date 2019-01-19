/**
 * 
 */
package com.etonghk.killrate.dao.page;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
public interface PageNumber {

	int getOffset(Page<?> page);

	int getLimit(Page<?> page);

}
