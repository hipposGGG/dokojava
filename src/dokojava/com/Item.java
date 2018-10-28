package dokojava.com;

public class Item {
	private String name;
	private int price;
	
	public Item() {
		name = "ダミー";
	}
	
	public Item(String name){
		this.name = name;
		this.price = 0;
	}
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	public int getDamage() {
		return 10;
	}
}
