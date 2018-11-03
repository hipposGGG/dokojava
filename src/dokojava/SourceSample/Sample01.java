package SourceSample;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <WEBアプリケーション>
 * 画面の上部にボタンを３つ置きます。
 * ボタンをクリックしたら下にメッセージを出します。
 */


public class Sample01 extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final String window_title = "ボタンクリックで文字票列";
	private static final int window_width = 640;
	private	static final int window_height = 400;
	private static final String b0_title = "1999";
	private static final String b1_title = "2000";
	private static final String b2_title = "2001";
	private static final int Position_X = 100;
	private static final int Position_Y = 150;
	int flg_button = -1;
	//Main Method
	public static void main(final String ar[]) {
		final Frame f = new Sample01();
		f.setTitle(Sample01.window_title);
		f.setSize(Sample01.window_width, Sample01.window_height);
		f.setVisible(true);
	}
	//Sets of Parts
	Sample01(){
		this.setLayout(new FlowLayout());
		final Button b0 = new Button(Sample01.b0_title);
		final Button b1 = new Button(Sample01.b1_title);
		final Button b2 = new Button(Sample01.b2_title);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.add(b0);
		this.add(b1);
		this.add(b2);
		this.addWindowListener(new WinAdapter());
	}
	//Close
	class WinAdapter extends WindowAdapter {
		@Override
		public void windowClosing(final WindowEvent we) {
			System.exit(0);
		}
	}
	//Print
	@Override
	public void paint (final Graphics g) {
		final String s0 = "Your Love is true";
		final String s1 = "This is over, My love";
		final String s2 = "Marrge Me!";
		if(this.flg_button > -1) {
			g.clearRect(0, 0, Sample01.window_width - 1, Sample01.window_height - 1);
		}
		if(this.flg_button == 0){
			g.drawString(s0, Sample01.Position_X, Sample01.Position_Y);
		}
		if(this.flg_button == 1) {
			g.drawString(s1, Sample01.Position_X, Sample01.Position_Y);
		}
		if(this.flg_button == 2) {
			g.drawString(s2, Sample01.Position_X, Sample01.Position_Y);
		}
	}
	//Event
	public void actionPerformed(final ActionEvent ae) {
		if(ae.getActionCommand() == Sample01.b0_title) {
			this.flg_button = 0;
			this.repaint();
		}
		if(ae.getActionCommand() == Sample01.b1_title) {
			this.flg_button = 1;
			this.repaint();
		}
		if(ae.getActionCommand() == Sample01.b2_title) {
			this.flg_button = 2;
			this.repaint();
		}
	}
	

}
