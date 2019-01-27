package kihon;

import java.io.*;

public class BuffBinCopy {

	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(args[0]));
			bos = new BufferedOutputStream(new FileOutputStream(args[1]));
			int b;
			while((b = bis.read()) != -1) {
				bos.write(b);
			}
		}catch(FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException caught.");
		}catch(IOException ioe) {
			System.err.println("IOException caught.");
		}finally {
			try {
				if(bis != null) {	bis.close();}
				if(bos != null) {	bos.close();}
			}catch(Exception e) {
			}
		}

	}

}
