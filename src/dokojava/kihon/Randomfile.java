package kihon;

import java.io.*;

public class Randomfile {

	public static void main(String[] args) throws IOException{
		Randomfile randomfile = new Randomfile();
		randomfile.test();
	}

	void test() throws IOException{
		String filename = "rand.dat";
		int[] intArray = {10,20,30,40,50,60,70,80,90};

		//intArrayの内容をraf1へ出力
		RandomAccessFile raf1 = new RandomAccessFile(filename,"rw");
		for(int i =0;i<intArray.length;i++) {
			raf1.writeInt(intArray[i]);
		}
		raf1.close();

		//raf1の内容を表示
		displayRandomFile(filename);

		//raf1にデータを追加
		raf1 = new RandomAccessFile(filename,"rw");
		raf1.seek(raf1.length());
		raf1.writeInt(100);
		raf1.close();

		//再度raf1の内容を表示
		displayRandomFile(filename);
	}

	//RandomAccessFileの内容を表示する
	void displayRandomFile(String filename)throws IOException{
		RandomAccessFile raf2 = new RandomAccessFile(filename,"r");
		for(int i =0; raf2.getFilePointer()<raf2.length(); i++) {
			System.out.print((i == 0 ? "" : ",") + raf2.readInt());
		}
		System.out.println("");
		raf2.close();
	}

}
