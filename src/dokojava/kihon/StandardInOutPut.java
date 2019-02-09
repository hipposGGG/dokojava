package kihon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardInOutPut {
	public static void main(String[] args) {
		String regax = "([0-9]+)年([0-9])月([0-9]+)日";
		Pattern p = Pattern.compile(regax);
		String input = "2018年7月23日";
		Matcher m = p.matcher(input);
//		if(m.matches()) {
			String g0 = m.group(0);
			String g1 = m.group(1);
			String g2 = m.group(2);
			String g3 = m.group(3);
			System.out.println("["+g0+" , "+g1+" , "+g2+" , "+g3+"]");
//		}
//
//		else System.out.println("マッチに失敗");
	}
}
