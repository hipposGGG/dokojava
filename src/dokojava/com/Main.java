package dokojava.com;

public class Main{
	
	public static  void main(String[] args) throws InterruptedException {
		//Swordインスタンス　炎の剣
		Sword s = new Sword();
		s.name = "炎の剣";
		s.damage = 10;
		
		//Heroインスタンス　かずき
		Hero h = new Hero("かずき");
		h.hp = 1000;
		h.sword = s;
		System.out.println("現在の所持武器は、【　　" + h.sword.name + "　　】");
		
		SuperHero sh = new SuperHero();
		
		
		
	}
	
	
} 
