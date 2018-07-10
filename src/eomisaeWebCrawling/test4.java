/*package eomisaeWebCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//allPost = 전체글
public class eomisaeWebcrawling {
	public static void main(String[] args) throws Exception {

		// 사이트에서 ._list A 태그에 해당하는 내용 받아옴
		Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();
		Elements allPost = doc.select("._listA a");

		// 가져온 텍스트를 태그 없앰.
		String allPostText = allPost.toString();
		String allPostTextWithoutTag = allPostText.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

		// output.txt 파일에 가져온 내용 쓰기.
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File("output.txt")));
			writer.write(allPostTextWithoutTag);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		fileLineWrite(allPostTextWithoutTag);
		// 파일 한줄씩 읽기.
		
		 * 텍스트 한줄씩 읽어서 .length가 >=면 그냥진행. 텍스트를 한줄씩 읽어서 .length 가 <=2면
		 * 
		 * if (그 숫자 > 8) { 그 라인 출력, 그 전라인도 출력.
		 
		List<String> ret = fileLineRead("output.txt");
		String line;
		for (int i = 0; i < ret.size(); i++) {
			if (isStringDouble(ret.get(i))) {
				if ((Integer.parseInt(ret.get(i))) <= 25 && (Integer.parseInt(ret.get(i))) >= 6) {
					System.out.println(ret.get(i - 1) + " " + ret.get(i));

					// System.out.println("Line("+i+")"+ret.get(i));
				}
			}
		}

	}
	//문자열이 정수로 변환이 되는지 안되는지 판단하는 메소드
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//파일 라인 읽는 메소드
	public static List<String> fileLineRead(String name) throws IOException {
		List<String> retStr = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader(name));
		String s;
		while ((s = in.readLine()) != null) {
			retStr.add(s);
		}
		in.close();
		return retStr;
	}
	
	//output.txt 파일에 가져온 내용 쓰는 메소드
	public static String fileLineWrite(String textWithoutTag) throws IOException {
		String a = null; 
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(new File("output.txt")));
				writer.write(textWithoutTag);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return a;
			}
}
}
*/