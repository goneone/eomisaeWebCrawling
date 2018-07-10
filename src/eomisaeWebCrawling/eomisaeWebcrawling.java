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

      // 2.정제하기
      
        String text = hotNews.toString(); 
        String textWithoutTag = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
       // System.out.println(textWithoutTag);
       

      // 전체과정
      // 1 데이터 받아오기
      // 2 데이터 정제하기(html 태그지우기)
      // 3 메일보내기
      // 해결해야할것 - 제목을 가져오지말고 댓글 개수를 가져와야함. 그 댓글 개수로 제목불러오고 그걸 메일로보내야함 .

      // 파일에 쓰기.
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

      //파일 한줄씩 읽기.
      /*텍스트 한줄씩 읽어서 .length가 >=면 그냥진행.
      텍스트를 한줄씩 읽어서 .length 가 <=2면 
            
      if (그 숫자 > 8) {
      그 라인 출력, 그 전라인도 출력. */
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
          //배열에 이정보들을 담아뒀다가.. 꺼내는거..는어떨까  
          while ((line = reader.readLine()) != null) { // 한 라인씩 받아온다
        	  
              String str = line;
              if (isStringDouble(str)) {
                 if((Integer.parseInt(str)) <= 25) {
                    System.out.println(line);
                    System.out.println("세일정보");
                    //세일정보가 나오는게아니라. 숫자일때 그 숫자의 위의 라인을 출력해야함.
                    //파일을 읽어서 그 읽은 한줄을 배열에 담음. 그럼 0번째 배열에는 첫번쨰줄이담기곘지.
                    //그러다가 25이하의 숫자가 나오면.
                    //다 읽돼 출력을 안하면되는거아닌가...!?
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
          reader.close();  */// 다 읽었으면 닫아주어야 한다.
      }
      /* 정규식 
       * public String removeTag(String html) throws Exception { return
       * html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""); }
       */
   
   //문자열이 정수로 변환이 되는지 안되는지 판단하는 메소드 
    public static boolean isStringDouble(String s) {
          try {
              Double.parseDouble(s);
              return true;
          } catch (NumberFormatException e) {
              return false;
          }
        }
    
    //파일 라인 읽기 
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