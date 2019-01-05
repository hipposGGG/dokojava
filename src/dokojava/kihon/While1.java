package kihon;

public class While1 {
	public static void main(String[] args) {
		//　コピー元、コピー先配列
		int[] data = {54,17,27,38,45,-1,12,8};
		int[] plus = new int[data.length];
		//　ループを制御する変数
		int i = 0;
		// -1が見つかるまで（=-1でない間）実行する
		while(data[i] != -1) {
			//　コピー
			plus[i] = data[i];
			++i;
		}
		//　コピー結果を出力
		for(i = 0;i<plus.length;i++) {
			//2回目以降は”,”を付加して出力
			System.out.print((i>0 ? ",":" ") + plus[i]);
		}
		System.out.println();
	}
}
