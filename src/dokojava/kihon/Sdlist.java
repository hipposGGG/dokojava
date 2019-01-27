package kihon;

import java.io.*;

public class Sdlist {

	public static void main(String[] args) {
		File dir = new File(args[0]);
		if(!(dir.isDirectory())) {
			System.err.println(args[0] + "is not dir");
			System.exit(1);
		}
		Sdlist sdlist = new Sdlist();
		sdlist.dosubDirect(dir,0);
	}

	void dosubDirect(File dir,int tabCnt) {
		displayAttrAndname(dir,tabCnt);

		File[] filelist = dir.listFiles();
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i].isDirectory()) {
				dosubDirect(filelist[i],tabCnt+1);
			}else {
				displayAttrAndname(filelist[i],tabCnt+1);
			}
		}
	}

	void displayAttrAndname(File fileOrDir,int tabCnt) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<tabCnt;i++) {
			sb.append("\t");
		}
		sb.append("[");
		sb.append(fileOrDir.isDirectory() ? "d" : "f");
		sb.append(fileOrDir.canRead() ? "r" : "-");
		sb.append(fileOrDir.canWrite() ? "w" : "-");
		sb.append("]");
		sb.append(fileOrDir.getName());
		System.out.println(sb.toString());
	}

}
