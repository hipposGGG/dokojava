package SourceSample;
/**
 * テキストフィールドの数字で棒グラフを描きます。
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sample15 extends JFrame implements ActionListener{
	JTextField[] tf = new JTextField[12];
	JButton bt;
	//主処理
	public static void main(String ar[]) {
		JFrame f = new Sample15();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setSize(640, 400);
		f.setVisible(true);
	}
	//部品セット
	Sample15(){
		super("テキストフィールド配列と棒グラフ");
		int i;
		bt = new JButton("グラフ");
		bt.addActionListener(this);
		bt.setActionCommand("Graph");
		bt.addActionListener(this);
		Container c = getContentPane();
		JPanel p1 = new JPanel();
		for(i=0; i < 12 ; i++) {
			tf[i] = new JTextField("100",3);
			p1.add(tf[i]);
		}
		p1.add(bt);
		c.add(p1,BorderLayout.NORTH);
	}
	//描画
	public void paint(Graphics g) {
		String rs;
		double hei;
		int i;
		Graphics2D g2 = (Graphics2D)g;
		g.clearRect(0, 0, 639, 399);
		for(i= 0; i<12;i++) {
			tf[i].repaint();
			rs = tf[i].getText();
			if(rs != null) {
				try {
					hei = Double.parseDouble(rs);
					g2.draw(new Rectangle2D.Double(100+i*40,300-hei,10,hei));
				}catch(NumberFormatException e) {}
			}
		}
		bt.repaint();
	}
	//イベント
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "Graph") {
			repaint();
		}
	}
}
