package kihon;

public interface TelephoneI {
	//　着信
	public void receiveCall(String caller);
	//　通話
	public void talkSomething(String msg);
	//　切断
	public void hungUp();
}
