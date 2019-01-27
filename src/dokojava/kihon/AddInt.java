package kihon;

public class AddInt {
	public static void main(String[] args) {
		/*-----------問題１-------------*/
		int sum = 0;
		if( args.length < 1) {
			System.err.println("Error! integer not found");return;
		}
		for(int i = 0; i < sum;i++) {
			sum += Integer.parseInt(args[i]);
		}
		System.out.println("sum = " + sum);

	}
}
