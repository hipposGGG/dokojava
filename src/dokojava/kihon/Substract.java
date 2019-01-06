package kihon;

public class Substract extends ArithmeticAbs{

	private final Arithmetic left,right;

	public Substract(Arithmetic left,Arithmetic right) {
		this.left = left; this.right = right;
	}

	@Override
	public int calculate() {
		return left.calculate() - right.calculate();
	}

}
