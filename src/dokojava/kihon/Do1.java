package kihon;

public class Do1 {
	public static void main(String[] args) {
		//　元、コピー先配列
		int[] data = { 54, 17, 27, 38, 45, -1, 12, 8 };
		int[] plus = new int[data.length];
		//ル制御する変数
		int i = 0;
		//-1が見つかるまで（=-1でないあ間)実行する
		do {
			//　コピー
			plus[i] = data[i];
		}while(data[i++] != -1) ;
		for(i =0;i<plus.length;i++) {
			System.out.print((i>0 ? "," : " ")+ plus[i]);
		}
		System.out.println();
	}
}
