package dokojava.com;

public class Wand {
	private String name;
	private double power;
	
	public void setName(String name) {	
		if(this.name == null) {
			throw new IllegalArgumentException("杖名が未入力です");
		}else if(this.name.length() >= 3) {
			throw new IllegalArgumentException("杖名が3文字に足りてません");
		}
		this.name = name;
	}
	public String getName() {	return this.name;}
	
	public void setPower(double power) {	
		if(this.power <= 0.5 && this.power >= 100.0) {
			throw new IllegalArgumentException("杖の魔力設定が超過または少ないです");
		}
		this.power = power;
	}
	public double getPower() {	return this.power;}
}
