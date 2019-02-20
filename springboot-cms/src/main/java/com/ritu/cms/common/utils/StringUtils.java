package com.ritu.cms.common.utils;

public class StringUtils {
	
	public static String toSqlIn(String content){
		StringBuilder wq = new StringBuilder("");
		if(CommonUtils.isNotEmptry(content)){
			String[] arr = content.split(",");
			wq.append("(");
			for(int i =0; i < arr.length; i++){
				wq.append("'").append(arr[i]).append("'");
				if(i != arr.length - 1){
					wq.append(",");
				}
			}
			wq.append(")");
		}
		return wq.toString();
	}
	
	public static String toSqlRange(String range){
		int n = 0;
		for (int i = 0; i < range.length(); i++) {
			char c = range.charAt(i);
			if (c == ',') {
				n++;
				if (n % 2 == 1) {
					range = range.substring(0, i) + " " + range.substring(i + 1);
				}
			}
		}
		return range;
	}
	
	
	public static String comma2Space(String word){
		return word.replace(",", " ");
	}
}
