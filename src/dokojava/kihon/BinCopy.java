package kihon;

import java.io.*;

public class BinCopy {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
		}catch(FileNotFoundException fnfe){
			System.err.println("FileNotFoundException caught.");
		}catch(IOException ioe) {
			System.err.println("IOException caught.");
		}finally {
			try {
				if(fis != null) {	fis.close();}
				if(fos != null) {	fos.close();}
			}catch(Exception e) {

			}
		}
	}
}
