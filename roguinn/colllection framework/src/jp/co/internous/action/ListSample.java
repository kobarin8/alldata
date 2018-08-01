package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;

public class ListSample {
	
	public static void main(String[]args){
		
		List<String>list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		for(int i=0; i<list.size()-1; i++){
			System.out.println(list.get(i));
		
			
		}
		
		for(String s:list){
			System.out.println(s);
		}
	}

}
