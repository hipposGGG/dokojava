package kihon.lunchTime;

public class FastFoodTester {

	public static void main(String[] args) {
		SandwichSet order1 = new SandwichSet(
				new SandwichMenu("ハンバーガー"),
				new SoftDrink("コーラ",'M'), new Potato('S'));
		System.out.printf("注文セット１ -> %s%n",order1.getName());

		SandwichSet order2 = new SandwichSet(
				new SandwichMenu("チーズバーガー"),
				new Coffee(1,2), new Salad("和風ドレッシング"));
		System.out.printf("注文セット２ -> %s%n",order2.getName());
	}

}
