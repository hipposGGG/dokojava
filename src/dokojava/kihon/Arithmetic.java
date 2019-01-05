package kihon;

enum Arithmetic {
	ADDITION {
		int calc(int x,int y) {	return x + y;}
	},
	SUBTRACTION {
		int calc(int x,int y) {	return x - y;}
	},
	MULTIPLICATION {
		int calc(int x,int y) {	return x * y;}
	},
	DIVISION {
		int calc(int x,int y) {	return x / y;}
	};
	abstract int calc(int x, int y);


	public static void main(String[] args) {
		Arithmetic data = Arithmetic.SUBTRACTION;
		int n = data.calc(5,7);
		System.out.println("5 - 7 = " + n);

	}
}
