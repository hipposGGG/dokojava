package SourceSample;

/**
 * テキストフィールドをチェックしてメッセージダイアログを出します。
 */

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sample17 {
	private static final String btnNumericCheck_title = "数字チェック";
	private static final String btnNumericCheck_code = "Integer Check";
	private static final String btnNumberRangeCheck_title = "1~5";
	private static final String btnNumberRangeCheck_code = "1 - 5 check";
	private static final String window_title = "数字チェックとメッセージダイアログ";
	private static final int locateX = 10;
	private static final int locateY = 10;
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final int tf01_size = 5;
	private static final int tf02_size = 2;
	JTextField tf01 = new JTextField("",Sample17.tf01_size);
	JTextField tf02 = new JTextField("",Sample17.tf01_size);
	/**
	 * Main Method
	 */
	public static void main (final String[] args) {
		final Sample17 sample = new Sample17();
	}
	/**
	 * constract(部品をセットしてウィンドウ表示)
	 */
	public Sample17() {
		//Build Frame
		final JFrame f = new JFrame(Sample17.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add Button
		final JButton btnNumberCheck = new JButton(Sample17.btnNumericCheck_title);
		btnNumberCheck.setActionCommand(Sample17.btnNumericCheck_code);
		btnNumberCheck.addActionListener(new PushButtonActionListener(f));
		final JButton btnNumberRangeCheck = new JButton(Sample17.btnNumberRangeCheck_title);
		btnNumberRangeCheck.setActionCommand(Sample17.btnNumberRangeCheck_code);
		btnNumberRangeCheck.addActionListener(new PushButtonActionListener(f));
		//Button & TextField are Layout 
		final JPanel p1 = new JPanel();
		p1.add(btnNumberCheck);
		p1.add(btnNumberRangeCheck);
		f.getContentPane().add(p1, BorderLayout.NORTH);
		final JPanel p2 = new JPanel();
		p2.add(this.tf01);
		p2.add(this.tf02);
		f.getContentPane().add(p2, BorderLayout.CENTER);
		f.setVisible(true);
	}
	/**
	 * Button Click Method
	 */
	private class PushButtonActionListener implements ActionListener{
		private static final String message02 = "1~5の数字を入力してください";
		private static final String message01 = "数字を入力してください";
		private static final String ErrorDialog_title = "Error Message";
		JFrame f = null;
		public PushButtonActionListener(final JFrame af) {
			this.f = af;
		}
		public void actionPerformed(final ActionEvent ae) {
			final String strnum = "0123456789";
			final String str1to5 = "12345";
			/**
			 * Case of No.CheckButton
			 */
			if(ae.getActionCommand() == Sample17.btnNumericCheck_code) {
				final String str = Sample17.this.tf01.getText();
				if(str.length() == 0) {
					final ErrDialog dia = new ErrDialog(this.f,
							PushButtonActionListener.ErrorDialog_title,
							PushButtonActionListener.message01);
					return;
				}
				for(int i = 0; i < str.length();i++) {
					if(strnum.indexOf(str.substring(i, i + 1)) == -1) {
						final ErrDialog dia = new ErrDialog(this.f,
								PushButtonActionListener.ErrorDialog_title,
								PushButtonActionListener.message01);
						return;
					}
				}
			}
			/**
			 * 1~5ボタンの場合
			 */
			if(ae.getActionCommand() == Sample17.btnNumberRangeCheck_code) {
				final String str = Sample17.this.tf02.getText();
				if(str.length() != 1) {
					final ErrDialog dia = new ErrDialog(this.f,
							PushButtonActionListener.ErrorDialog_title,
							PushButtonActionListener.message02);
					return;
				}
				if(str1to5.indexOf(str) == -1) {
					final ErrDialog dia = new ErrDialog(this.f,
							PushButtonActionListener.ErrorDialog_title,
							PushButtonActionListener.message02);
					return;
				}
			}
		}
	}
	/**
	 * Display Dialog
	 */
	class ErrDialog extends JDialog {
		private static final int dialog_locateX = 10;
		private static final int dialog_locateY = 10;
		private static final int dialog_height = 100;
		private static final long serialversionUID = 1L;
		private static final int dialog_width = 200;
		ErrDialog(final Frame f,final String title,final String msg){
			//ModalDialog Buildｓ
			final JDialog dia = new JDialog(f,title,true);
			//add lavel
			final JLabel lab = new JLabel(msg);
			dia.getContentPane().add(BorderLayout.NORTH, lab);
			//Display ModalDialog
			dia.setLocation(ErrDialog.dialog_locateX,ErrDialog.dialog_locateY);
			dia.setSize(ErrDialog.dialog_width, ErrDialog.dialog_height);
			dia.setVisible(true);
		}
	}
}
