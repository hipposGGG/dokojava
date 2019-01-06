package kihon;

public class Timer{
	private static int counter;
	private Tick tick;
	private Thread thread;

	//　コンストラクタ
	private Timer(int sec) {
		tick = new Tick(sec);
		thread = new Thread(tick,"Timer" + getCounter());
	}
	synchronized private static int getCounter() {
		return ++counter;
	}

	public static Timer getTimer(int sec) {
		Timer timer = new Timer(sec);
		timer.thread.start(); //　スレッド起動
		return timer;
	}

	public void waitT() throws InterruptedException{
		thread.join();
	}

	public void stopT() {tick.stop();}
	public String getTName() {	return thread.getName();}
	//　クラスTick
	private class Tick implements Runnable{
		private final long stopAt;
		private volatile boolean interrupted;

		private Tick(int sec) {
			stopAt = getMillisec() + sec * 1000;
		}

		public void run() {
			long diff;
			while((diff = stopAt - getMillisec()) > 0) {
				try {
					Thread.sleep(diff);
				}catch(InterruptedException e) {
					if(interrupted) break;
				}
			}
			if(interrupted)
				System.out.println(Timer.this.thread.getName()+ "で割り込み受信！");
		}
		private void stop() {
			interrupted = true;
			Timer.this.thread.interrupt();
		}

		private long getMillisec() {
			return System.currentTimeMillis();
		}
	}
}

