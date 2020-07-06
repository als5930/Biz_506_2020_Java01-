package com.biz.student.exec;

import com.biz.student.service.ScoreService;
import com.biz.student.service.ScoreServiceImpIV1;

public class Ex {

	public static void main(String[] args) {
		ScoreService sScore =new ScoreServiceImpIV1(); 
		
		sScore.inputStudent();
		sScore.inputScore();
		sScore.calcSum();
		sScore.calcAvg();
		sScore.scoreList();

	}
	
}
