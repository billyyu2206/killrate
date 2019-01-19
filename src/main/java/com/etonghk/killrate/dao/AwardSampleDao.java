package com.etonghk.killrate.dao;

import java.util.List;

import com.etonghk.killrate.domain.AwardSample;
import com.etonghk.killrate.domain.AwardSampleKey;

/**
 * @author Billy.Yu
 * @date 2019年1月18日
 */
public interface AwardSampleDao {
    int insert(AwardSample record);

    AwardSample selectByPrimaryKey(AwardSampleKey key);
    
    List<AwardSample> selectAll();
}