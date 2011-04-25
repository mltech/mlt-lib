package com.mltech.utils;

public enum Encoding {
	EUC_JP ("EUC-JP");
	
	private Encoding(String t) {
	}
	
	public static void main(String[] args) {
		System.out.println(Encoding.EUC_JP);
	}
}
