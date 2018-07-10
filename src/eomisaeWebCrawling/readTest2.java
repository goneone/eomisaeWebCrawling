package eomisaeWebCrawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.naming.Context;

public class readTest2 {

public static void main(String[] args) {
	
}

public static LinkedList<String> readFromAssets(Context context, String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
    LinkedList<String>linkedList = new LinkedList<>();
    // do reading, usually loop until end of file reading
    StringBuilder sb = new StringBuilder();
    String mLine = reader.readLine();
    while (mLine != null) {
        linkedList.add(mLine);
        sb.append(mLine); // process line
        mLine = reader.readLine();


    }
    reader.close();
    return linkedList;
}
}