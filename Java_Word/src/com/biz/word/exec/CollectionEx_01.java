package com.biz.word.exec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionEx_01 {
	public static void main(String[] args) {
		
		String nation = "KOREA";
		String[] nations = nation.split("");// 알파펫 단위로 분해
				
	// Arrays.asList<배열> : 배열을 List형 데이터로 변환	
		List<String> words =Arrays.asList(nations);
		
		// Collectuins 클래스의 기능을 몇가지 사용하기위해서  배열을 List형데이터로 변환 했다
		
		
		// String Integer Long Float Charactor Boolean 같은
		//Wrapper class를 포함하는 List데이터를
		//오름차순 정렬하는 매우 간단한 메서드이다
		//Collections 의 sort() method 는 내부 알고리즘이 Quick Sort 이므로
		//사용하는데 아무런 제약이 없이 사용해도 된다
		Collections.sort(words);// 오름차순
		System.out.println(words);
		
		// List에 포함된 item들은 뒤죽박죽하게 섞는 기능을 수행한다
		Collections.shuffle(words);
		System.out.println(words);
		
		
	}

}
