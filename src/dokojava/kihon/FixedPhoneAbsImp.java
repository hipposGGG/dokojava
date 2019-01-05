package kihon;

public class FixedPhoneAbsImp extends TelephhoneAbs{

	static int units = 0;
	String installationSite;

	public FixedPhoneAbsImp(String telNum, String site) {
		telephoneNumber = telNum;
		installationSite = site;
		units++;
	}

	@Override
	public void receiveCall(String caller) {
		System.out.println("ring! ring! ring!");
		System.out.println("Calling " + caller +"->" + telephoneNumber + " (site : "+installationSite + ")");
	}

	@Override
	public void hungUp() {
		System.out.println("bye!");
	}

}
