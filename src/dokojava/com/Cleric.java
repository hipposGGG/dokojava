package dokojava.com;

public class Cleric extends Character{
	String name;
	int hp = 50;
	static final int max_hp = 50;
	int mp = 10;
	static final int max_mp = 20;
	
	public Cleric(String name,int hp,int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}
	
	public Cleric(String name,int hp) {
		this(name, hp, Cleric.max_mp);
	}
	
	public Cleric(String name) {
		this(name,Cleric.max_hp);
	}
	
	public void selfAid() {
		System.out.println(this.name + "は、セルエイドを唱えた");
		this.hp = this.max_hp;
		this.mp -= 5;
		System.out.println(this.name + "は、HPを全回復した");
		
	}
	
	public int pray(int sec) {
		System.out.println(this.name + "は、【　祈り　】を唱えた");
		
		int recovery = new java.util.Random().nextInt(5) + sec;
		
		int recoActual = Math.min(this.max_hp - this.mp, recovery);
		
		this.hp += recoActual;
		System.out.println(sec + "秒のお祈りによって");
		System.out.println(this.name +"は、MPを" + recoActual + "回復した");
		 return recoActual;
	}

	@Override
	public void attack(Matango m) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
