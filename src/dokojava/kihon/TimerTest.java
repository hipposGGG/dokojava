package kihon;
import java.util.Date;

public class TimerTest {
	private void test() throws InterruptedException{
		Timer tm5s,tm2s;

		tm5s = Timer.getTimer(5);
		print(tm5s,"タイマ５秒　開始 :");
		tm2s = Timer.getTimer(2);
		print(tm2s,"タイマ２秒　開始 :");
		tm2s.waitT();		//　タイマ2秒を待つ
		print(tm2s,"終了 :");
		tm5s.stopT();		//　タイマ5秒をストップする
		tm5s.waitT();
		print(tm5s,"終了 :");
	}

	private void print(Timer timer, String msg) {
		System.out.println(msg + timer.getTName() + " : "
					+ new Date(System.currentTimeMillis()));
	}
	public static void main(String[] args) throws InterruptedException{
		new TimerTest().test();

	}

}
