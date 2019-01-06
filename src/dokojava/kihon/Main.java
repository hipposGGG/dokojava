package kihon;
import  java.io.*;

public class Main {
	public static void main(String[] args) {
		int[] data = {824, 170, -1393, 350, 410};
		int sum = 0;
		try {
			sum = Utils.arraySum(data);
			System.out.println("sum of data = " +sum);
		}catch(ArraySumException ase) {
			System.err.println(ase.getMessage());
			System.err.println("data[ " + ase.getExceptionIndex() + " ] =" + data[ase.getExceptionIndex()] );
		}
//		Main dispFile3 = new Main();
//		try {
//			dispFile3.someProcess(args[0]);
//		}catch(FileNotFoundException fnfe) {
//			System.err.println(args[0] + " could not open.");
//		}catch(IOException ioe) {
//			System.err.println("IOException caught.");
//		}

	}

	public void someProcess(String fileName) throws FileNotFoundException,IOException{
		Utils.displayFile(fileName);
	}



//		CallularPhoneImp cp = new CallularPhoneImp("123-4567");
//		polymorphism(cp);
//
//		System.out.println("---------------------");
//
//		FixedPhoneImp fp = new FixedPhoneImp("765-4321","someWhere");
//		polymorphism(fp);
//		System.out.println("---------------------");
//
//	}
//
//	public static void polymorphism(TelephoneI tel) {
//		tel.receiveCall("456-7890");
//		tel.hungUp();
//	}
}
