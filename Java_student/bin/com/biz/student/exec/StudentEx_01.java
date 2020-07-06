package com.biz.student.exec;

import com.biz.student.service.StudentServiceImpIV1;

public class StudentEx_01 {
	public static void main(String[] args) {
		
		StudentServiceImpIV1 sService = new StudentServiceImpIV1();
		while (true) {
			if (!sService.inputStudent()) {
				break;

			}
		}
		sService.studentList();

	}

}
