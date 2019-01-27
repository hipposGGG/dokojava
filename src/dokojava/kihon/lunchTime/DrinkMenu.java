package kihon.lunchTime;

public abstract class DrinkMenu implements Order{
	private String name;
	DrinkMenu(String name){ this.name = name;}
	public String getName() { return name;}
}
