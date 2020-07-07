package deum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DeumBoxoffce {

	public static void main(String[] args) throws IOException {

		String baseurl = "http://ticket2.movie.daum.net/Movie/MovieRankList.aspx";
		Document doc = Jsoup.connect(baseurl).get();

		Elements movieList = doc.select("ul.list_boxthumb >li >a");

		for (Element movie : movieList) {
			String url = movie.attr("href");
			Document movieDoc = Jsoup.connect(url).get();
			
			// 상세영화 페이지가 없는 영화는 제거
			if (movieDoc.select("span.txt_name").size() == 0) {
				continue;
			}
			
			String daumHref = movieDoc.select("a.area_poster").get(0).attr("href");
			String daumCode = daumHref.substring(daumHref.lastIndexOf("=")+1, daumHref.lastIndexOf("#"));
			
			
			String preTitle = movieDoc.select("span.txt_name").get(0).text();
			String title = preTitle.substring(0, preTitle.lastIndexOf("("));
			
			
			System.out.println("====================================================");
			System.out.println("영화 제목:" + title);
			System.out.println("URL :" + daumHref);
			System.out.println("영화 코드 :" + daumCode);
			
			
		}
	}
}
