package com.etonghk.killrate.constant;

public enum AmodeType {

	YUAN("1", 1), JIAO("0.1", 2), FEN("0.01", 4);

	private String value;
	private int modeid = 4;

	private AmodeType(String value, int modeid) {
		this.value = value;
		this.modeid = modeid;
	}

	public String getValue() {
		return this.value;
	}

	public int getModeid() {
		return this.modeid;
	}

	public String toString() {
		return this.value;
	}

	public static String getValue(int mode) {
		if (mode == 1) {
			return YUAN.getValue();
		}
		if (mode == 2) {
			return JIAO.getValue();
		}
		if (mode == 4) {
			return FEN.getValue();
		}
		return "0";
	}
}
