package com.biz.student.service;

public interface ScoreService {

	// inputStudent() : student.txt 파일을 읽어서 studentList 를 작성 
	/*
	 * inputScore() score.txt 파일을 읽어서 scoreList 를작성
	 * 
	 * calcSum() calcAvg() : 총점 평균계산
	 * 
	 * scoreList() 학생별 과목 점수 총점 평균 출력
	 */
	
	public void inputStudent(); 
	public void inputScore();
	
	public void calcSum();
	public void calcAvg();

	
	/*
	 * ========================================================
	 * 성적 일람표
	 * =========================================================
	 * 학번 	이름 	국어 	영어 	수학 	총점 	평균
	 * --------------------------------------------------------
	 * 
	 */
	
	public void scoreList();
	
}
