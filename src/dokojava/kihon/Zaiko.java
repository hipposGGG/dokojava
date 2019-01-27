package kihon;

import java.util.*;

//　①クラスZaikoの宣言
public class Zaiko {
	int cd;			//　コード
	String name;	//　品名
	double qty;		//　数量
	//　コンストラクタ
	Zaiko(int c,String n,double q){ cd = c;name = n;qty = q;}
	//　メソッド toString
	public String toString() { return "[" +cd+"/"+name+"/"+qty+"]";}

	public static void main(String[] args) {
		//　②コンストラクタの呼び出し
		Map<Number,Zaiko> zaiko = new HashMap<Number,Zaiko>();
		//　③オブジェクトの追加
		zaiko.put(1.0,new Zaiko(1,"goodsA",12.3));
		zaiko.put(2.0,new Zaiko(2,"goodsB",23.4));
		zaiko.put(3.0,new Zaiko(3,"goodsC",34.5));

		//　④画面表示
		System.out.println(zaiko);

		//　⑤コレクションビューの取得
		Set<Map.Entry<Number,Zaiko>> zent = zaiko.entrySet();

		//　⑥コレクションを取り出すループ
		for(Map.Entry<Number,Zaiko>zit : zent) {
			System.out.println("K = "+zit.getKey()+" ,V = "+zit.getValue());
		}
	}

}
