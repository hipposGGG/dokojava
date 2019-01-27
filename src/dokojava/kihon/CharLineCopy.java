package kihon;

import java.io.*;

public class CharLineCopy {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
		
		String line;
		while((line =br.readLine()) != null) {
			bw.write(line,0,line.length());
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
