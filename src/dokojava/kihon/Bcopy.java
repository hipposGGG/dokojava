package kihon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bcopy {
	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long bytes = 0;

		int iz = 2048,oz = 512;
		boolean isV = false;
		String in = "",out = "";

		for(int i=0; i<args.length; i++) {
			if(args[i].equals("-iz")) {
				iz = Integer.parseInt(args[++i]);
			}else if(args[i].equals("-oz")){
				oz = Integer.parseInt(args[++i]);
			}else if(args[i].equals("-v")){
				isV = true;
			}else {
				if(in.equals("")) {
					in = args[i];
				}else {
					out = args[i];
				}
			}
		}
		if(in.equals("") || out.equals("")) {
			System.out.println("Usage : ");
			System.out.println("Bcopy [-iz　入力バッファサイズ]");
			System.out.println("	  [-oz　出力バッファサイズ]");
			System.out.println("	  [-z]");
			System.out.println("	  コピー元ファイル名");
			System.out.println("	  コピー先ファイル名");
			System.exit(1);
		}
		try {
			bis = new BufferedInputStream(new FileInputStream(in),iz);
			bos = new BufferedOutputStream(new FileOutputStream(out),oz);
			int b;

			while((b = bis.read()) != -1) {
				bos.write(b);
				bytes++;
			}
		}catch(FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException caught");
		}catch(IOException ioe) {
			System.err.println("IOException caught");
		}finally {
			try {
				if(bis != null) { bis.close(); }
				if(bos != null) { bos.close(); }
			}catch(Exception e) {
			}
		}
		if(isV == true) {
			long et = System.currentTimeMillis();
			System.out.println(bytes + " byte(s) copied.");
			System.out.println("elapsed time =" + (et-st)/1000.0 + "sec");
		}
	}
}
