package com.biz.word.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.word.domain.WordVO;

public class WordGameServiceV3 extends WordGameServiceV1 {

	/*
	 * List ArrayList와같은 클래스유를 Collection이라고 한다
	 * 다수의 데이터를 담을수 있는 클래스들이며 VO들을 담아서 연산을 수행하는 목적으로 사용한다
	 * 
	 * Collection 클래스들은 Collections 라는 클래스의 자손들이다
	 */
	

	// List<WordVO> wordList count game 상속
	// loadGame() plyGame() gameOver()  상속 받는다
	// plyGame() 재정의
	
	
	@Override
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		count =0;
		game =0;
		while(true) {
			
			// shuffle()을 사용하여 wordList를 뒤섞고 그중0번쨰 위치의 값을 추출한다
			Collections.shuffle(wordList);
			WordVO wordVO= wordList.get(0);
			
			// VO에서 영단어를 추출하여 split()으로 분해한후 words배열에 담기 
			String[] words =wordVO.getEng().split("");
			List<String> wordList =Arrays.asList(words);
			
			System.out.println("다음알파벳을 단어 순서에 나열하시오");
			System.out.print(wordList);
			String strInput =scan.nextLine();
			if(strInput.equals("END")) {
				break;
			}
			
		if(wordVO.getEng().equalsIgnoreCase(strInput)) {
				System.out.println("맞았습니다");
				System.out.println(wordVO.getEng());
				System.out.println(wordVO.getKor());
				count++;
			}else {
				System.out.println("아쉽네요");
			}
			
			
		}
	}
}
	

