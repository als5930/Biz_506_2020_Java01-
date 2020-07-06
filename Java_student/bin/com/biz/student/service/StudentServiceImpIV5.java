package com.biz.student.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.biz.student.domain.StudentVO;

public class StudentServiceImpIV5 extends StudentServiceImpIV2 {

	public StudentServiceImpIV5() {
		outPut = System.out;
	}

	@Override
	public boolean inputStudent() {
		// TODO Auto-generated method stub

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

				//System.out.println(reader);
				String[] students = reader.split(":");
				
				if(students[4].equals("컴퓨터공학")) {
					
					StudentVO sVO = new StudentVO();
					sVO.setNum(students[0]);
					sVO.setName(students[1]);
					sVO.setGrade(Integer.valueOf(students[2]));
					sVO.setDept(students[4]);
					studentlist.add(sVO);
					
				}
			}
			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
