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
		 
	     String[] file_list_title = {"a_title.txt", "b_title.txt", "c_title.txt", "d_title.txt", "e_title.txt", "f_title.txt",
	    		 "g_title.txt", "h_title.txt", "i_title.txt", "j_title.txt", "k_title.txt", "l_title.txt",
	    		 "m_title.txt", "n_title.txt", "o_title.txt", "p_title.txt", "q_title.txt", "r_title.txt",
	    		 "s_title.txt", "t_title.txt", "u_title.txt", "v_title.txt", "w_title.txt", "x_title.txt",
	    		 "y_title.txt", "z_title.txt"
	     };
	     
	     String[] file_list_text = {"a_text.txt", "b_text.txt", "c_text.txt", "d_text.txt", "e_text.txt", "f_text.txt",
	    		 "g_text.txt", "h_text.txt", "i_text.txt", "j_text.txt", "k_text.txt", "l_text.txt",
	    		 "m_text.txt", "n_text.txt", "o_text.txt", "p_text.txt", "q_text.txt", "r_text.txt",
	    		 "s_text.txt", "t_text.txt", "u_text.txt", "v_text.txt", "w_text.txt", "x_text.txt",
	    		 "y_text.txt", "z_text.txt"
	     };
	     
	     for (String key : title_keys) { 
	    	 System.out.println(key+ " ");
	     }
	     
	     
//	     int prevflag=0;
//	     int afterflag=1;
//	     for (String key : title_keys) { 
//	    	   List<String> value = (List<String>)title_map.get(key);
//	    	   
//	    	   if(prevflag!=afterflag)
//	    		   FileWriter writer = new FileWriter(file_list_title[prevflag]); 
//	    	   for(String str: value) {
//	    	     writer.write(str);
//	    	   }
//	    	   writer.close();
//	    	   // do something
//	    } 
	        
}
	
//	Hash Map format: {Word: int int} ex. {Store: 5 6}
	
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
}
