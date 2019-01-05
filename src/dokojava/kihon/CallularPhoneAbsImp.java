package kihon;

public class CallularPhoneAbsImp extends TelephhoneAbs{
	//　インスタンス変数を追加
	//　電池残量
	private int batteryRemaining = 100;

	//　コンストラクタ
	public CallularPhoneAbsImp(String telNum) {
		telephoneNumber = telNum;
	}

	//　TelephoneAbsの抽象メソッドを実装する
	//　着信
	public void receiveCall(String caller) {
		System.out.println("ring! ring! ring!");
		System.out.println("Calling " + caller +"->" + telephoneNumber);
	}
	//　切断
	public void hungUp() {
		System.out.println("bye!");
		batteryRemaining -= 10;
		System.out.println("batteryRemaining = " + batteryRemaining);
	}

}
