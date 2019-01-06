package kihon;

public class AsyncBuffer {
	private int number = 0;

	public void put(int putNum) {
		number += putNum;
	}

	public void get(int getNum) {
		synchronized(this) {
			number -= getNum;
		}
	}
}
