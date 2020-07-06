package com.biz.student.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class ScoreEx_03 {
	public static void main(String[] args) {

		PrintWriter outPut = null; //= System.out;
		String outFile = "src/com/biz/student/exec/Score.csv";
		
		try {
			outPut = new PrintWriter(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Random rnd = new Random();

		for (int i = 0; i < 30; i++) {
			int intKor = rnd.nextInt(50) + 51;
			int intEng = rnd.nextInt(50) + 51;
			int intMath = rnd.nextInt(50) + 51;

			int intSum = intKor + intEng + intMath;
			float floatAvg =(float) intSum / 3;

			// System.out.printf()
			String score = String.format("%05d:%d:%d:%d:%d:%06.2f", i + 1, intKor, intEng, intMath, intSum, floatAvg);

			outPut.println(score);

		}
		outPut.close();
		System.out.println("완료!!");

	}

}
