package kihon;

public class ParentThread {
	public static void main(String[] args) {
		System.out.println("ParentThread main() start.");

		//　スレッドを生成
		ChildThreadR ctr1 = new ChildThreadR(1,1000);
		ChildThreadR ctr2 = new ChildThreadR(2,500);

		Thread ct1 = new Thread(ctr1);
		Thread ct2 = new Thread(ctr2);

		//　スレッド実行開始
		ct1.start();
		ct2.start();

		try {
			ct1.join();
			ct2.join();
		}catch(InterruptedException ie) {
		}

		System.out.println("ParentThread main() end.");
	}
}
