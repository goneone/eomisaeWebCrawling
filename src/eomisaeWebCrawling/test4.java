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

//allPost = ��ü��
public class eomisaeWebcrawling {
	public static void main(String[] args) throws Exception {

		// ����Ʈ���� ._list A �±׿� �ش��ϴ� ���� �޾ƿ�
		Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();
		Elements allPost = doc.select("._listA a");

		// ������ �ؽ�Ʈ�� �±� ����.
		String allPostText = allPost.toString();
		String allPostTextWithoutTag = allPostText.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

		// output.txt ���Ͽ� ������ ���� ����.
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
		// ���� ���پ� �б�.
		
		 * �ؽ�Ʈ ���پ� �о .length�� >=�� �׳�����. �ؽ�Ʈ�� ���پ� �о .length �� <=2��
		 * 
		 * if (�� ���� > 8) { �� ���� ���, �� �����ε� ���.
		 
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
	//���ڿ��� ������ ��ȯ�� �Ǵ��� �ȵǴ��� �Ǵ��ϴ� �޼ҵ�
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//���� ���� �д� �޼ҵ�
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
	
	//output.txt ���Ͽ� ������ ���� ���� �޼ҵ�
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