package SourceSample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample1d extends JFrame implements ActionListener{
	private static final String window_title = "イメージファイル入出力";
	private static final int window_width = 640;
	private static final String bt01_title = "開く";
	private static final int window_height = 400;
	private static final long serialVersionUID = 1L;
	private static final String bt01_code = "Open";
	private static final String bt02_title = "保存";
	private static final String bt02_code = "Save";
	JFileChooser fc = new JFileChooser();
	JButton bt01;
	JButton bt02;
	BufferedImage img = null;
	//　主処理
	public static void main(final String ar[]) {
		final JFrame f = new Sample1d();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Sample1d.window_width, Sample1d.window_height);
		f.setVisible(true);
	}
	//　部品セット
	Sample1d(){
		super(Sample1d.window_title);
		this.bt01 = new JButton(Sample1d.bt01_title);
		this.bt01.setActionCommand(Sample1d.bt01_code);
		this.bt01.addActionListener(this);
		this.bt02 = new JButton(Sample1d.bt02_title);
		this.bt02.setActionCommand(Sample1d.bt02_code);
		this.bt02.addActionListener(this);
		final Container c = this.getContentPane();
		final JPanel p1 = new JPanel();
		p1.add(this.bt01);
		p1.add(this.bt02);
		c.add(p1, BorderLayout.NORTH);
	}
	//　イベント
	public void actionPerformed(final ActionEvent ae) {
		if(ae.getActionCommand() == Sample1d.bt01_code) {
			final int fd = this.fc.showOpenDialog(this);
			try {
				if(fd == JFileChooser.APPROVE_OPTION) {
					try {
						this.img = ImageIO.read(this.fc.getSelectedFile());
						this.repaint();
					}catch(final Exception e) {
					}
				}
			}catch(final Exception e) {
			}
		}else if (ae.getActionCommand() == Sample1d.bt02_code) {
			final int fd = this.fc.showSaveDialog(this);
			try {
				if(fd == JFileChooser.APPROVE_OPTION) {
					try {
						final boolean rc = ImageIO.write(this.img,"jpeg",
								this.fc.getSelectedFile());
						this.repaint();
					}catch(final Exception e) {
					}
				}
			}catch(final Exception e) {
			}
		}
	}
	//　描画
	@Override
	public void update(final Graphics g) {
		this.paint(g);
	}
	@Override
	public void paint(final Graphics g) {
		final Graphics2D g2 = (Graphics2D) g;
		if(this.img == null) {
			g.clearRect(0, 0, Sample1d.window_width-1, Sample1d.window_height-1);
		}else {
			g2.drawImage(this.img, 0, 0, this);
			final Graphics2D g3 = this.img.createGraphics();
			g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			final Font font = new Font("Arial",Font.PLAIN,24);
			g3.setFont(font);
			g3.setColor(Color.red);
			g3.drawString("hear", 100, 100);
		}
		if(this.img != null) {
			g2.drawImage(this.img, 0, 0, this);
		}
		this.bt01.repaint();
		this.bt02.repaint();
	}
	
}