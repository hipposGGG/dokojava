package kihon;

public class RunErrorSample {
	public static void main(String[] args) {
		String[] words= {"Write","Once","Write","AnyWhere"};

		for(int i = 1;i<5;i++) {
			System.out.println("words[" + i +"] = " + words[i]);
			if(i==3) {
				return;
			}

		}
	}
}
