package com.biz.student.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentServiceImpIV3 extends StudentServiceImpIV2 {

	/*
	 * V2는V1을 상속을 받아서 studentList() method를 재정의(Override)해 놓은 상태이다
	 * V3는V2를 상속받아서 V2에 구현된 studentList() method는 그대로 사용하고
	 * V1 에있는 inputStudent()method만 재정의하여 V3를만들겠다라는의미
	 * 
	 * V3에서는 student.txt파일 을 잀어서
	 * 학생정보를 가져오고 studentList()method 사용하여 출력해보기
	 */
	@Override
	public boolean inputStudent() {
		// TODO Auto-generated method stub
		
		
		String studentFile= "/Java_student/student.txtt";

		/*
		 * fileReader 클래스로 fileReader 객체(인스턴스)를 선언하고 clear하기
		 * 문자열 숫자등이 아닌 정체를 알수없는 클래스로 객체를 선언할때는 
		 * 가급적null로 clear를 시켜주는것이좋다
		 */
		FileReader fileReader=null;
		
		/*
		 * 로컬디스크에 저장된 파일을 읽을때 FileReader만으로 읽을수 있지만
		 * 파일을 읽어들이는 성능상의 잇점을 주기위해서 주간 BufferedReader를 
		 */
		BufferedReader buffer =null;
		try {
			// 읽어들일 파일을 열고 파일에 관련된 정보를 fileReader객체에 저장
			fileReader =new FileReader(studentFile);
			// fileReader 객체에 저장된 정보를 buffer관리자에 전달하여 파일을 읽도록 지시
			// buffer 관리자는 파일을 몽땅 읽어서 자신이 관리하는 buffer장치에 임시보관
			buffer = new BufferedReader(fileReader);
			
			// 문자열변수의 경루 for while 반복문내에서 계속해서 
			//선언 하는 것은 메모리관리상 매우 좋지 않다
			// 따라서 문자열 변수는 반복문이 실행되기전에 먼저선언, clear를 진행하는것이 좋다
			String reader = "";
			/*
			 * 파일의 라인수가 200개로 정해지고 그 라인수를 
			 */
			//for(int i=0;i<200;i++) {
				//buffer.readLine();
				//System.out.println(reader);
					
			//}
			
			//하지만 파일은 강황에 따라 라인수가 변동 될수도 있고
			/*
			 * 라인수를 예측하지 못하는 상황이 올수도있다
			 * 즉, 반복문을 수행해야항 횟수를 정라지 못할수도있다
			 * 이럴때는 for 반복문보다는 while문을 사용하는것이 좋다
			 */
			
			while(true) {
				
				// buffer.readLine() method는 호출될때마다
				// buffer로 부터 파일을 한줄씩 읽어서 reader변수에 담는다
				 //buffer로부터 파일을 읽어오다가 파일을 모두 읽었는데도 불구하고
				// 또 readLine() method를 호출하면 null 값이 return되고
				//그러면 reade
				reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				System.out.println(buffer);
			}
			
			
			// buffer장치로부터 text 내용을 1줄씩 읽어 들이기
			
			
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	

}
