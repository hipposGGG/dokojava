package dokojava.com;

public class Wizerd extends Character{
	private String name;
	private int hp;
	private int mp;
	private Wand wand;
	
	//setter
	//名前の異常検知方法
	public void setName(String name) {	
		if(this.name == null) {
			throw new IllegalArgumentException("名前が未入力です");
		}else if(this.name.length() >= 3) {
			throw new IllegalArgumentException("名前が3文字に足りてません");
		}
		this.name = name;
	}
	//負の数値を入力時の対策
	public void setHp(int hp) {	 
		if(this.hp < 0) {
			this.hp = 0;
		}else {
			this.hp = hp;
		}
	}
	//負の数値を入力時の対策
	public void setMp(int mp) {	
		if(this.mp < 0) {
			throw new IllegalArgumentException("MPは0以下には設定できません");
		}
		this.hp = mp;
	}
	//魔法の杖の設定検知
	public void setWand(Wand wand) {	
		if(this.wand == null) {
			throw new IllegalArgumentException("魔法使いに必要な杖が設定されていません");
		}
		this.wand = wand;
	}
	
	//getterメソッド
	public String getName() {	return this.name;}
	public int getHp() {	return this.hp;}
	public int getMp() {	return this.mp;}
	public Wand getWand() {	return this.wand;}
	
	//ヒール‐回復魔法
	void heal(Hero h) {
		int basePoint = 10; //基本ポイント
		int recoverPoint = (int) (basePoint * this.wand.getPower()); //杖による増幅
		h.setHp(h.getHp() + recoverPoint); //勇者のHPを回復させる
		System.out.println(h.getName() + "のHPを" + recoverPoint + "回復した！");
	}
	@Override
	public void attack(Matango m) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に3ポイントのダメージ");
		m.hp -= 3;
	}
	
	public void fireball(Matango m) {
		System.out.println(this.name + "は、火の玉を放った");
		System.out.println("敵に20ポイントのダメージ");
		m.hp -= 20;
		this.mp -= 5;
	}
	
	public void coldBall(Matango m){
		System.out.println(this.name + "は、氷の玉放った");
		System.out.println("敵に20ポイントのダメージ");
		m.hp -= 20;
		this.mp -= 5;
	}

}
