package SourceSample;

/**
 * <WEBアプリケーション開発>
 * 画面の上部にボタンを２つ置きます。
 * 開くボタンをクリックしたらファイルを選択して２行読んでテキストフィールドに文字列を出します。
 * 保存ボタンをクリックしたらファイルを選択してテキストフィールドの文字列をファイルに書き出します。
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * ファイル入出力
 */
public class Sample14 {
	private static final String btnSave_code = "Save";
	private static final String btnSave_title = "保存";
	private static final String btnOpen_code = "Open";
	private static final String btnOpen_title = "聞く";
	private static final String window_title = "ファイル入出力";
	private static final int window_height = 400;
	private static final int window_width = 640;
	private static final int tf02_size = 20;
	private static final int tf01_size = 20;
	JTextField tf01 = new JTextField("",Sample14.tf01_size);
	JTextField tf02 = new JTextField("",Sample14.tf02_size);
	
	/*
	 * 主処理
	 */
	public static void main(final String[] args) {
		final Sample14 sample = new Sample14();
	}
	/*
	 * コンストラクタ（部品をセットしてウィンドウ表示）
	 */
	Sample14(){
		final JFrame f = new JFrame(Sample14.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JButton btnOpen = new JButton(Sample14.btnOpen_title);
		btnOpen.setActionCommand(Sample14.btnOpen_code);
		btnOpen.addActionListener(new PushButtonActionListener(f));
		final JButton btnSave = new JButton(Sample14.btnSave_title);
		btnSave.setActionCommand(Sample14.btnSave_code);
		btnSave.addActionListener(new PushButtonActionListener(f));
		final JPanel p1 = new JPanel();
		p1.add(btnOpen);
		p1.add(btnSave);
		f.getContentPane().add(p1, BorderLayout.NORTH);
		final JPanel p2 = new JPanel();
		p2.add(this.tf01);
		p2.add(this.tf02);
		f.getContentPane().add(p2, BorderLayout.CENTER);
		f.setSize(Sample14.window_width, Sample14.window_height);
		f.setVisible(true);
	}
	private class PushButtonActionListener implements ActionListener{
		private static final String USER_DIR = "user.dir";
		JFrame f = null;
		public PushButtonActionListener(final JFrame af) {
			this.f = af;
		}
		/*
		 * ボタンクリック時処理
		 */
		public void actionPerformed(final ActionEvent ae) {
			/*
			 * 開くボタンの場合
			 */
			if(ae.getActionCommand() == Sample14.btnOpen_code) {
				Sample14.this.tf01.setText("");
				Sample14.this.tf02.setText("");
				/*
				 * 対象ファイルを選択
				 */
				final JFileChooser fc = new JFileChooser(System.getProperty(PushButtonActionListener.USER_DIR));
				final int fd = fc.showOpenDialog(this.f);
				try {
					if(fd == JFileChooser.APPROVE_OPTION) {
						final FileInputStream fi = new FileInputStream(fc.getSelectedFile());
						final BufferedReader br = new BufferedReader(new InputStreamReader(fi));
						final String s01 = br.readLine();
						//１レコード目に値がある場合
						if(s01 != null) {
							//上テキストフィールドに１レコード目の値をセット
							Sample14.this.tf01.setText(s01);
						}
						final String s02 = br.readLine();
						//2レコード目の値をセット
						if(s02 != null) {
							//下テキストフィールドのに１レコード目の値をセット
							Sample14.this.tf02.setText(s02);
						}
						br.close();
						fi.close();
					}
				}catch(final Exception ex) {
				}
				/*
				 * 保存ボタンの場合
				*/
			}else if(ae.getActionCommand() == Sample14.btnSave_code) {
				/*
				 * 対象ファイルを選択
				 */
				final JFileChooser fc = new JFileChooser(System.getProperty(PushButtonActionListener.USER_DIR));
				final int fd = fc.showSaveDialog(this.f);
				try {
					if(fd == JFileChooser.APPROVE_OPTION) {
						final FileOutputStream fo = new FileOutputStream(fc.getSelectedFile());
						final PrintStream ps = new PrintStream(fo);
						/*
						 * １レコード目に上テキストフィールドの値を書き込む
						 */
						ps.println(Sample14.this.tf01.getText());
						/**
						 * 2レコード目に上テキストフィールドの値を書き込む
						 */
						ps.println(Sample14.this.tf02.getText());
						ps.close();
						fo.close();
					}
				}catch(final Exception ex) {
				}
			}
		}
	}
	
	
	
	
	
}
