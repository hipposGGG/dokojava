package kihon;

public class Producer extends Thread{
	SyncBuffer sb;

	Producer(SyncBuffer sb){
		this.sb = sb;
	}

	public void run() {
		int putNum;
		for(int i =0; i < 10; i++) {
			putNum = (int)(Math.random() * 3 + 1);
			sb.put(putNum);
			try {	Thread.sleep(1); }catch(Exception ex){}
		}
	}
}
