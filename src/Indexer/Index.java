package Indexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.IOException;

import Parser.*;
import Indexer.Index;

public class Index {
	static Map<String, List<String>> title_map = new HashMap<String, List<String>>();
	static Map<String, List<String>> text_map = new HashMap<String, List<String>>();
	static Map<String, String> title_file = new HashMap<String, String>();
	static Map<String, String> text_file = new HashMap<String, String>();
	static FileWriter writer;
	
	public static void Start(String xml) throws IOException
	{
		 Parser read = new Parser();
		 List<WikiPage> readConfig = read.readConfig(xml);
		 
		 System.out.println("Parsing done");
		 
		 long startTime = System.currentTimeMillis();
		 
		 for (WikiPage page : readConfig) {
			 System.out.println("Page: " + page.getId());
			 Dissect(page.getId(), page.getTitle(), page.getText());
					 
		 }
		
		 long stopTime = System.currentTimeMillis();
	     long elapsedTime = stopTime - startTime;
	     System.out.println(elapsedTime);
	     
	     SortedSet<String> title_keys = new TreeSet<String>(title_map.keySet());
	     SortedSet<String> text_keys = new TreeSet<String>(text_map.keySet());
		 
	     
	     addList();
	    
	     
	     String prevflag = "";
	     String afterflag= "";
	     
	     for (String key : title_keys) { 
	    	 String val = title_file.get(key.charAt(0));
	    	 
	    	 if(val == null)
	    		 writer = new FileWriter("0_title.txt");
	    	 
	    	 else if(!val.equals(prevflag))
	    	 {	 writer = new FileWriter(val);
	    	 	 prevflag = val;
	    	 }
	    	 	    	 
	    	 List<String> value = (List<String>)title_map.get(key);
	    	   for(String str: value) {
	    	     writer.write(str);
	    	   }
	     }
	     
	     for (String key : text_keys) { 
	    	 String val = text_file.get(key.charAt(0));
	    	 
	    	 if(val == null)
	    		 writer = new FileWriter("0_text.txt");
	    	 
	    	 else if(!val.equals(prevflag))
	    	 {	 writer = new FileWriter(val);
	    	 	 prevflag = val;
	    	 }
	    	 	    	 
	    	 List<String> value = (List<String>)text_map.get(key);
	    	   for(String str: value) {
	    	     writer.write(str);
	    	   }
	     }


}
	
