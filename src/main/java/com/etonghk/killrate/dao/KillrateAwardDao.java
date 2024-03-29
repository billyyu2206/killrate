package com.etonghk.killrate.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etonghk.killrate.controller.dto.request.KillrateSetting;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;

public interface KillrateAwardDao {
	
    int insert(KillrateAward record);
    int batchInsert(@Param("dataList") List<KillrateAward> dataList);
    KillrateAward selectByPrimaryKey(Integer id);
    int deleteForGenerateKillrate(KillrateSetting setting);
    List<KillrateAward> selectForSettingPage(@Param("cond")KillrateAward cond,@Param("page")Page<KillrateAward> page);
    List<KillrateAward> selectForGenerateKillrate(KillrateSetting setting);
    
    int updateByPK(@Param("record")KillrateAward record, @Param("operateTime") LocalDateTime operateTime);
    
    int deleteByPK(@Param("record")KillrateAward record, @Param("operateTime") LocalDateTime operateTime);
    
    public List<KillrateAward> selectForRecord(@Param("lottery") String lottery,@Param("issueDate") LocalDateTime issueDate,@Param("isPush") Boolean isPush,@Param("page") Page<KillrateAward> page);
    
    public KillrateAward selectForCalNumber(@Param("lottery") String lottery,@Param("issue") String issue);
    
    int updateForAward(KillrateAward record);
    
    List<KillrateAward> selectForRefreshCache();
    
    int updateAwardPushStatus(@Param("id")Integer id);
}