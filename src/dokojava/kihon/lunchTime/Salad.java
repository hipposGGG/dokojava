package kihon.lunchTime;

public class Salad extends SideMenu{
	private String dressing;
	public Salad(String dressing) {
		super("サラダ");
		this.dressing = dressing;
	}
	public String getName() {
		return "サラダ( "+dressing+" )";
	}

}
