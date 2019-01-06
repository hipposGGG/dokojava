package kihon;

public class SyncPC {
	public static void main(String[] args) {
		SyncBuffer sb = new SyncBuffer();
		Producer p = new Producer(sb);
		Consumer c = new Consumer(sb);

		p.start();
		c.start();
	}
}
