package com.etonghk.killrate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jack.entity.GameLotteryOrder;

/**
 * 
 * @author Billy
 *
 */
@Mapper
public interface BetRecordDao {

	int insertPurseRec(@Param("order") GameLotteryOrder order, @Param("lottery") String lottery,
			@Param("date") String date);

	void createPurseTable(@Param("lottery") String lottery, @Param("date") String date);

	int checkTableExist(@Param("lottery") String lottery, @Param("date") String date);

	List<GameLotteryOrder> selectPurseByLotteryAndIssue(@Param("lottery") String lottery, @Param("issue") String issue,
			@Param("date") String date);
}