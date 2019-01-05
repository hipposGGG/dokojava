package kihon;

public class CallularPhoneImp implements TelephoneI{

	String telephoneNumber;
	private int batteryRemaining = 100;

	public CallularPhoneImp(String telNum) {
		telephoneNumber = telNum;
	}


	@Override
	public void receiveCall(String caller) {
		System.out.println("ring! ring! ring!");
		System.out.println("Calling " + caller +"->" + telephoneNumber);
	}

	@Override
	public void talkSomething(String msg) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("[" + msg + "]");

	}

	@Override
	public void hungUp() {
		System.out.println("bye!");
		batteryRemaining -= 10;
		System.out.println("batteryRemaining = " + batteryRemaining);
	}

}
