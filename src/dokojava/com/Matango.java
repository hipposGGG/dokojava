package dokojava.com;

public class Matango{
	int hp = 50;
	final int level = 10;
	private char suffix;
	
	public Matango() {
		this.suffix = suffix;
	}
	
	public Matango(char suffix) {
		this.suffix = suffix;
	}
	
	public void attack(Hero h) {
		System.out.println("キノコ"+this.suffix + "の攻撃");
		System.out.println("10HPのダメージ");
		h.setHp(h.getHp() - 10 );
	}
	
	void run() {
		System.out.println("お化けキノコ、" + this.suffix + "は逃げ出した");
	}
	
	void attack() {
		int attckPoint = new java.util.Random().nextInt(10);
		this.hp -= attckPoint;
		System.out.println(this.suffix + "は攻撃を受けた");
		System.out.println(attckPoint + "HPダメージを受けた");
	}
	
}