package SourceSample;
/**
 * 90度、180度、270度回転したイメージを表示
 *
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
public class Sample19 extends JFrame{
	private static final String window_title = "回転したイメージ表示";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final String icon_filename = "D:\\eclipse-workspace\\dokojava\\src\\SourceSample\\img\\ICO_020.gif";
	private static final long serialVersionUID = 1L;
	Image img;
	//主な処理
	public static void main(final String ar[]) {
		final JFrame f = new Sample19();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Sample19.window_width, Sample19.window_height);
		f.setVisible(true);
	}
	//部品セット
	Sample19(){
		super(Sample19.window_title);
		this.img = this.getToolkit().getImage(Sample19.icon_filename);
	}
	//Print
	@Override
	public void update(final Graphics g) {
		this.paint(g);
	}
	@Override
	public void paint(final Graphics g) {
		final Graphics2D g2 = (Graphics2D) g;
		final int image_width = this.img.getWidth(this);
		g.drawImage(this.img, 50 - image_width / 2, 150 - image_width / 2, this);
		final AffineTransform at = new AffineTransform();
		at.rotate(90 * Math.PI / 180.0, 100, 150);
		g2.setTransform(at);
		g.drawImage(this.img, 100 - image_width / 2, 150 - image_width / 2, this);
		at.rotate(90 * Math.PI / 180.0, 150, 100);
		g2.setTransform(at);
		g.drawImage(this.img, 150 - image_width / 2, 150 - image_width / 2, this);
		at.rotate(90 * Math.PI / 180.0, 150, 100);
		g2.setTransform(at);
		g.drawImage(this.img, 200 - image_width / 2, 150 - image_width / 2, this);
	}
}
