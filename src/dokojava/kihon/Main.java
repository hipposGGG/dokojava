package kihon;
import  java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("A");
		li.add("B");
		li.add(0,"C");
		li.add(2,null);
		li.add(4,"D");
		String s= li.remove(1);
		li.add(1,"E");
		System.out.println(s);
		for(Iterator<String> it = li.iterator();it.hasNext();) {
			System.out.print(it.next()+",");
		}
		//C,E,null,B,D
	}
}
