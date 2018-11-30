package SourceSample;

/**
 * 棒グラフの赤い点をドラッグしてテキストフィールドの数字を変更します。
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sample16 extends JFrame implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 
			-5235421690704702101L;
	private static final int origin_X = 300;
	private static final int origin_Y = 300; 
	private static final int rect_pitch = 40;
	private static final int rect_width = 10;
	private static final String tf_init_value = "100";
	private static final int tf_size = 3;
	private static final int eps = 3;
	private static final String window_title = "棒グラフをドラッグして値変更";
	private static final int window_width = 640;
	private static final int window_height = 400;
	JTextField[] tf = new JTextField[2];
	static double x1 = 303;
	static double y1 = 198;
	static double x2 = 343;
	static double y2 = 198;
	static int sw = 0;
	//　主処理
	public static void main (final String ar[]) {
		final JFrame f = new Sample16();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Sample16.window_width, Sample16.window_height);
		f.setVisible(true);
	}
	//　部品セット
	Sample16(){
		super(Sample16.window_title);
		final Container c = this.getContentPane();
		final JPanel p1 = new JPanel();
		for(int i = 0; i < this.tf.length;i++) {
			this.tf[i] = new JTextField(Sample16.tf_init_value,Sample16.tf_size);
			p1.add(this.tf[i]);
		}
		c.add(p1, BorderLayout.NORTH);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	//　描画
	@Override
	public void paint(final Graphics g) {
		final double r = 2;
		final Graphics2D g2 = (Graphics2D)g;
		g.clearRect(0, 0, Sample16.window_width-1, Sample16.window_height-1);
		for(int i = 0; i<this.tf.length; i++) {
			this.tf[i].repaint();
			final String rs = this.tf[i].getText();
			if(rs != null) {
				try {
					final double rect_height = Double.parseDouble(rs);
					g2.setPaint(Color.blue);
					g2.fill(new Rectangle2D.Double(Sample16.origin_X + i 
							* Sample16.rect_pitch,Sample16.origin_Y 
							- rect_height,Sample16.rect_width,rect_height));
					g2.setPaint(Color.red);
					g2.fill(new Ellipse2D.Double(Sample16.origin_X + 5 + i
							* Sample16.rect_pitch - r,Sample16.origin_Y
							- rect_height - r, 2 * r, 2 * r));
					if(i == 0) {
						Sample16.y1 = Sample16.origin_Y - rect_height - r;
					}
					if(i == 1) {
						Sample16.y2 = Sample16.origin_Y - rect_height - r;
					}
				}catch(final NumberFormatException e) {
				}
			}
		}
	}
	@Override
	public void mousePressed(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		Sample16.sw = 0;
		final double x = me.getX();
		final double y = me.getY();
		if((Math.abs(Sample16.x1 - x) < Sample16.eps)
				&& (Math.abs(Sample16.y1 - y) < Sample16.eps)) {
			Sample16.sw = 1;
		}
		if((Math.abs(Sample16.x2 - x) < Sample16.eps)
				&& (Math.abs(Sample16.y2 - y) < Sample16.eps)) {
			Sample16.sw = 2;
		}
	}
	@Override
	public void mouseDragged(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		if(Sample16.sw > 0) {
			final int y = me.getY();
			this.tf[Sample16.sw -1].setText("" + (Sample16.origin_Y - 2 - y));
			this.repaint();
		}
	}
	@Override
	public void mouseMoved(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseClicked(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseEntered(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseExited(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	@Override
	public void mouseReleased(final MouseEvent me) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
}
