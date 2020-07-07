package com.biz.word.exec;

import java.awt.RadialGradientPaint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.biz.word.domain.WordVO;
import com.biz.word.statics.SplitPosition;

public class WordEx_01 {
	public static void main(String[] args) {

		String wordFile = "src/com/biz/word/exec/word.txt";
		List<WordVO> wordList = new ArrayList<WordVO>();

		// 파일을 open 하기위한 객체
		FileReader fileReader = null;

		// fileReader와 연동하여 파일은 읽어올때 효율적으로 가져오기 위한 Helper class
		BufferedReader buffer = null;

		// fileReader를 사용하여 wordFile 읽기전용도로 open

		/*
		 *
		 */
		try {
			fileReader = new FileReader(wordFile);

			// buffer는 파일을 읽어서 임시 버퍼영역에 보관한다
			buffer = new BufferedReader(fileReader);

			/*
			 * 
			 * buffer.readLine()method를 호출하여 buffer로 부터 한줄씩 데이터를 읽어온다
			 * 
			 */
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}

				// 읽어들인 데이터를 콜론(:)을기준으로
				// 문자열 분해를 하여words배열에 담아달라
				String[] words = reader.split(":");

				WordVO wVO = new WordVO();
				wVO.setEng(words[SplitPosition.WORD_ENG]);// words[0]
				wVO.setKor(words[SplitPosition.WORD_KOR]); // words[1]
				wordList.add(wVO);

			}
			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
		Random rnd = new Random();
		int size = wordList.size();
		Scanner scan =new Scanner(System.in);
		
		int count=0;
		int game =0;
		while (true) {
			int index = rnd.nextInt(size);// 0~ (wordList 개수-1)중의 한수
			System.out.println("다음에 해당하는 영어단어는?(END:종료)");
			System.out.println(wordList.get(index).getKor()+">>"); 
			String strEng=scan.nextLine();
			if(strEng.equals("END")) {
				break;
			}
			game ++;
			if(strEng.equalsIgnoreCase(wordList.get(index).getEng())) {
				System.out.println("맞았습니다 축하합니다");
				count++;
			}else {
				System.out.println("아쉽네요");
				System.out.println(wordList.get(index).getEng());
			}
				
		}
System.out.println("GAME OVER!!");
System.out.printf("%d 게임중 %d 번 정답 맞춤!!", game,count);
	}

}
