package SourceSample;
/**
 * 画面の上部にプルダウンを置きます。
 * プルダウンを選択したら下にイメージを出します。
 */

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Sample12 {
	private static final String image01_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk079.jpg";
	private static final String image02_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk089.jpg";
	private static final String image03_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk160.jpg";
	private static final String window_title = "プルダウン選択とイメージ表示";
	private static final int locateX = 50;
	private static final int LocateY = 50;
	private static final int window_width = 300;
	private static final int window_height = 250;
	JComboBox cb;
	JLabel lbl;
	Icon i01;
	Icon i02;
	Icon i03;
	//主処理
	public static void main(final String args[]) {
		final Sample12 sample = new Sample12();
	}
	//コンストラクタ
	public Sample12() {
		//フレームを作成
		final JFrame f = new JFrame(Sample12.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.i01 = new ImageIcon(Sample12.image01_filename);
		this.i02 = new ImageIcon(Sample12.image02_filename);
		this.i03 = new ImageIcon(Sample12.image03_filename);
		this.cb = new JComboBox();
		final String[] strmenu = { "1999","2000","2001"};
		for(String element : strmenu) {
			this.cb.addItem(element);
		}
		this.lbl = new JLabel("", this.i01, SwingConstants.CENTER);
		//コンボボックスにアイテムリスナを登録
		this.cb.addItemListener(new SelectItemListener());
		//コンボボックスとラベルをレイアウト
		f.getContentPane().add(this.cb, BorderLayout.NORTH);
		f.getContentPane().add(this.lbl, BorderLayout.CENTER);
		//フレームを表示
		f.setBounds(Sample12.locateX, Sample12.LocateY,
				Sample12.window_width, Sample12.window_height);
		f.setVisible(true);
	}
	//コンボボックスsで発生したアイテムイベントを受け取るリスナ
	class SelectItemListener implements ItemListener {
		public void itemStateChanged(final ItemEvent ie) {
			final int imgidx = Sample12.this.cb.getSelectedIndex();
			if(imgidx == 0) {
				Sample12.this.lbl.setIcon(Sample12.this.i01);
			}else if(imgidx == 1) {
				Sample12.this.lbl.setIcon(Sample12.this.i02);
			}else if(imgidx == 2) {
				Sample12.this.lbl.setIcon(Sample12.this.i03);
			}
		}

		
	}
}
