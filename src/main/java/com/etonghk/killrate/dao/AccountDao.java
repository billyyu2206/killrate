package com.etonghk.killrate.dao;

import org.apache.ibatis.annotations.Mapper;

import com.etonghk.killrate.domain.Account;

/**
 * 
 * @author Ami
 *
 */
@Mapper
public interface AccountDao {

	int insert(Account record);

    Account selectByPrimaryKey(Integer id);
    
    Account selectByName(String name);
    
    void update(Account account);
    
    Account login(String account,String password);
}