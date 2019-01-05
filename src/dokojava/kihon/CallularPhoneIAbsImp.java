package kihon;

public class CallularPhoneIAbsImp extends TelephoneIAbs{
	//　電池残量
	int batteryRemaining = 100;

	public CallularPhoneIAbsImp(String telNum) {
		super(telNum);
	}

	public void receiveCall(String caller) {
		System.out.println("ring! ring! ring!");
		System.out.println("Calling " + caller +"->" + telephoneNumber);
	}

	@Override
	public void hungUp() {
		System.out.println("bye!");
		batteryRemaining -= 10;
		System.out.println("batteryRemaining = " + batteryRemaining);
	}

}
