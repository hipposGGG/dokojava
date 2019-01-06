package kihon;

public abstract class ArithmeticAbs implements Arithmetic{
	public boolean equals(Object c) {
		if(c instanceof Arithmetic)
			return this.calculate() == ((Arithmetic)c).calculate();
		return false;
	}
}
