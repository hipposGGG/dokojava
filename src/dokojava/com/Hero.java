package dokojava.com;

public class Hero extends Character{
	private String name;
	int hp;
	static int money;
	Sword sword;
	
	Hero(String name){
		this.hp = 100;
		this.name = name;
	}
	
	Hero(){
		this("ダミー");
	}
	
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("名前がnullです。");
		}
		if(name.length() <= 1) {
			throw new IllegalArgumentException("名前が短すぎる");
		}else if(name.length() > 8) {
			throw new IllegalArgumentException("名前が長すぎる");
		}
		this.name = name;
	}
	public String getName() {	return this.name;	}
	public void setHp(int hp) {	this.hp = hp;	}
	public int getHp() {	return this.hp;	}
	
	//お金をランダムで所持
	static void setRandomMoney() {
		Hero.money = (int) (Math.random() * 1000);
	}
	
	//攻撃
	public void attack(Matango m) {
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に10ポイントのダメージを与えた");
		m.hp -= 10;
	}
	
	//睡眠回復
	void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、睡眠で回復した");
	}
	//睡眠薬摂取
	void drink() {
		this.hp = 500;
		System.out.println(this.name + "は、回復飲み薬を飲んで回復した");
	}
	//座って回復
	void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った");
		System.out.println(sec + "HP回復した");
	}
	//転ぶ―ダメージ
	public final void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は転んだ！");
		System.out.println("5HPダメージを負った");
		
	}
	//逃亡
	 public void run() {
		 System.out.println(this.name + "は逃げ出した");
		 System.out.println("GAMEOVER");
		 System.out.println("最終HPは"+this.hp + "HPになります");
	 }
	 //別れ
	 void bye() {
		System.out.println("勇者は別れを告げた"); 
	 }
	 //死亡
	 private void die() {
		 System.out.println(this.name + "は死んでしまった");
		 System.out.println("GAMEOVER");
	 }
}
