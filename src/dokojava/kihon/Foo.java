package kihon;

abstract class Foo {
	String name;

	Foo(String name){
		this.name = name;
	}
	abstract void bar(String msg);
	abstract void baz();

	public void foobar(String msg) {
		System.out.println();
	}


}