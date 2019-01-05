package kihon;

abstract class TelephhoneAbs {
	//　電話番号
	String telephoneNumber;

	//　抽象メソッド -サブクラスで実装する
	//　着信
	abstract void receiveCall(String caller);

	//　切断
	abstract void hungUp();

	//　具象メソッド
	//　通話
	public void talkSomething(String msg) {
		System.out.println("[ " + msg + " ]");
	}
}
