package kihon;

public class ChildThreadR implements Runnable {
	private int threadNo;
	private int sleepTime;

	ChildThreadR(int threadNo,int sleepTime){
		this.threadNo = threadNo;
		this.sleepTime = sleepTime;
	}

	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("\tChildThreadR #" + threadNo + " i=" + i);
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException ie) {
			}
		}
	}
}
