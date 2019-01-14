package com.etonghk.killrate.dao;

import org.apache.ibatis.annotations.Mapper;

import com.etonghk.killrate.entity.Account;

/**
 * 
 * @author Ami
 *
 */
@Mapper
public interface IAccountDao {

	int insert(Account record);

    Account selectByPrimaryKey(Integer id);
}