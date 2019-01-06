package kihon;

public class ArraySumNumUnderException extends ArraySumException{
	public ArraySumNumUnderException(int i) {
		super("ArraySumNumUnderException occurred.");
		exceptionIndex = i;
	}
}
