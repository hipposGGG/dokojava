package kihon;

public class C2 extends C1{
	public void override() {
		System.out.println("override : C2");
	}

	public static void hide() {
		System.out.println("hide : C2");
	}
	public void testSuper() {
		super.testSuper();
		System.out.println("testSuper : C2");
	}
}
