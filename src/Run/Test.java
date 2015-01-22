package Run;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Parser.*;
import Indexer.Index;

public class Test {
	public static HashMap p = new HashMap<String, int[]>();
	public static HashMap book = new HashMap<String, String>();
	
	public static void main(String args[]) throws IOException {
		 
		 Index index = new Index();
		 System.out.println("Sent to indexer");
	     Index.Start("sample.xml");
	
	}
}
