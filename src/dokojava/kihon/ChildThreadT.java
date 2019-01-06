package kihon;

public class ChildThreadT extends Thread{
	private int threadNo;
	private int sleepTime;

	ChildThreadT(int threadNo,int sleepTime){
		this.threadNo = threadNo;
		this.sleepTime = sleepTime;
	}

	public void run() {
		for(int i =0; i<5; i++) {
			System.out.println("\tChildThreadT #" + threadNo + " i=" + i);
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException ie) {
			}
		}
	}
}
