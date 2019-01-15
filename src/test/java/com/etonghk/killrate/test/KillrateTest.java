package com.etonghk.killrate.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.etonghk.killrate.killerUtils.SSCKillerUtils;
import com.etonghk.killrate.utils.CommonUtils;
import com.etonghk.killrate.vo.BetRecordBean;

public class KillrateTest {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://testlog/log.txt"), "utf-8"));

			Map<String, String> sscAwardProfitMap = SSCKillerUtils.getNewSSCAwardMap();
			List<BetRecordBean> betList = new ArrayList<BetRecordBean>();
//			BetRecordBean bean1 = new BetRecordBean();
//			bean1.setGamePlayId("SSC001001001"); // 五星直選
//			bean1.setBetItem("1&2&3|1|1|1|1");
//			bean1.setOdds(BigDecimal.valueOf(100));
//			bean1.setBetMultiplier(2);
//			bean1.setBetAmount(BigDecimal.valueOf(6));
//			betList.add(bean1);
			
//			BetRecordBean bean2 = new BetRecordBean();
//			bean2.setGamePlayId("SSC003003004"); // 後三組選和值
//			bean2.setBetItem("4");
////			bean2.setOdds(BigDecimal.valueOf(100));
//			bean2.setOddsGroup("329.99,164.99");
//			bean2.setBetMultiplier(2);
//			bean2.setBetAmount(BigDecimal.valueOf(8));
//			betList.add(bean2);
			
			BetRecordBean bean3 = new BetRecordBean();
			bean3.setGamePlayId("FFCLongHuDouWQ"); // 后三一码不定胆
			bean3.setBetItem("龙");
			bean3.setOdds(BigDecimal.valueOf(10));
			bean3.setBetMultiplier(2);
			bean3.setBetAmount(BigDecimal.valueOf(2));
			betList.add(bean3);
			
			 
			sscAwardProfitMap = SSCKillerUtils.getSSCAwardMap(sscAwardProfitMap, betList);
			sscAwardProfitMap = CommonUtils.sortByValueDesc(sscAwardProfitMap);
			for (String key : sscAwardProfitMap.keySet()) {
				writer.write(key + ": " + sscAwardProfitMap.get(key) + "\n");
			}
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		} catch (Exception e) {
			e.printStackTrace();
			try {writer.close();} catch (Exception eex) {/*ignore*/}
		}
	}

}
