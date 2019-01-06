package kihon;

public class ArraySumNumOverException extends ArraySumException{
	public ArraySumNumOverException(int i) {
		super("ArraySumNumOverException occurred.");
		exceptionIndex = i;
	}
}