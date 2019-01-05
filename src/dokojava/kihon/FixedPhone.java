package kihon;

public class FixedPhone extends Telephone {
	static int units = 0;
	String installationSite;

	//	コンストラクタ（１）
	public FixedPhone(String telNum, String site) {
		telephoneNumber = telNum;
		installationSite = site;
		units++;
	}

	//	コンストラクタ（２）
	public FixedPhone(String telNum) {


		this(telNum,"?");
		units++;
	}

	public void reciveCall(String caller) {
		System.out.println("ring!ring!ring!");
		System.out.println("calling " + caller + " -> " + telephoneNumber + "site(:　" + installationSite);
	}
}
