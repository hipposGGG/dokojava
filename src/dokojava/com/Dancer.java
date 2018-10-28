package dokojava.com;

public class Dancer extends Character{
	private String name;

	public void dance() {
		System.out.println(this.name + "は、情熱的に踊った");
	}

	@Override
	public void attack(Matango m) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に3ポイントのダメージを与えた");
		m.hp -= 3;
	}
}
