package com.etonghk.killrate.awardNmber.ssc.rx;

import com.etonghk.killrate.awardNmber.AwardNumber;

public class RxBase {
	
    protected  int getRxNum(String playId) {
    	String lastChar = playId.substring(playId.length()-3, playId.length()-2);
    	return Integer.valueOf(lastChar);
    }

    protected String[] getBetPos(String betItems) {
		String[] posTemp = betItems.split("]")[0].substring(1).split(",");
		String posStr = "";
		for(int i = 0; i < posTemp.length; i++) {
			if(posTemp[i].equals(AwardNumber.BetPosItem)) {
				posStr += i;
			}
		}
		return posStr.split("");
	}
}
