package kihon.lunchTime;

public class Coffee extends DrinkMenu{
	private int milk;
	private int suger;

	Coffee(int suger,int milk) {
		super("コーヒー");
		this.suger = suger;
		this.milk = milk;
	}
	public String getName() {
		return "コーヒー(砂糖 "+suger+" ,ミルク "+milk+" )";
	}

}
