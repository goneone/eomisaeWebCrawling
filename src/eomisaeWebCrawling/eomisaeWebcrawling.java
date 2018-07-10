package eomisaeWebCrawling;

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

public class eomisaeWebcrawling {
   public static void main(String[] args) throws Exception {
      Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();
      // Document doc = Jsoup.connect("http://eomisae.co.kr/al").get();

      Elements hotNews = doc.select("._listA a");
      // Elements hotNews = doc.select("._listA");
      //System.out.println(hotNews.toString());
      // System.out.println(hotNews.text());

      // 2.�����ϱ�
      
        String text = hotNews.toString(); 
        String textWithoutTag = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
       // System.out.println(textWithoutTag);
       

      // ��ü����
      // 1 ������ �޾ƿ���
      // 2 ������ �����ϱ�(html �±������)
      // 3 ���Ϻ�����
      // �ذ��ؾ��Ұ� - ������ ������������ ��� ������ �����;���. �� ��� ������ ����ҷ����� �װ� ���Ϸκ������� .

      // ���Ͽ� ����.
      BufferedWriter writer = null;
      try {
         writer = new BufferedWriter(new FileWriter(new File("output.txt")));
         writer.write(textWithoutTag);
         //writer.write(hotNews.toString());
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

      //���� ���پ� �б�.
      /*�ؽ�Ʈ ���پ� �о .length�� >=�� �׳�����.
      �ؽ�Ʈ�� ���پ� �о .length �� <=2�� 
            
      if (�� ���� > 8) {
      �� ���� ���, �� �����ε� ���. */
      List<String> ret = fileLineRead("output.txt");
      String line;
      for(int i = 0;i<ret.size();i++){
    	  if (isStringDouble(ret.get(i))) {
             if((Integer.parseInt(ret.get(i))) <= 25 && (Integer.parseInt(ret.get(i))) >=6) {
                 System.out.println(ret.get(i-1) + " " +ret.get(i));
                 
      // System.out.println("Line("+i+")"+ret.get(i));
             }
      }
      }
     /*  BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
          String line;
          String Box;
          //�迭�� ���������� ��Ƶ״ٰ�.. �����°�..�¾��  
          while ((line = reader.readLine()) != null) { // �� ���ξ� �޾ƿ´�
        	  
              String str = line;
              if (isStringDouble(str)) {
                 if((Integer.parseInt(str)) <= 25) {
                    System.out.println(line);
                    System.out.println("��������");
                    //���������� �����°Ծƴ϶�. �����϶� �� ������ ���� ������ ����ؾ���.
                    //������ �о �� ���� ������ �迭�� ����. �׷� 0��° �迭���� ù�������̴�����.
                    //�׷��ٰ� 25������ ���ڰ� ������.
                    //�� �е� ����� ���ϸ�Ǵ°žƴѰ�...!?
                 }
              }
                
              else
                System.out.print("");

            }*/

        /*      if(line.length() >3) {
             System.out.print(line);
              System.out.println();
          } else {
             System.out.println("1");*/
       /*   
          reader.close();  */// �� �о����� �ݾ��־�� �Ѵ�.
      }
      /* ���Խ� 
       * public String removeTag(String html) throws Exception { return
       * html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""); }
       */
   
   //���ڿ��� ������ ��ȯ�� �Ǵ��� �ȵǴ��� �Ǵ��ϴ� �޼ҵ� 
    public static boolean isStringDouble(String s) {
          try {
              Double.parseDouble(s);
              return true;
          } catch (NumberFormatException e) {
              return false;
          }
        }
    
    //���� ���� �б� 
    public static List<String> fileLineRead(String name) throws IOException
    {
     List<String> retStr = new ArrayList<String>();
     BufferedReader in = new BufferedReader(new FileReader(name));
     String s;
     while ((s = in.readLine()) != null) {
      retStr.add(s);
     }
     in.close();
     return retStr;  
    }
   }