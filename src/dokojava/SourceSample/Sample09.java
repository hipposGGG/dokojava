package SourceSample;

/* 
 * <WEBアプリケーション>
 * 90度、180度、270度回転したイメージを表示
 */

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class Sample09 extends Frame{
	private static final int LocateY = 100;
	private static final int picture_pitch = 50;
	private static final String window_title = "回転したイメージ表示";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final String icon_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\ICO_020.png";
	private static final long serialVersionUID = 1L;
	Image img01;
	//主処理
	public static void main(final String ar[]) {
		final Frame f = new Sample09();
		f.setTitle(Sample09.window_title);
		f.setSize(new Dimension(Sample09.window_width, Sample09.window_height));
		f.setVisible(true);
	}
	//部品セット
	Sample09(){
		this.img01 = this.getToolkit().getImage(Sample09.icon_filename);
		this.addWindowListener(new WinAdapter());
	}
	//閉じる
	class WinAdapter extends WindowAdapter{
		@Override
		public void windowClosing(final WindowEvent we) {
			System.exit(0);
		}
	}
	//描画
	@Override
	public void update(final Graphics g) {
		this.paint(g);
	}
	@Override
	public void paint(final Graphics g) {
		int w ;
		Image img;
		final PixelGrabber pg = new PixelGrabber(this.img01,0,0,-1,-1,true);
		try {
			if (pg.grabPixels()) {
				w = pg.getWidth();
				final int[] op = (int[]) pg.getPixels();
				final int[] np = new int[w * w];
				g.drawImage(this.img01, 0, 100, this);
				for(int y = 0; y < w; y++) {
					for (int x = 0; x < w; x++) {
						np[(w - 1 - y) + x * w] = op[x + y * w];
					}
				}
				img = this.createImage(new MemoryImageSource(w,w,np,0,w));
				g.drawImage(img, Sample09.picture_pitch, Sample09.LocateY, this);
				for(int y = 0; y < w; y++) {
					for(int x = 0; x < w; x++) {
						np[(w - 1 - x) + (w - 1 -y) * w] = op[x + y * w];
					}
				}
				img = this.createImage(new MemoryImageSource(w,w,np,0,w));
				g.drawImage(img, Sample09.picture_pitch * 2, Sample09.LocateY, this);
				for(int y = 0; y < w; y++) {
					for(int x = 0; x < w; x++) {
						np[y + (w - 1 - x) * w] = op[x + y * w];
					}
				}
				img =this.createImage(new MemoryImageSource(w,w,np,0,w));
				g.drawImage(img, Sample09.picture_pitch * 3, Sample09.LocateY, this);
			}
		}catch(final InterruptedException ie) {
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
