package kihon;

public class Utils {
//	public static void swap(Integer2 integer2) {
//		int temp;
//		System.out.println("  swap() start");
//		System.out.println("  i = " + i  + ",j = " + j);
//
//		temp = integer2.int1;
//		integer2.int1 = integer2.int2;
//		integer2.int2 = temp;
//
//		System.out.println("  swap() end");
//		System.out.println("  i = " + i  + ",j = " + j);
//	}

	public static class Integer1{
		private int int1;
		public Integer1(int i) { this.int1 = i;}
		public String toStoring() {
			return Integer.toString(this.int1);
		}
	}
	public static void swap2(Integer1 int1,Integer1 int2) {
		int temp = int1.int1;
		int1.int1 = int2.int1;
		int2.int1 = temp;
	}
}
