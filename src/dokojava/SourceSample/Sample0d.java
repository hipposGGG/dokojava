package SourceSample;

/**
 * <WEBアプリケーション>
 * Openボタンでファイルダイアログで指定した正方形イメージと90度回転したイメージを表示
 * Saveボタンでファイルダイアログで指定したファイル名で90度回転したイメージをjpegで保存
 */

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import com.sun.image.codec.jpeg.*;

public class Sample0d extends Frame implements ActionListener{
	Image img01,img02;
	int w,h;
	//Main Method
	public static void main(String ar[]) {
		Frame f = new Sample0d();
		f.setTitle("イメージファイル入出力");
		f.setSize(new Dimension(640,400));
		f.setVisible(true);
	}
	//Sets of Parts
	Sample0d(){
		setLayout(new FlowLayout());
		Button b01 = new Button("Open");
		Button b02 = new Button("Save");
		b01.addActionListener(this);
		b02.addActionListener(this);
		add(b01);
		add(b02);
		addWindowListener(new WinAdapter());
	}
	//Close
	class WinAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we) { System.exit(0);}
	}
	//Event
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "Open") {
			try {
				String Filename = openfile();
				if(Filename != null) img01 = getToolkit().getImage(Filename);
				repaint();
			}catch(Exception e) {}
		}
		if(ae.getActionCommand() == "Save") {
			if(img02 != null) {
				try {
					String Filename = writefile();
					if(Filename != null) {
						FileOutputStream fo = new FileOutputStream(Filename);
						BufferedImage bi = new BufferedImage(
									w,w,BufferedImage.TYPE_INT_RGB);
						Graphics gc = bi.getGraphics();
						gc.drawImage(img02, 0, 0, this);
						JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fo);
						fo.close();	
					}
				}catch(Exception ex) {}
			}
		}
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		if(img01 != null) {
			PixelGrabber pg = new PixelGrabber(img01,0,0,-1,-1,true);
			try {
				if(pg.grabPixels()) {
					w = pg.getWidth();
					int[] op = (int[]) pg.getPixels();
					int[] np = (int[]) new int[w * w];
					g.drawImage(img01,10,100,this);
					for(int y = 0;y < w; y++) {
						for(int x = 0; x < w; x++) np[(w - 1 - y) + x * w] = op[x + y * w];
					}
					img02 = createImage(new MemoryImageSource(w,w,np,0,w));
					g.drawImage(img02, 20 + w, 100, this);
				}
			}catch(InterruptedException ie) {}
		}
	}
	//OpenDialog
	String openfile() {
		FileDialog fd = new FileDialog(new Frame(),"File Select");
		fd.show();
		String fulpath = fd.getDirectory() + fd.getFile();
		fd.dispose();
		return fulpath;
	}
	//SaveDialog
	String writefile() {
		FileDialog fd = new FileDialog(new Frame(),"File Save",FileDialog.SAVE);
		fd.show();
		String fulpath = fd.getDirectory() + fd.getFile();
		fd.dispose();
		return fulpath;
	}

}
