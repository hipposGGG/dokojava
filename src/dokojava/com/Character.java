package dokojava.com;

public abstract class Character {
	String name;
	int hp;
	
	//逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Matango m);

	public int getHp() {
		// TODO 自動生成されたメソッド・スタブ
		return this.hp;
	}

	public void setHp(int hp) {
		// TODO 自動生成されたメソッド・スタブ
		this.hp = hp;
	}
}
