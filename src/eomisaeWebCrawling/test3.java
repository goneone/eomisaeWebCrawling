package eomisaeWebCrawling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test3 {
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
 
 public static void main(String args[]) throws IOException {
  List<String> ret = fileLineRead("test.txt");
  for(int i = 0;i<ret.size();i+=2){
   System.out.println("Line("+i+")"+ret.get(i));
  }
 }
}