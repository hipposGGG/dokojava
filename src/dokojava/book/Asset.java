package dokojava.book;

public abstract class Asset {
	private String name;
	private int price;
	//コンストラクト
	public Asset(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	//getterメソッド
	public String getName() {	return this.name; }
	public int getPrice() {	return this.price;	}
}
