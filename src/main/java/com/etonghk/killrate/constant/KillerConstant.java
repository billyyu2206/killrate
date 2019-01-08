package com.etonghk.killrate.constant;

import java.util.ArrayList;
import java.util.List;

public class KillerConstant {
	public static final List<String> LOSS_PROFIT_LHC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_BSC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_SSC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_TBSC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_TSSC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_K3_GAMEIDS;
	public static final List<String> LOSS_PROFIT_XX5_GAMEIDS;
	public static final List<String> LOSS_PROFIT_K3_MMC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_SSC_MMC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_LHC_MMC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_MMC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_NOT_MMC_GAMEIDS;
	public static final List<String> LOSS_PROFIT_ALL_GAMEIDS;
	public static final List<String> LOSS_PROFIT_XX5_TASK_GAMEIDS;
	public static final List<String> LOSS_PROFIT_LHC_TASK_GAMEIDS;
	public static final List<String> LOSS_PROFIT_BSC_TASK_GAMEIDS;
	public static final String SSC_LOSS_PROFIT_KEY = "sscAwardProfit";
	public static final String K3_LOSS_PROFIT_KEY = "k3AwardProfit";
	public static final String BSC_LOSS_PROFIT_KEY = "bscAwardProfit";
	public static final String LHC_LOSS_PROFIT_KEY = "lhcAwardProfit";
	public static final String TSSC_LOSS_PROFIT_KEY = "tsscAwardProfit";
	public static final String TBSC_LOSS_PROFIT_KEY = "tbscAwardProfit";
	public static final String XX5_LOSS_PROFIT_KEY = "xx5AwardProfit";
	public static final String totBetAmount = "totBetAmount";
	public static final String LHC_NUM_CFG_KEY = "lhcNumberConfig";
	public static final String BetLineSplit = "[|]";
	public static final String BetItemSplit = "[&]";
	public static final String BetBlankSplit = " ";

	static {
		// 六合彩
		LOSS_PROFIT_LHC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_LHC_GAMEIDS.add("OG1LHC");
		
		// 賽車
		LOSS_PROFIT_BSC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_BSC_GAMEIDS.add("JLPK10");

		// 時時彩
		LOSS_PROFIT_SSC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_SSC_GAMEIDS.add("JLFFC");

		// 傳統賽車
		LOSS_PROFIT_TBSC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_TBSC_GAMEIDS.add("CTOG1BSC");

		// 傳統時時彩
		LOSS_PROFIT_TSSC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_TSSC_GAMEIDS.add("CTOG1SSC");

		// 快三
		LOSS_PROFIT_K3_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_K3_GAMEIDS.add("OG1K3");
		LOSS_PROFIT_K3_GAMEIDS.add("CF1K3");

		// 11選5
		LOSS_PROFIT_XX5_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_XX5_GAMEIDS.add("OG111X5");
		LOSS_PROFIT_XX5_GAMEIDS.add("CF111X5");
		
		// 快三秒秒彩
		LOSS_PROFIT_K3_MMC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_K3_MMC_GAMEIDS.add("K3MMC");

		// 秒秒彩
		LOSS_PROFIT_SSC_MMC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_SSC_MMC_GAMEIDS.add("OGMMC");

		// 六合秒秒彩
		LOSS_PROFIT_LHC_MMC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_LHC_MMC_GAMEIDS.add("LHCMMC");

		// 所有秒秒彩
		LOSS_PROFIT_MMC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_MMC_GAMEIDS.addAll(LOSS_PROFIT_K3_MMC_GAMEIDS);
		LOSS_PROFIT_MMC_GAMEIDS.addAll(LOSS_PROFIT_SSC_MMC_GAMEIDS);
		LOSS_PROFIT_MMC_GAMEIDS.addAll(LOSS_PROFIT_LHC_MMC_GAMEIDS);

		// 所有非秒秒彩
		LOSS_PROFIT_NOT_MMC_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_SSC_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_K3_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_BSC_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_LHC_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_TSSC_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_TBSC_GAMEIDS);
		LOSS_PROFIT_NOT_MMC_GAMEIDS.addAll(LOSS_PROFIT_XX5_GAMEIDS);

		// 所有殺率彩種
		LOSS_PROFIT_ALL_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_ALL_GAMEIDS.addAll(LOSS_PROFIT_NOT_MMC_GAMEIDS);
		LOSS_PROFIT_ALL_GAMEIDS.addAll(LOSS_PROFIT_MMC_GAMEIDS);

		// 11選5排程
		LOSS_PROFIT_XX5_TASK_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_XX5_TASK_GAMEIDS.addAll(LOSS_PROFIT_XX5_GAMEIDS);

		// 六合彩排程
		LOSS_PROFIT_LHC_TASK_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_LHC_TASK_GAMEIDS.addAll(LOSS_PROFIT_LHC_MMC_GAMEIDS);
		LOSS_PROFIT_LHC_TASK_GAMEIDS.addAll(LOSS_PROFIT_LHC_GAMEIDS);

		// 賽車排程
		LOSS_PROFIT_BSC_TASK_GAMEIDS = new ArrayList<String>();
		LOSS_PROFIT_BSC_TASK_GAMEIDS.addAll(LOSS_PROFIT_BSC_GAMEIDS);
		LOSS_PROFIT_BSC_TASK_GAMEIDS.addAll(LOSS_PROFIT_TBSC_GAMEIDS);

	}
}
