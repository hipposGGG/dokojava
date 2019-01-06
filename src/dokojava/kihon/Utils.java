package kihon;

import  java.io.*;

public class Utils {
	public static int arraySum(int[] array)
				throws ArraySumException{
		int sum =0;
		for(int i = 0; i < array.length;i++) {
			if(array[i] > 999) {
				throw new ArraySumNumUnderException(i);
			}else if (array[i] < -999) {
				throw new ArraySumNumOverException(i);
			}
			sum += array[i];
		}
		return sum;
	}


	public static void displayFile(String fileName) throws FileNotFoundException,IOException {
		BufferedReader in = null;
		try {
			//　ファイルOPEN
			in = new BufferedReader(new FileReader(fileName));
			//　標準出力へ出力
			String temp;
			while((temp = in.readLine()) != null) {
				System.out.println(temp);
			}
		}finally {
			// ファイルCLOSE
			if (in != null) {	in.close();}
		}
	}
}
