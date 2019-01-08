package com.etonghk.killrate;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.etonghk.killrate.killerUtils.SSCKillerUtils;
import com.etonghk.killrate.vo.BetRecordBean;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C://testlog/log.txt"), "utf-8"));

			HashMap<String, String> sscAwardProfitMap = SSCKillerUtils.getNewSSCAwardMap();
			List<BetRecordBean> betList = new ArrayList<BetRecordBean>();
//			BetRecordBean bean1 = new BetRecordBean();
//			bean1.setGamePlayId("SSC001001001");
//			bean1.setBetItem("1&2&3|1|1|1|1");
//			bean1.setOdds(BigDecimal.valueOf(100));
//			bean1.setBetMultiplier(2);
//			bean1.setBetAmount(BigDecimal.valueOf(6));
//			
//			betList.add(bean1);
			
			BetRecordBean bean2 = new BetRecordBean();
			bean2.setGamePlayId("SSC003003004");//後三組選和值
			bean2.setBetItem("4");
//			bean2.setOdds(BigDecimal.valueOf(100));
			bean2.setOddsGroup("329.99,164.99");
			bean2.setBetMultiplier(2);
			bean2.setBetAmount(BigDecimal.valueOf(8));
			
			betList.add(bean2);
			
			sscAwardProfitMap = SSCKillerUtils.getSSCAwardMap(sscAwardProfitMap, betList);

			for (String key : sscAwardProfitMap.keySet()) {
				writer.write(key + ": " + sscAwardProfitMap.get(key) + "\n");
			}
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		} catch (Exception e) {
			e.printStackTrace();
			try {writer.close();} catch (Exception eex) {/*ignore*/}
		}
	}

	private static void testWriteLog(String data) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter("C://testlog/log.txt", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(data);
			return;
		} catch (IOException localIOException1) {
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
