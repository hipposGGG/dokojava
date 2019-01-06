package kihon;

public class Counter extends Thread{
	public void run() {
		for(int i = 0;i < 10; i++) {
			System.out.println("Counter : "+i);
			try {
				sleep(1000);
			}catch(InterruptedException ie) {
			}
		}
		System.out.println("Threadtest is END.");
	}
}

