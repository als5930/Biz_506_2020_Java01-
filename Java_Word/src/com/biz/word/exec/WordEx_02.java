package com.biz.word.exec;

import com.biz.word.service.WordGameService;
import com.biz.word.service.WordGameServiceV1;

public class WordEx_02 {
	
	public static void main(String[] args) {
		
		WordGameService wVO =new WordGameServiceV1();
		wVO.loadWord();
		wVO.playGame();
		wVO.FameOver();
		
		
	}
	
	
}
