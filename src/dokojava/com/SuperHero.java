package dokojava.com;

public class SuperHero extends Hero {
	
	public SuperHero() {
		super();
		System.out.println("SuperHeroのコントラクタが動作");
	}
	
	private boolean flying;
	public void fly() {
		this.flying = true;
		System.out.println(this.getName()+"は飛び上がった");
	}
	
	public void land() {
		this.flying = false;
		System.out.println(this.getName() + "は着地した");
	}
	
	public void run() {
		System.out.println("自慢の羽を使って撤退した");
	}
	
	public void attack(Matango m) {
		super.attack(m);
		if(this.flying) {
			super.attack(m);
		}
	}
	
}
