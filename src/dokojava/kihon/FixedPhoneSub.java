package kihon;

public class FixedPhoneSub extends FixedPhone{
	static int units = 100;
	//　コンストラクタ
	public FixedPhoneSub(String telNum,String site) {
		super(telNum,site);
	}

	public static void main(String[] args) {
		FixedPhoneSub fps = new FixedPhoneSub("12-321","place");
		fps.printNumber();
	}

	public void printNumber() {
		System.out.println("units            = " + units);
		System.out.println("this.units       = " + this.units);
		System.out.println("super.units      = " + super.units);
		System.out.println("FixedPhone.units = " + FixedPhone.units);

	}
}
