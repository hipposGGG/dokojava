package kihon;

public class FixedPhoneImp implements TelephoneI {
	static int units = 0;
	String installationSite;
	//　電話番号
	String telephoneNumber;


	public FixedPhoneImp(String telNum, String site) {
		telephoneNumber = telNum;
		installationSite = site;
		units++;
	}

	@Override
	public void receiveCall(String caller) {
		System.out.println("ring! ring! ring!");
		System.out.println("Calling " + caller + "->" + telephoneNumber + " (site : " + installationSite + ")");
	}

	@Override
	public void hungUp() {
		System.out.println("bye!");
	}

	@Override
	public void talkSomething(String msg) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
