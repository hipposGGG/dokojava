package kihon;

class TwoData<V,W> {
	private V v;
	private W w;

	public TwoData(V v,W w) {this.v = v; this.w = w;	}

	V getV() {	return v;}
	W getW() {	return w;}


	TwoData<String,Integer> data
		= new TwoData<String,Integer>("Generics",2);
	String vv = data.getV();
	Number ww = data.getW();
}
