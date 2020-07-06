package com.biz.student.service;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.biz.student.domain.StudentVO;

/*
 * StudentServiceImpIv1 에서 정의된
 */
public class StudentServiceImpIV2 extends StudentServiceImpIV1 {

	protected PrintStream outPut;
	

	public StudentServiceImpIV2() {
		String studentFile = "bin/com/biz/student/exec/StudentList.txt";
		System.out.println("콘솔에 데이터 출력하기");
		// exception Handling
		// 파일을 작성하는 과정에서 아무리 코드를 잘 적성해도 운영체제 차원의 발생하는 exception은
		// 코드에서 처리가 어렵다는 것을 컴파일러가 알고 있기 때문에
		// 개발자에게 의무적으로 처리를 exception하도록 규정하고있다
		try {
			outPut = new PrintStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(studentFile + "파일을 만들수 없음");
				return ;
		}
	}



// V1에서 구현된  studentList()method 를 다시 새롭게 구현하겠다	
	// List를 Console에보여주는방식이었는데
	// List결과를 file에저장하여 프로젝트가 종료되어도 언제든지
	// 결과를 확인학수있도록 구현해보자
	// 데이터 결과를 파일로 저장하는 것은 결과를 영구 적으로 보관하는 목적이있다
	// 이러한 것을 project에서 persistance라고한다.

	@Override
	public void studentList() 
	{


		// system.out 시스템 객체를 printstream type의 outPut객체에복사

		outPut.println("==============================================");
		outPut.println("학생 일람표");
		outPut.println("==============================================");
		outPut.println("학번\t이름\t학년\t학과");
		outPut.println("==============================================");
		
		for (StudentVO sVO : studentlist) {
			outPut.print(sVO.getNum() + "\t");
			outPut.print(sVO.getName() + "\t");
			outPut.print(sVO.getGrade() + "\t");
			outPut.print(sVO.getDept() + "\t\n");
		}
		outPut.close();


		}

}
