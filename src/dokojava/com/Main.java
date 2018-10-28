package dokojava.com;

import java.util.Date;

public class Main{
	public static  void main(String[] args) throws InterruptedException {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getTime());
		Date dd = new Date(131662222593L);
		System.out.println(dd);
	}
} 
