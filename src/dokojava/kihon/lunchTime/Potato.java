package kihon.lunchTime;

public class Potato extends SideMenu{
	private char size;
	public Potato(char size) {
		super("ポテト");
		this.size = size;
	}

	public String getName() {
		return "ポテト　（ "+size+" )";
	}

}
