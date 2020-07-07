package com.biz.word.exec;

import com.biz.word.service.WordGameService;
import com.biz.word.service.WordGameServiceV3;

public class CollectionEx_02 {

	public static void main(String[] args) {

		WordGameService wVO =new WordGameServiceV3();
		wVO.loadWord();
		wVO.playGame();
		wVO.FameOver();
		
		
		
		
	}
}
