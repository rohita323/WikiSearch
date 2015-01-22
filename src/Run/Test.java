package Run;

import java.util.List;

import Parser.*;


public class Test {
	
	  public static void main(String args[]) {
	    Parser read = new Parser();
	    List<WikiPage> readConfig = read.readConfig("sample.xml");
	    for (WikiPage page : readConfig) {
//	      System.out.println(page);
	    }
	  }
}
