package SourceSample;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * <WEBアプリケーション>
 * テキストフィールドの数字で棒グラフを描きます。
 */

public class Sample05 extends Frame implements ActionListener{
	private static final long serialVersionUID = 4392385647873054409L;
	private static final int origin_X = 100;
	private static final int origin_Y = 300;
	private static final int rect_pitch = 40;
	private static final int rect_width = 10;
	private static final int tf_size = 3;
	private static final String init_value = "100";
	private static final String btn_title = "Graph";
	private static final String window_title = "テキストフィールドの配列と棒グラフ";
	private static final int window_width = 640;
	private static final int window_height = 400;
	TextField[] tf = new TextField[12];
	//Main Method
	public static void main(final String ar[]) {
		final Frame f = new Sample05();
		f.setTitle(Sample05.window_title);
		f.setSize(Sample05.window_width, Sample05.window_height);
		f.setVisible(true);
	}
	//Sets of Parts
	Sample05(){
		this.setLayout(new FlowLayout());
		final Button btn = new Button(Sample05.btn_title);
		btn.addActionListener(this);
		for(int i = 0; i < this.tf.length; i++) {
			this.tf[i] = new TextField(Sample05.init_value,Sample05.tf_size);
			this.add(this.tf[i]);
		}
		this.add(btn);
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
	public void paint(final Graphics g) {
		g.clearRect(0, 0, Sample05.window_width - 1, Sample05.window_height - 1);
		for(int i = 0; i < this.tf.length;i++){
			final String rs = this.tf[i].getText();
			if(rs != null) {
				try {
					final int rect_height = Integer.parseInt(rs);
					g.drawRect(Sample05.origin_X + i * Sample05.rect_pitch,
							Sample05.origin_Y - rect_height,
							Sample05.rect_width, rect_height);
				}catch(final NumberFormatException e) {
				}
			}
		}
	}
	//Event
	public void actionPerformed(final ActionEvent ae) {
		if(ae.getActionCommand() == Sample05.btn_title) {
			this.repaint();
		}
	}
	
}
