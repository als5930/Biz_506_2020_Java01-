package com.biz.student.string;

public class StringEx_02 {

	public static void main(String[] args) {

		String strNation = "Republic of Korea";

		// strNation에 담긴 문자열에서 9<=x<11범위의 문자열의 잘라서
		// subNation
		String subNation = strNation.substring(9, 11);
		System.out.println(subNation);

		int strLength = strNation.length();

		for (int i = 0; i < strLength; i++) {
			String s = strNation.substring(i, i + 1);
			System.out.println(s);

		}
		// 문자열을 한글자 씩 분해하여 문자 배열로 변환하여strNation 담는다
		char[] charNations = strNation.toCharArray();
		for (int i = 0; i < charNations.length; i++) {
			System.out.println(charNations[i] + "\t");
		}
		System.out.println();

		// 문자열을 한글잤ㄱ 분해하여 문자열 배열로 변환 하여strNation에 담는다
		String[] strNations = strNation.split("");
		for (int i = 0; i < strNations.length; i++) {
			System.out.println(charNations[i] + "\t");
		}
	}
}
