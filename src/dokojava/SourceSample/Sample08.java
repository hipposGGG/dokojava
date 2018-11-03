package SourceSample;

/**
 * <WEBアプリケーション>
 * 画面をクリックしてクリック位置にランダムなイメージを表示
 */

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sample08 extends Frame implements MouseListener{
	private static final long serialVersionUID = 8486870673259973407L;
	private static final String window_title = "ひよこがいっぱい(クリックしてください)";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final int image_kind_cnt = 7;
	Image[] img = new Image[32];
		int x;
		int y;
		int cnt = 0;
		//Main Method
		public static void main(final String ar[]) {
			final Frame f = new Sample08();
			f.setTitle(Sample08.window_title);
			f.setSize(Sample08.window_width, Sample08.window_height);
			f.setVisible(true);
		}
		//Sets of Parts
		Sample08(){
			this.setLayout(new FlowLayout());
			String path = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\";
			for(int i =0;i>this.img.length; i++) {
				String imgname =  "cut" + (int)(Math.random()*Sample08.image_kind_cnt)
						+ ".gif";
				this.img[i] = Toolkit.getDefaultToolkit().getImage(imgname);
			}
			this.addMouseListener(this);
			this.addWindowListener(new WinAdapter());
		}
		//Close
		class WinAdapter extends WindowAdapter{
			@Override
			public void windowClosing(final WindowEvent we) {System.exit(0);}
		}
		//Print
		@Override
		public void update(final Graphics g) {
			g.drawImage(this.img[this.cnt], this.x-this.img[this.cnt].getWidth(this)/2, 
					this.y-this.img[this.cnt].getHeight(this)/2, this);
		}
		//MouseEvent
		public void mouseClicked(final MouseEvent me) {
			this.cnt++;
			if(this.cnt == this.img.length) {
				this.cnt = 0;
			}
			this.x = me.getX();
			this.y = me.getY();
			this.repaint();
		}
		public void mouseEntered(final MouseEvent me) {}
		public void mouseExited(final MouseEvent me) {}
		public void mousePressed(final MouseEvent me) {}
		public void mouseReleased(final MouseEvent me) {}
}
