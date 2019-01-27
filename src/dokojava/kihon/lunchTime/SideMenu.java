package kihon.lunchTime;

public abstract class SideMenu implements Order{
	private String name;
	SideMenu(String name) { this.name = name; }
	public String getName() { return name; }
}
