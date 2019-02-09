package kihon;

import java.util.Arrays;
import java.util.Comparator;

class Comp implements Comparator<String>{
	public int compare(String s1,String s2) {
		return s1.compareToIgnoreCase(s2);
	}

	public static void main (String[] args) {
		String[] ss = {"A","aa","AA","BB,","bb"};
		Comparator<String> comp0bj = new Comp();
		Arrays.sort(ss,comp0bj);
		int i = Arrays.binarySearch(ss,"aa",comp0bj);
		System.out.println(i);
		i = Arrays.binarySearch(ss, "bb",comp0bj);
		System.out.println(i);

//		Arrays.sort(ss,new Comp());
//		System.out.println(Arrays.toString(ss));
	}
}
