package com.biz.student.exec;

import com.biz.student.service.StudentService;
import com.biz.student.service.StudentServiceImpIV2;

public class StudentEx_02 {
	public static void main(String[] args) {

		StudentService sService = new StudentServiceImpIV2();

		while (true) {
			if (!sService.inputStudent()) {
				break;
			}
		}
		sService.studentList();

	}
}
