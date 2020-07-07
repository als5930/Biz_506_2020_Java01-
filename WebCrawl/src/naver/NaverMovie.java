package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverMovie {

	public static void main(String[] args) throws IOException {
			int page = 1;
			int cnt =0;	
			int score = 0;
			String content = "";
			String writer = "";
			String reg_date = "";
			String prepage = "0";
			
		while (true) {
			String url = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=189633&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page="
					+ page;

			Document doc = Jsoup.connect(url).get();
			Elements movieList = doc.select("div.score_result li");
			String nowpage = doc.select("input#page").attr("value");
		
			
			if(nowpage.contentEquals(prepage)) {
				break;
				
			}else {
				prepage =nowpage;
			}
			
					
			for (Element movie : movieList) {
				content = movie.select("div.score_reple p > span").get(0).text();
				writer = movie.select("div.score_reple em").get(0).text();
				score = Integer.parseInt(movie.select("div.star_score >em").get(0).text());

				int writerIndex = writer.lastIndexOf("(");

				if (writerIndex != -1) {
					writer = writer.substring(0, writerIndex);
				}

				reg_date = movie.select("div.score_reple em").get(1).text().substring(0,10);
		
				System.out.println("==================================================================================");
				System.out.println("댓글 :" + content);
				System.out.println("평점 :" + score);
				System.out.println("작성자 :" + writer);
				System.out.println("작성일자 :" + reg_date);
				cnt += 1;
			}
			page += 1;
			System.out.println("총" + cnt + "건수집했습니다.");
		}
	
	}
}
