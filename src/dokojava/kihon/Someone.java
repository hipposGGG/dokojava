package kihon;

public class Someone {
	public static void main(String[] args) {
		
		int i = 1234;
		float f = i;
		System.out.println("i = "+i + "\nf = " + f);
		i = 0x7eff0000;
		f = i;
		System.out.println("i = "+i + "\nf = " + f);
		System.out.println("-------------");
		int u = 256;
		byte b = (byte)u;
		System.out.println("u = "+u + "\nb = " + b);
		b = (byte)129;
		System.out.println("(byte)129 → " + b);
		
		
//		String caller = "909-8989";
//		System.out.println("-------------");
//		
//		//インスタンス化
//		CellularPhone cp = new CellularPhone("987-6543");
//		polymorphism(cp);
//		cp.talkSomething("最初は携帯電話(cellarPhone)。");
//		
//		System.out.println("-------------");
//		
//		//インスタンス化
//		FixedPhone fp = new FixedPhone("897-4512","埼玉");
//		fp.talkSomething("次は固定電話(FixedPhone)");
//		polymorphism(fp);
	}

	private static void polymorphism(Telephone tel) {
		// TODO 自動生成されたメソッド・スタブ
		tel.reciverCall("2938-123");
		tel.hungup();
	}
}
