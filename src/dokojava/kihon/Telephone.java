package kihon;

public class Telephone {
	String telephoneNumber = "123-4567";
	
	//メソッド
	public void reciverCall(String caller) {
		System.out.println("ring!ring!ring!");
		System.out.println("this is " + caller);
	}
		
	public void talkSomething(String msg) {
		System.out.println("[" + msg + "]");
	}
		
	public void hungup() {
		System.out.println("bye!");
	}
}
