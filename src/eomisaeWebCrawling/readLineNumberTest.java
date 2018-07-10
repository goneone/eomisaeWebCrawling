package eomisaeWebCrawling;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readLineNumberTest {

   public static void main(String[] args) throws IOException {
     
      String line32 = Files.readAllLines(Paths.get("test.txt")).get(2);
      System.out.println(line32);
   }
}
