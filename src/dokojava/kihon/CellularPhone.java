package kihon;

public class CellularPhone extends Telephone {
	// privateにアクセス修飾子を変換
	private int batteryRemaining = 100;

	public CellularPhone(String telNum) {
		telephoneNumber = telNum;
	}

	public void hungup() {
		System.out.println("bye!");
		batteryRemaining -= 10;
		System.out.println("batteryRemaining = " + batteryRemaining);
	}

	//　電池残量の取得
	public int getBatteryRemaining() {
		return batteryRemaining;
	}

	//　電池残量の更新
	public void setBatteryRemaining(int newRemaingng) {
		batteryRemaining = newRemaingng;
	}

	//　電池残量のチェック
	public boolean isBatteryEmpty() {
		return (batteryRemaining < 1);
	}

	//　電池残量のチェック(基準値)
	public boolean isBatteryEmpty(int limit) {
		return (batteryRemaining < limit);
	}

}
