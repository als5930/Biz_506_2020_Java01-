package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import daum.BoxOfficeDaum;
import nave.BoxOfficeNaver;
import nave.ReplyCrawlerNaver;

public class SimpleMovieMain {



	public static void main(String[] args) throws Exception {
		BoxOfficeParser bParser = new BoxOfficeParser(); // 생성자 : 객체생성과 동시에 +a 작업을 하고 싶음
		BoxOfficeNaver bon = new BoxOfficeNaver();
		BoxOfficeDaum don = new BoxOfficeDaum();
		ReplyCrawlerNaver nCrawler = new ReplyCrawlerNaver();
		// 순위, 영화제목, 예매율, 장르, 상영시간, 개봉일자, 감독, 출연진, 누적관객수, 누적매출액, 네이버코드, 다음코드
		String[][] mvRank = new String[10][12];
		// 1. 박스오피스 정보 + 네이버 영화정보 + 다음 영화정보 (1~10위)
		// 1-1. BoxOffice Parsing :)
		mvRank = bParser.getParse();
		// 1-2. Naver BoxOffice Crawling :)
		mvRank = bon.naverMovieRank(mvRank);
		// 1-3. Daum BoxOffice Crawling :)
		mvRank = don.daumMovieRank(mvRank);
		// view단 실행
		
		// 2. 정보없는 영화 선택했을때
		int userVal = userInterface(mvRank);	
		
		
		userVal = userInterface(mvRank);
		nCrawler.naverCrawler(mvRank[userVal-1][10]);

	 
	
	}
		
		// VIEW : 프로그램 시작 인터페이스 + 사용자 값 입력
	public static int userInterface(String[][] mvRank) {
		Scanner sc = new Scanner(System.in);
	int userVal =0; // 사용자 입력값 변수
		// 2 View단
		// userVal = 사용자가 입력한 영화 번호
	
		 
		//3. 사용자가 선택한 영화의 네이버 다음 댓글 정보를 수집 및 분석
		

		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String today = sdf.format(cal.getTime());
		SimpleDateFormat engSdf = new SimpleDateFormat("MM.dd", Locale.ENGLISH);
		String engDay = engSdf.format(cal.getTime());
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH));

		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▦▦ >> Developer : als5930");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒>> TODAY :" + today);
		System.out.println(
				"▒▒박스오피스 예매율" + (cal.get(Calendar.MONTH) + 1) + "월" + cal.get(Calendar.DATE) + "일 박스오피스 1~10위");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒>> BoxOffice Rank(" + engDay + ")");

	for (int i = 0; i < mvRank.length; i++) {
		String noneCode = ""; // 초기화
		if (mvRank[i][10] == null) {
			noneCode = "(정보 없음)";
		}
		System.out.println("▒▒" + mvRank[i][0] + "위 :" + mvRank[i][1] + noneCode);
	}
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	// 2-2 사용자가 입력하는 부분
	while (true) {

		System.out.println("▒▒>> 보고싶은 영화 번호(순위)를 입력하세요");
		System.out.println("▒▒>> 번호 :");
		userVal = sc.nextInt();
		
	
		
		// 유효성 체크
		// id // 1) null값 체크 2) 길이체크 3) 공백값 체크 4) 정규식체크 5) id의 길이 체크
		// >> 1~10까지의 값(정상)
		// 1. 1~10이외의 숫자를 넣었을때
		// 2.정보없는 영화 선택했을때

		if (userVal < 0 || userVal > 10) {
			// 잘못된값!
			System.out.println("▒▒ >>[warning] 1~10사이의 숫자를 입하세요 :");
			continue;
		} else if (mvRank[userVal - 1][10] == null) {
			// 사용자가 입력한 번호의영화가 정보가 있는지 없는지 체크
			System.out.println("▒▒ >>[warning] 해당 영화는 상영정보가 없습니다. 다른 영화를 선택해 주세요 :");
			continue;
		} else {
			// 통과 사용자의 값이 0~10
			sc.close();
			break;
		}
	}
	return userVal;
}

	// mvRank 출력하는 코드
	public static void printArr(String[][] mvRank) {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	for (int i = 0; i < mvRank.length; i++) {
		System.out.print(mvRank[i][0] + "\t");
		System.out.print(mvRank[i][1] + "\t");
		System.out.print(mvRank[i][2] + "\t");
		System.out.print(mvRank[i][3] + "\t");
		System.out.print(mvRank[i][4] + "\t");
		System.out.print(mvRank[i][5] + "\t");
		System.out.print(mvRank[i][6] + "\t");
		System.out.print(mvRank[i][7] + "\t");
		System.out.print(mvRank[i][8] + "\t");
		System.out.print(mvRank[i][9] + "\t");
		System.out.print(mvRank[i][10] + "\t");
		System.out.println(mvRank[i][11]);
	}
	System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	}

}