package com.etonghk.killrate.Helper;

import java.util.Map;

import com.etonghk.killrate.vo.BetRecordBean;

public interface ItemConvertHelper {

	public BetRecordBean convertBetRecord(Map<String,String> oriBetRecord);
}
