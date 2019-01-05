package kihon;

public class Main {
	public static void main(String[] args) {
		CallularPhoneImp cp = new CallularPhoneImp("123-4567");
		polymorphism(cp);

		System.out.println("---------------------");

		FixedPhoneImp fp = new FixedPhoneImp("765-4321","someWhere");
		polymorphism(fp);
		System.out.println("---------------------");

	}

	public static void polymorphism(TelephoneI tel) {
		tel.receiveCall("456-7890");
		tel.hungUp();
	}
}
