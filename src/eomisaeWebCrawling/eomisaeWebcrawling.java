package eomisaeWebCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class eomisaeWebcrawling {
	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();
		//Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();
		
			Elements hotNews = doc.select("._listA a");
		//Elements hotNews = doc.select("._listA");
			//System.out.println(hotNews.toString());
			//System.out.println(hotNews.text());
			
			//2.정제하기
			String text = hotNews.toString();
			String textWithoutTag = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
			System.out.println(textWithoutTag);
			
			//전체과정
			//1 데이터 받아오기
			//2 데이터 정제하기(html 태그지우기)
			//3 메일보내기
			//해결해야할것 - 제목을 가져오지말고 댓글 개수를 가져와야함. 그 댓글 개수로 제목불러오고 그걸 메일로보내야함 .
	}
	/*
	public String removeTag(String html) throws Exception {
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}*/
}

