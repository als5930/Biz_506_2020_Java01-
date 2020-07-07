package deum;

import java.io.IOException;

import javax.swing.text.AbstractDocument.BranchElement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DaumMovie {

	public static void main(String[] args) throws IOException {
		int page = 1;
		int cnt = 0;
		int score = 0;
		String content = "";
		String writer = "";
		String reg_date = "";

		while (true) {
			String url = "https://movie.daum.net/moviedb/grade?movieId=134684&type=netizen&page=" + page;

			Document doc = Jsoup.connect(url).get();
			Elements repleList = doc.select("div.main_detail li");
			
			
			if(repleList.size() ==0) {
				break;
			}

			for (Element movie : repleList) {
				content = movie.select("div.review_info p").get(0).text();
				writer = movie.select("div.review_info a").get(0).text();
				score = Integer.parseInt(movie.select("em.emph_grade").get(0).text());
				reg_date = movie.select("span.info_append").get(0).text().substring(0,10);
			
				System.out.println("==================================================================================");
				System.out.println("댓글 :" + content);
				System.out.println("평점 :" + score);
				System.out.println("작성자 :" + writer);
				System.out.println("작성일자 :" + reg_date);
				cnt += 1;
			}
			page += 1;

		}
		System.out.println("총" + cnt + "건수집했습니다.");
		
		
		
		
	}
}
