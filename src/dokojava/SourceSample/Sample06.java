package SourceSample;

/**
 * 棒グラフの赤い点をドラッグしてテキストフィールドの数字を変更します。
 */

import java.awt.*;
import java.awt.event.*;

public class Sample06 extends Frame implements MouseListener,MouseMotionListener{
	TextField[] tf = new TextField[2];
	static int x1 = 303, y1 = 198, x2 = 343, y2 = 198, sw = 0;
	//Main Method
	public static void main(String ar[]) {
		Frame f = new Sample06();
		f.setTitle("棒グラフをドラッグして値変更");
		f.setSize(640,400);
		f.setVisible(true);
	}
	//sets of parts
	Sample06(){
		int i ;
		setLayout(new FlowLayout());
		for(i = 0;i < 2; i++) {
			tf[i] = new TextField("100",3);
			add(tf[i]);
		}
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WinAdapter());
	}
	//Close
	class WinAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we) {System.exit(0);}
	}
	//Print	
	public void paint(Graphics g) {
		String rs;
		int hei;
		int i ;
		int r = 2;
		g.clearRect(0, 0, 639, 399);
		for(i = 0; i < 2;i++) {
			rs = tf[i].getText();
			if(rs != null) {
				try {
					hei = Integer.parseInt(rs);
					g.setColor(Color.blue);
					g.fillRect(300+i*40, 300-hei, 10, hei);
					g.setColor(Color.red);
					g.fillOval(305+i*40-r, 300-hei-r, 2*r, 2*r);
					if(i == 0)y1 =300-hei-r;
					if(i == 0)y2 =300-hei-r;
				}catch(NumberFormatException e) {}
			}
		}
	}
	//MouseEvent
	public void mousePressed(MouseEvent me) {
		int x,y;
		sw = 0;
		x = me.getX();
		y = me.getY();
		if(Math.abs(x1-x)<3 && Math.abs(y1 - y) < 3) {
			sw = 1;
		}
		if(Math.abs(x2-x)<3 && Math.abs(y2 - y) < 3) {
			sw = 2;
		}	
	}
	//Mouse Drag Event
	public void mouseDragged(MouseEvent me) {
		int y;
		if(sw>0) {
			y = me.getY();
			tf[sw-1].setText(""+(298-y));
			repaint();
		}
	}
	public void mouseReleased(MouseEvent me) {}
	public void mouseMoved(MouseEvent me) {}
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mouseCliecked(MouseEvent me) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
