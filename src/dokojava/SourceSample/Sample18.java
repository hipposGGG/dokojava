package SourceSample;

/**
 * 画面をクリックしてクリック位置にランダムなイメージを表示
 */

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Sample18 {
	private static final String window_title = "ひよこがいっぱい（クリックしてください）";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final int image_kind_cnt = 7;
	JLabel[] lbl = new JLabel[32];
	int cnt = 0;
	//　主処理
	public static void main(final String ar[]) {
		final Sample18 sample = new Sample18();
	}
	//　コンストラクタ
	public Sample18() {
		//　フレームを作成
		final JFrame f = new JFrame(Sample18.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel p = new JPanel();
		p.setLayout(null);
		//　ひよこラベルを32個作る
		String path = "D:\\eclipse-workspace\\dokojava\\src\\img\\";
		for(int i = 0;i < this.lbl.length;i++) {
			final String imgname = path + "cut" 
					+ (int) (Math.random () * Sample18.image_kind_cnt) + ".gif";
			final Icon img = new ImageIcon(imgname);
			this.lbl[i] = new JLabel("",img,SwingConstants.LEFT);
			p.add(this.lbl[i]);
		}
		//　マウスリスナを追加
		p.addMouseListener(new myMouseListener());
		//　フレームに追加
		f.getContentPane().add(p);
		//　フレームを表示
		f.setSize(Sample18.window_width, Sample18.window_height);
		f.getContentPane().setLayout(new GridLayout(1,1));
		f.setVisible(true);
	}
	//　マウスイベントを受け取るリスナ
	class myMouseListener extends MouseAdapter {
		private static final int lbl_width = 72;
		private static final int lbl_height = 88;
		@Override
		public void mouseClicked(final MouseEvent me) {
			Sample18.this.cnt = Sample18.this.cnt + 1;
			if(Sample18.this.cnt == Sample18.this.lbl.length) {
				Sample18.this.cnt = 0;
			}
			final int x = me.getX();
			final int y = me.getY();
			Sample18.this.lbl[Sample18.this.cnt].setBounds(
					x-myMouseListener.lbl_width / 2,
					y - myMouseListener.lbl_height / 2,
					myMouseListener.lbl_width,myMouseListener.lbl_height);	
		}
	}
}
