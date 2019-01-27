package kihon;

import java.io.*;

public class Ecopy {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String ie = "JISAutoDetect";
		String oe = System.getProperty("file.encoding");
		String in = "",out = "";
		String line;

		for(int i = 0;i<args.length;i++) {
			if(args[i].equals("-ie")) {
				ie = args[++i];
			}else if(args[i].equals("-oe")) {
				oe = args[++i];
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
			System.out.println("Ecopy [-ie　入力バッファサイズ]");
			System.out.println("	  [-oe　出力バッファサイズ]");
			System.out.println("	  コピー元ファイル名");
			System.out.println("	  コピー先ファイル名");
			System.exit(1);
		}
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(in),ie));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out),oe));

			while((line = br.readLine()) != null) {
				bw.write(line,0,line.length());
				bw.newLine();
			}
		}catch(FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException caught.");
		}catch(IOException ioe) {
			System.err.println("IOException caught.");
		}finally {
			try {
				if(br != null) {	br.close();}
				if(bw != null) {	bw.close();}
			}catch(Exception e) {
			}
		}

	}

}
