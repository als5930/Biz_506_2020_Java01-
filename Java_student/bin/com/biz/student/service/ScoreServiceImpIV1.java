package com.biz.student.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.student.domain.StudentVO;

public class ScoreServiceImpIV1 implements ScoreService {
	protected List<StudentVO> studentList;

	public ScoreServiceImpIV1() {
		studentList = new ArrayList<>();
	}

	@Override
	public void inputStudent() {
		String studentFile = "bin/com/biz/student/exec/Student.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {

			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				
				String[] students = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setNum(students[0]);
				sVO.setName(students[1]);
				
				studentList.add(sVO);
			}
			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void inputScore() {
		String studentFile = "bin/com/biz/student/exec/Score.tex";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}

				String[] students = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setKor(Integer.valueOf(students[1]));
				sVO.setEng(Integer.valueOf(students[2]));
				sVO.setMath(Integer.valueOf(students[3]));
				sVO.setSum(Integer.valueOf(students[4]));
				sVO.setAvg(Float.valueOf(students[5]));
				studentList.add(sVO);
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void calcSum() {
		int size = studentList.size();
		int intSum =0;
		for(int i=0; i<size;i++) {
			
			StudentVO studentVO = studentList.get(i);
			intSum = studentVO.getKor() + studentVO.getEng() + studentVO.getMath();
			
			}
	}

	@Override
	public void calcAvg() {
		int size = studentList.size();
		int intAvg =0;
		for(int i=0; i<size;i++) {
			StudentVO studentVO = studentList.get(i);
			intAvg = studentVO.getKor() + studentVO.getEng() + studentVO.getMath() + studentVO.getSum();
			
		}
	}

	@Override
	public void scoreList() {
		System.out.println("=====================================");
		System.out.println(" 성적 알람표");
		System.out.println("-------------------------------------");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=====================================");
		
		int size = studentList.size();
		for(int i=0; i<size;i++) {
			StudentVO studentVO = studentList.get(i);
			System.out.println(studentVO.getNum()+"\t"
								+ studentVO.getName()+"\t"
								+ studentVO.getKor()+"\t"
								+ studentVO.getEng()+"\t"
								+ studentVO.getMath()+"\t"
								+ studentVO.getSum()+"\t"
							    + studentVO.getAvg()+"\t");
				
		}
		
		
		
		
		
		
		

	}

}
