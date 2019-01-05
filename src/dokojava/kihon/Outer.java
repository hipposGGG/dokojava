package kihon;

interface IfNext{ int next();}
class Outer {
	IfNext func(final int[ ] x) {//　メソッド
		return new IfNext() {
			private int i = 0;
			public int next() {
				if(i >= x.length) i = 0;
				return x[i++];
			}
		};
//		//　ローカル内部クラス
//		class LocalInner implements IfNext{
//			private int i = 0;
//			public int next() {
//				if(i >= x.length)i = 0;
//				return x[i++];
//			}
//		}
//	return  new LocalInner();
	}
	//　以下は、上記のローカル内部クラスを使用するコード例
	public static void main(String[] args) {
		int[] a = {1,2,3};
		//IfNetのオブジェクトを取得
		IfNext obj = (new Outer()).func(a);
		for(int i = 0; i < 4; i++) {
			int n = obj.next();
			System.out.println(n);
		}
	}
//	int x;
//	class Inner{
//		int x;
//		void func() {
//			class LocalInner{ }
//		}
//	}
}
