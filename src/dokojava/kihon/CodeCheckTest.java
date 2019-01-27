package kihon;

import java.util.*;

public class CodeCheckTest {

	public static void main(String[] args) {
		Set<String> ts = new TreeSet<>(/*----　ここから------*/
		new Comparator<String>() {
			public int compare(String s1,String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		/*----　ここまで------*/
		ts.add("Ab");
		ts.add("aBc");
		ts.add("a");
		ts.add("A");
		System.out.println(ts);
	}

}
