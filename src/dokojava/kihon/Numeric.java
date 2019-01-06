package kihon;

public class Numeric extends ArithmeticAbs{
	private final int value;

	public Numeric(int value) {
		this.value = value;
	}

	@Override
	public int calculate() {	return value;}

}
