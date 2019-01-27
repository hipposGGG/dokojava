package kihon.lunchTime;

public class SandwichMenu implements Order{
	private String name;
	SandwichMenu(String name){	this.name = name; }
	public String getName() { return name; }
}
