package com.etonghk.killrate.awardNmber.convert;

import com.etonghk.killrate.vo.BetRecordBean;

public interface BetDataConvert<T> {

	public BetRecordBean convertBetRecord(T oriBetRecord);
}
