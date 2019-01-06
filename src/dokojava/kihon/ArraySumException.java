package kihon;

public class ArraySumException extends Exception{
	protected int exceptionIndex;

	public ArraySumException(String msg) { super(msg);}
	public int getExceptionIndex() { return exceptionIndex;}
}
