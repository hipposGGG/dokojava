package kihon.lunchTime;

import java.util.*;

public class SandwichSet {
	private  Order[] items;
	SandwichSet(SandwichMenu item0, DrinkMenu item1, SideMenu item2) {
		items = new Order[]{item0,item1,item2};
	}

	public Object getName() {
		return items[0].getName()+" / "
				+items[1].getName()+" / "
				+items[2].getName();
	}

	static final String[] names = {"ハンバーガー","チーズバーガー",
						"コーラ(M)","コーヒー","ポテト(S)","サラダ"};
	static final int[] prices = {260,290,180,190,180,200};
	//　値段の取得
	public int getPrice() {

		int i,j,price = 0;

		for(i=0;i<names.length;i++) {
			//　セットメニュー内の名前をitemに格納
			String item = items[i].getName();
			for(j=0;j<prices.length;j++) {
				//　取得したセットメニューの内容（名前）をnameに設定
				String name = names[j];
				int len = name.length();
				//　セットメニュー全体の文字数の長さとセットメニューの内容の長さを比較
				if(len > item.length())
					continue;
				//　名前とセットメニュー全体の文字列が同じならpriceにその金額と同箇所の金額を加算する
				if(item.substring(0,len).equals(name)) {
					price += prices[j];
					break;
				}
			}
			//Jがメニューの中の名前を超えたとき
			if(j >= names.length)
				throw new IndexOutOfBoundsException(" 品名＝　"+item);
		}
		//　金額を返す
		return price;
	}
}