package dokojava.book;

public class Computer extends TangibleAsset{
	private String makerName;
	
	//コンストラクタ
	public Computer(String name,int price,String color,String makerName) {
		super(name,price,color);
		this.makerName = makerName;
	}
		
	//getterメソッド
	public String getMakerName() { return this.makerName; }
	
}
