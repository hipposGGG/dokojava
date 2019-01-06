package kihon;

public class Consumer extends Thread{
	SyncBuffer sb;

	Consumer(SyncBuffer sb){
		this.sb = sb;
	}

	public void run() {
		int getNum;
		for(int i =0; i < 5; i++) {
			getNum = (int)(Math.random() * 6 + 1);
			sb.get(getNum);
			try {	Thread.sleep(1); }catch(Exception ex){}
		}
	}
}
