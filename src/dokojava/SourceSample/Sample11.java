package SourceSample;

/**
 * 画面の上部にボタンを３つ置きます。
 * ボタンをクリックしたら下にメッセージを出します。
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Sample11 {
	private static final String bt01_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\twinstar.gif";
	private static final String bt02_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\pink.gif";
	private static final String bt03_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\white.gif";
	private static final String b0_title = "twin";
	private static final String b1_title = "pink";
	private static final String b2_title = "white";
	private static final String window_title = "絵ボタンクリックと文字列表示";
	private static final int position_X = 50;
	private static final int position_Y = 50;
	private static final int window_width = 300;
	private static final int window_height = 250;
	JLabel lbl = new JLabel("",SwingConstants.CENTER);
	
	//主処理
	public static void main(final String args[]) {
		final Sample11 sample = new Sample11();
	}
	//コンストラクタ
	public Sample11() {
		//フレームを作成
		final JFrame f = new JFrame(Sample11.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ボタンを追加
		final JButton bt01 = new JButton(new ImageIcon(Sample11.bt01_filename));
		bt01.setActionCommand(Sample11.b0_title);
		final JButton bt02 = new JButton(new ImageIcon(Sample11.bt02_filename));
		bt02.setActionCommand(Sample11.b1_title);
		final JButton bt03 = new JButton(new ImageIcon(Sample11.bt03_filename));
		bt03.setActionCommand(Sample11.b2_title);
		//ボタンにアクションリスナを登録
		bt01.addActionListener(new PushButtonActionListener());
		bt02.addActionListener(new PushButtonActionListener());
		bt03.addActionListener(new PushButtonActionListener());
		//ボタンとラベルをレイアウト
		final JPanel p = new JPanel();
		p.add(bt01);
		p.add(bt02);
		p.add(bt03);
		f.getContentPane().add(p, BorderLayout.NORTH);
		f.getContentPane().add(this.lbl, BorderLayout.CENTER);
		//フレームを表示
		f.setBounds(Sample11.position_X, Sample11.position_Y, 
				Sample11.window_width, Sample11.window_height);
		f.setVisible(true);
	}
	//ボタンクリック時のアクションリスナ
	private class PushButtonActionListener implements ActionListener{
		private static final String s1 = "星が二つです";
		private static final String s2 = "だんたら模様のぎざぎざ四角";
		private static final String s3 = "白くって小さな丸がみっつ";
		public void actionPerformed(final ActionEvent ae) {
			if(ae.getActionCommand().equals(Sample11.b0_title)) {
				Sample11.this.lbl.setText(PushButtonActionListener.s1);
			}else if(ae.getActionCommand().equals(Sample11.b1_title)) {
				Sample11.this.lbl.setText(PushButtonActionListener.s2);
			}else if(ae.getActionCommand().equals(Sample11.b2_title)) {
				Sample11.this.lbl.setText(PushButtonActionListener.s3);
			}
		}
	}
}
