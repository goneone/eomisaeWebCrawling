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
			
			//2.�����ϱ�
			String text = hotNews.toString();
			String textWithoutTag = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
			System.out.println(textWithoutTag);
			
			//��ü����
			//1 ������ �޾ƿ���
			//2 ������ �����ϱ�(html �±������)
			//3 ���Ϻ�����
			//�ذ��ؾ��Ұ� - ������ ������������ ��� ������ �����;���. �� ��� ������ ����ҷ����� �װ� ���Ϸκ������� .
	}
	/*
	public String removeTag(String html) throws Exception {
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}*/
}

