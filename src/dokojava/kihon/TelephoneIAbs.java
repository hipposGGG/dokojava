package kihon;

public abstract class TelephoneIAbs implements TelephoneI{

	protected String telephoneNumber;

	//　コンストラクタ
	public TelephoneIAbs(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public TelephoneIAbs() {}

	public void talkSomething(String msg) {
		System.out.println("[ " + msg + " ]");
	}


}
