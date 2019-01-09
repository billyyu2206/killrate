package com.etonghk.killrate.awardNmber.ssc.rx;

public class RxBase {
	
    protected  int getRxNum(String playId) {
    	String lastChar = playId.substring(playId.length()-3, playId.length()-2);
    	return Integer.valueOf(lastChar);
    }

}
