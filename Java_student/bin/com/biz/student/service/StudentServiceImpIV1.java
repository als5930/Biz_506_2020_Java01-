package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.student.domain.StudentVO;

public class StudentServiceImpIV1 implements StudentService {
	List<StudentVO> studentlist;

	public StudentServiceImpIV1() {
		/*
		 * 필드변수
		 * class Scope의 변수를 선언하기
		 * 여기(필드변수 영역)에 선언된 변수는
		 * 현제 클래스의 모든 method들이 공유하고ㅓ 참조(쓰기,읽기)기 가능하다
		 * 
		 * 변수의 scope
		 * 변수를 선언할때 어디에 선언하느냐에 따라 변수를 참조할수 있느냐 없느냐가 결정된다
		 * 
		 * 필드변수를 선언할때 접근제한자를 public private protected 중에 한가지로
		 * 설정할수있다
		 *
		 * 필드변수를 선언할때 가급적 public으로 선언하는 것은 지양(하지말기)해야한다
		 * 필드변수를 public으로 선언해 놓으면 외부에서 필드변수에 직접접근하여 
		 * 값을 변형시킬수있다 그러하면 예기치 못한 결과를 얻을수있다
		 * 
		 * 필드변수를 private으로 선언하는것은
		 * 객체의 정보은닉 캡슐화 패턴에 적함한 방식이다
		 * 외부에서 접근하지 못하도록 차단하고 현제클래스에 선언된 method에서만
		 * 접근을 허용하는것이다
		 * 혹시 필드변수를 외부에서 접근할 필요가 있는경우 getter setter를 만든다
		 * 
		 * 필드변수를 protected로 선언하기
		 * protected는 private접근제한자와 거의 유가형태이다
		 * 만약 현제 클래스를 다른 클래스를 만들때 상속(extends)하여 사용하고자 할때는
		 * 상속받은 클래스에서 현제 클래스의 필드변수를 같이 상속받아서 사용하고자 할때는
		 * 변수 protected로 선언한다
		 * 
		 * 현재 클래스애서는 private처럼 작동하고 
		 * 상속받은 클래스에서도 마치 자신이 변수를 선언한것처럼 사용할수ㅇ있게된다
		 * 
		 * 현재클래스를 상속할수있고록 생각을 하고 구현
		 * 필드변수 protected로 선언을한다
		 * 
		 * 만약 private으로 선언을 하게되면 상속받은 클레스에서 변수들을
		 * 다시선언해주어야한다
		 */
		
		
		/*
		 * 클래스 생성자
		 * 클래스 객체(인스턴스)로만들떄 호출되는 메서드
		 * 클래스 객체로 생성할때1번 호출되는 메서드로 반드시(초기화)
		 */
		studentlist = new ArrayList<StudentVO>();
	}

	@Override
	public boolean inputStudent() {
		Scanner scan = new Scanner(System.in);
		StudentVO studentVO = new StudentVO();

		System.out.print("학번(END:입력중단)");
		String strnum = scan.nextLine();
		if (strnum.equals("END")) {
			return false;
		}
		studentVO.setNum(strnum);

		System.out.print("이름");
		String strname = scan.nextLine();
		studentVO.setName(strname);

		System.out.print("학년");
		String strgrade = scan.nextLine();
		int intGrade = 0;
		try {
			intGrade = Integer.valueOf(strgrade);
		} catch (Exception e) {
			System.out.print("학년은 숫자만 가능");
			System.out.println(studentVO.getName()+"학생정보를 다시입력해주세요");
			return true;
		}
		//유효성 검사
		//현제 입력된 정보가ㅣ 정상법위(validate)에 있는지 검사하여
		// 데이터를 사용할지 말지를 결정하고
		//입력하는 사용자에게 통보하고 다른 행동을 취할수있도록 하는것
		//유효성검사는 개발자 입장에서는 매우귀찮은 단순노동일 경우가 많지만
		//사용자입장에서는 유효성검사가 많으면 그만큼 잘못된 데이터응 입력하는 경우를 방지할수있다
		
		if(intGrade <1 ||intGrade >4) {
			System.out.println("학년은 1~4학년까지만가능");
			System.out.println(studentVO.getName()+"학생정보를 다시입해주세요");
			return true;
		}
		
		
		studentVO.setGrade(intGrade);
		System.out.println("전공과목");
		String strdept = scan.nextLine();
		studentVO.setDept(strdept);

		//제일 끝의 return문은 한 학생의 정보가 모두 정상입력이 되면 true를 return하여 다음학생정보를 입력하도록
		// 호출한 곳에 통보(return) 해야하는데 이떄 true를 return하도록해야한다
		studentlist.add(studentVO);
		return true;
		
	}

	@Override
	public void studentList() {
	

	}

}
