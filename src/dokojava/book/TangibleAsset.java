package dokojava.book;

public abstract class TangibleAsset extends Asset implements Thing{
	private String color;
	private double weight;
	
	//コンストラクト
	public TangibleAsset(String name,int price, String color,double weight) {
		super(name,price);
		this.color = color;
		this.weight = weight;
	}
	

	//getterメソッド
	public String getColor() { return this.color; }
	public double getWeight() { return this.weight;	}
	public void setWeight(double weight) {this.weight = weight;	}
}
