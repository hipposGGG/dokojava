package kihon;

public class ArithmeticTest {
	public static void main(String[] args) {
		Arithmetic a1 = new Numeric(5);
		Arithmetic a2 = new Numeric(5);
		System.out.println("a1,a2 = " + a1.calculate() + "," + a2.calculate());
		System.out.println("a1-a2 = " + new Substract(a1,a2).calculate());

		System.out.println(a1.calculate() == a2.calculate());
		System.out.println(a1.equals(a2));

		System.out.println("-------------------");
		Arithmetic a3 = new Numeric(2);
		System.out.println(new Substract(a1,new Substract(a2,a3)).calculate());
	}
}
