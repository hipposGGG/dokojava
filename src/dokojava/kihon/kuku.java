package kihon;

public class kuku {
	public static void main(String[] args) {
		System.out.println("  |   1  2  3  4  5  6  7  8  9");
		System.out.println("--+----------------------------");

		//　変数iで縦方向を制御
		for(int i = 1;i<10;i++) {
			System.out.print(i + " | ");
			//　変数jで横方向を制御
			for(int j = 1; j<10;j++) {
				//　積の桁数で間のスペースを調整
				//　2桁ならスペース1文字、1桁なら2文字
				System.out.print((i*j)>9 ? " "+(i*j) :"  "+(i*j));
			}
			System.out.println();
		}

	}
}
