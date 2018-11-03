package SourceSample;

/**
 * <WEBアプリケーション>
 * 画面の上部にボタンを２つ置きます。
 * 開くボタンをクリックしたらファイルを選択して２行読んでテキストフィールドに文字列を出します。
 * 保存ボタンをクリックしたらファイルを選択してテキストフィールドの文字列をファイルに書き出します。
 */

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Sample04 extends Frame implements ActionListener{
	private static final String btnOpen_title = "Open";
	private static final String btnSave_title = "Save";
	private static final String window_title = "ファイル入出力";
	private static final int window_height = 400;
	private static final int window_width = 640;
	private static final int tf02_size = 20;
	private static final int tf01_size = 80;
	private static final String Select_Dialog_title 
		= "File Select";
	private static final String Save_Dialog_title 
		= "File Save";
	private static final long serialVersionUID = 1L;
	TextField tf01 = new TextField("",Sample04.tf01_size);
	TextField tf02 = new TextField("",Sample04.tf02_size);
	
	/*
	 * Main method (ウィンドウ表示)
	 */
	public static void main(final String[] args) {
		final Frame f = new Sample04();
		f.setTitle(Sample04.window_title);
		f.setSize(Sample04.window_width,Sample04.window_height);
		f.setVisible(true);
	}
	/*
	 * コンストラクタ（部品をセット）
	 */
	Sample04(){
		this.setLayout(new FlowLayout());
		final Button btnOpen = new Button(Sample04.btnOpen_title);
		final Button btnSave = new Button(Sample04.btnSave_title);
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		this.add(btnOpen);
		this.add(btnSave);
		this.add(this.tf01);
		this.add(this.tf02);
		this.addWindowListener(new WinAdapter());
	}
	/**
	 * ウィンドウを閉じる
	 */
	class WinAdapter extends WindowAdapter{
		@Override
		public  void windowClosing(final WindowEvent we) {
			System.exit(0);
		}
	}
	/**
	 * ボタンクリック時処理
	 */
	public void actionPerformed(final ActionEvent ae) {
		/**
		 * 開くボタンの場合
		 */
		if(ae.getActionCommand() == Sample04.btnOpen_title) {
			this.tf01.setText("");
			this.tf02.setText("");
			try {
				/**
				 * 対象ファイルを選択
				 */
				final FileInputStream fi 
					= new FileInputStream(this.openfile());
				final BufferedReader br 
					= new BufferedReader(new InputStreamReader(fi));
				final String s01 = br.readLine();
				//１レコード目に値がある場合
				if(s01 != null) {
					//上テキストフィールドに１レコード目の値をセット
					this.tf01.setText(s01);
				}
				final String s02 = br.readLine();
				//２レコード目にある値がある場合
				if(s02 != null) {
					//下テキストフィールドに１レコード目の値をセット
					this.tf02.setText(s02);
				}
				br.close();
				fi.close();
			}catch (final Exception e) {
			}
		}
		/**
		 * 保存ボタンの場合
		 */
		if(ae.getActionCommand() == Sample04.btnSave_title) {
			try {
				/**
				 * 対象ファイルを選択
				 */
				final FileOutputStream fo 
					= new FileOutputStream(this.writefile());
				final PrintStream ps = new PrintStream(fo);
				/**
				 * １レコード目に上テキストフィールドの値を書き込む
				 */
				ps.println(this.tf01.getText());
				/**
				 * ２レコード目に上テキストフィールドの値を書き込む
				 */
				ps.print(this.tf02.getText());
				ps.close();
				fo.close();
			}catch(final Exception e) {
			}
		}
	}
	/**
	 * ファイル選択ダイアログ表示
	 * @return 対象ファイル名
	 */
	String openfile() {
		final FileDialog fd 
			= new FileDialog(new Frame(),Sample04.Select_Dialog_title);
		fd.setVisible(true);
		final String fullpath = fd.getDirectory() + fd.getFile();
		fd.dispose();
		return fullpath;
	}
	/**
	 * 保存用ファイル選択ダイアログ表示
	 * @return 対象ファイル名
	 */
	String writefile() {
		final FileDialog fd = new FileDialog(new
					Frame(),Sample04.Save_Dialog_title,FileDialog.SAVE);
		fd.setVisible(true);
		final String fullpath = fd.getDirectory() + fd.getFile();
		fd.dispose();
		return fullpath;
	}
}




