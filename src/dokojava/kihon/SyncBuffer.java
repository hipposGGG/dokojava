package kihon;

public class SyncBuffer {
	private int number = 0;

	public synchronized void put(int putNum) {
		number += putNum;
		System.out.println("put( "+putNum+","+number+" )");
		notifyAll();
	}

	public synchronized void get(int getNum) {
		while(number < getNum) {
			try {
				System.out.println("\tget wait("+getNum+" )");
				wait();
			}catch(InterruptedException ie) {
			}
		}
		number -= getNum;
		System.out.println("\tget( "+getNum+","+number+" )");
	}
}
