package com.biz.word.service;

public interface WordGameService {
	// word.txt 파일에서 데이터를 읽어서 wordList 만들기
	public void loadWord();
	// 단어를 보여주고 게임실행하기
	public void playGame();
	// game over 가 되었을때 점수등 보여주기
	public void FameOver();
;
}
