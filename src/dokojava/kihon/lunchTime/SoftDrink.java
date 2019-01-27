package kihon.lunchTime;

public class SoftDrink extends DrinkMenu{

	private char size;
	SoftDrink(String name, char size){
		super(name);
		this.size = size;
	}
	public String getName() {
		return super.getName()+"("+this.size+")";
	}
}
