package SourceSample;

/**
 * <WEBアプリケーション>
 * 画面の上部にプルダウンを置きます。
 * ルダウンを選択したら下にイメージを出します。
 */

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sample02 extends Frame implements ItemListener{
	private static final String image01_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk079.jpg";
	private static final String image02_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk089.jpg";
	private static final String image03_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\bk160.jpg";
	private static final String window_title = "プルダウン選択とイメージ表示";
	private static final int position_X = 100;
	private static final int position_Y = 150;
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final long serialVersionUID = 1L;
	Image img01;
	Image img02;
	Image img03;
	Choice cho;
	int flg_button = 0;
	//主処理
	public static void main(final String ar[]) {
		final Frame f = new Sample02();
		f.setTitle(Sample02.window_title);
		f.setSize(Sample02.window_width, Sample02.window_height);
		f.setVisible(true);
	}
	//部品セット
	Sample02(){
		this.setLayout(new FlowLayout());
		this.cho = new Choice();
		this.cho.add("1999");
		this.cho.add("2000");
		this.cho.add("2001");
		this.add(this.cho);
		this.cho.addItemListener(this);
		this.img01 = Toolkit.getDefaultToolkit()
				.getImage(Sample02.image01_filename);
		this.img02 = Toolkit.getDefaultToolkit()
				.getImage(Sample02.image02_filename);
		this.img03 = Toolkit.getDefaultToolkit()
				.getImage(Sample02.image03_filename);
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
	public void paint(final Graphics g) {
		if(this.flg_button > -1) {
			g.clearRect(0, 0, Sample02.window_width - 1, Sample02.window_height - 1);
		}
		if(this.flg_button == 0) {
			g.drawImage(this.img01, Sample02.position_X, Sample02.position_Y, this);
		}
		if(this.flg_button == 1) {
			g.drawImage(this.img02, Sample02.position_X, Sample02.position_Y, this);
		}
		if(this.flg_button == 2) {
			g.drawImage(this.img03, Sample02.position_X, Sample02.position_Y, this);
		}
	}
	//イベント
	public void itemStateChanged(final ItemEvent ie) {
		final int imgidx = this.cho.getSelectedIndex();
		if(imgidx == 0) {
			this.flg_button = 0;
			this.repaint();
		}
		if(imgidx == 1) {
			this.flg_button = 1;
			this.repaint();
		}
		if(imgidx == 2) {
			this.flg_button = 2;
			this.repaint();
		}
	}
}
