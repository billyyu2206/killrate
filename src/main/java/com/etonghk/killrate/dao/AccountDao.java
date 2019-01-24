package com.etonghk.killrate.dao;

import java.util.List;

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
    
    void update(Account account);
    
    Account login(String account,String password);
    
    void updateLogin(Account account);
    
    List<Account> selectByCondition(Account account);
}