	public static void Dissect(String id, String title, String txt)
	{
		String[] tit = title.split(" ");
		String[] tat = txt.split(" ");
		
		for(int i=0; i < tit.length; i++)
		{
			List<String> value = (List<String>)title_map.get(tit[i]);
			if (value != null) {
				value.add(id);
				title_map.put(tit[i], value);
							
			} else {
				List<String> ar = new ArrayList<String>();
				ar.add(id);
			   title_map.put(tit[i], ar);
			}
		
		}
		
		for (int i=0; i< tat.length; i++)
		{
			List<String> value = (List<String>)text_map.get(tat[i]);
			if (value != null) {
				value.add(id);
				text_map.put(tat[i], value);
							
			} else {
				List<String> ar = new ArrayList<String>();
				ar.add(id);
			   text_map.put(tat[i], ar);
			}
		
		}
}
	
	
	public static void addList()
	{		
		 title_file.put("a", "a_title.txt");
		 title_file.put("b", "b_title.txt");
		 title_file.put("c", "c_title.txt");
		 title_file.put("d", "d_title.txt");
		 title_file.put("e", "e_title.txt");
		 title_file.put("f", "f_title.txt");
		 title_file.put("g", "g_title.txt");
		 title_file.put("h", "h_title.txt");
		 title_file.put("i", "i_title.txt");
		 title_file.put("j", "j_title.txt");
		 title_file.put("k", "k_title.txt");
		 title_file.put("l", "l_title.txt");
		 title_file.put("m", "m_title.txt");
		 title_file.put("n", "n_title.txt");
		 title_file.put("o", "o_title.txt");
		 title_file.put("p", "p_title.txt");
		 title_file.put("q", "q_title.txt");
		 title_file.put("r", "r_title.txt");
		 title_file.put("s", "s_title.txt");
		 title_file.put("t", "t_title.txt");
		 title_file.put("u", "u_title.txt");
		 title_file.put("v", "v_title.txt");
		 title_file.put("w", "w_title.txt");
		 title_file.put("x", "x_title.txt");
		 title_file.put("y", "y_title.txt");
		 title_file.put("z", "z_title.txt");
		 title_file.put("A", "a_title.txt");
		 title_file.put("B", "b_title.txt");
		 title_file.put("C", "c_title.txt");
		 title_file.put("D", "d_title.txt");
		 title_file.put("E", "e_title.txt");
		 title_file.put("F", "f_title.txt");
		 title_file.put("G", "g_title.txt");
		 title_file.put("H", "h_title.txt");
		 title_file.put("I", "i_title.txt");
		 title_file.put("J", "j_title.txt");
		 title_file.put("K", "k_title.txt");
		 title_file.put("L", "l_title.txt");
		 title_file.put("M", "m_title.txt");
		 title_file.put("N", "n_title.txt");
		 title_file.put("O", "o_title.txt");
		 title_file.put("P", "p_title.txt");
		 title_file.put("Q", "q_title.txt");
		 title_file.put("R", "r_title.txt");
		 title_file.put("S", "s_title.txt");
		 title_file.put("T", "t_title.txt");
		 title_file.put("U", "u_title.txt");
		 title_file.put("V", "v_title.txt");
		 title_file.put("W", "w_title.txt");
		 title_file.put("X", "x_title.txt");
		 title_file.put("Y", "y_title.txt");
		 title_file.put("Z", "z_title.txt");
		 text_file.put("a", "a_text.txt");
		 text_file.put("b", "b_text.txt");
		 text_file.put("c", "c_text.txt");
		 text_file.put("d", "d_text.txt");
		 text_file.put("e", "e_text.txt");
		 text_file.put("f", "f_text.txt");
		 text_file.put("g", "g_text.txt");
		 text_file.put("h", "h_text.txt");
		 text_file.put("i", "i_text.txt");
		 text_file.put("j", "j_text.txt");
		 text_file.put("k", "k_text.txt");
		 text_file.put("l", "l_text.txt");
		 text_file.put("m", "m_text.txt");
		 text_file.put("n", "n_text.txt");
		 text_file.put("o", "o_text.txt");
		 text_file.put("p", "p_text.txt");
		 text_file.put("q", "q_text.txt");
		 text_file.put("r", "r_text.txt");
		 text_file.put("s", "s_text.txt");
		 text_file.put("t", "t_text.txt");
		 text_file.put("u", "u_text.txt");
		 text_file.put("v", "v_text.txt");
		 text_file.put("w", "w_text.txt");
		 text_file.put("x", "x_text.txt");
		 text_file.put("y", "y_text.txt");
		 text_file.put("z", "z_text.txt");
		 text_file.put("A", "a_text.txt");
		 text_file.put("B", "b_text.txt");
		 text_file.put("C", "c_text.txt");
		 text_file.put("D", "d_text.txt");
		 text_file.put("E", "e_text.txt");
		 text_file.put("F", "f_text.txt");
		 text_file.put("G", "g_text.txt");
		 text_file.put("H", "h_text.txt");
		 text_file.put("I", "i_text.txt");
		 text_file.put("J", "j_text.txt");
		 text_file.put("K", "k_text.txt");
		 text_file.put("L", "l_text.txt");
		 text_file.put("M", "m_text.txt");
		 text_file.put("N", "n_text.txt");
		 text_file.put("O", "o_text.txt");
		 text_file.put("P", "p_text.txt");
		 text_file.put("Q", "q_text.txt");
		 text_file.put("R", "r_text.txt");
		 text_file.put("S", "s_text.txt");
		 text_file.put("T", "t_text.txt");
		 text_file.put("U", "u_text.txt");
		 text_file.put("V", "v_text.txt");
		 text_file.put("W", "w_text.txt");
		 text_file.put("X", "x_text.txt");
		 text_file.put("Y", "y_text.txt");
		 text_file.put("Z", "z_text.txt"); 
	   
	}
	
//	Hash Map format: {Word: int int} ex. {Store: 5 6}
	
	
}
