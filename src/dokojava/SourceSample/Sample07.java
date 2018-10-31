package SourceSample;

/* 
 * <WEBアプリケーション>
 * テキストフィールドをチェックしてメッセージダイアログを出します。
 */

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sample07 extends Frame implements ActionListener{
	private static final String btnNumericCheck_code = "Integer Check";
	private static final String btnNumberRangeCheck_code = "1 - 5 Check";
	private static final String window_title = "数字チェックとメッセージダイアログ";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final int tf01_size = 5;
	private static final int tf02_size = 1;
	private static final long serialVersionUID = 1L;
	TextField tf01 = new TextField("",Sample07.tf01_size);
	TextField tf02 = new TextField("",Sample07.tf02_size);
	
	//main method
	public static void main (final String ar[]) {
		final Frame f = new Sample07();
		f.setTitle(Sample07.window_title);
		f.setSize(Sample07.window_width,Sample07.window_height);
		f.setVisible(true);
	}
	//部品セット
	Sample07(){
		this.setLayout(new FlowLayout());
		final Button btnNumberCheck = new Button(Sample07.btnNumericCheck_code);
		final Button btnNumberRangeCheck = new Button(Sample07.btnNumberRangeCheck_code);
		btnNumberCheck.addActionListener(this);
		btnNumberRangeCheck.addActionListener(this);
		this.add(this.tf01);
		this.add(btnNumberCheck);
		this.add(this.tf02);
		this.add(btnNumberRangeCheck);
		this.addWindowListener(new WinAdapter());
	}
	//Close
	class WinAdapter extends WindowAdapter{
		@Override
		public void windowClosing(final WindowEvent we) {
			System.exit(0);
		}
	}
	//Event
	public void actionPerformed(final ActionEvent ae) {
		int i;
		String str;
		final String strnum = "0123456789";
		final String str1to5 = "123345";
		final String ErrorDialog_title = "Error_Msessage";
		final String message01 = "数字を入力してください";
		final String message02 = "１～５の数字を入力してください";
		if(ae.getActionCommand() == Sample07.btnNumericCheck_code) {
			str = this.tf01.getText();
			if(str.length() == 0) {
				final ErrDialog dia = new ErrDialog(this,ErrorDialog_title,message01,true);
				return;
			}
			for(i = 0; i < str.length();i++) {
				if(strnum.indexOf(str.substring(i, i+1)) == -1) {
					final ErrDialog dia = new ErrDialog(this,ErrorDialog_title,
							message01,true);
					return;
				}
			}
		}
		if(ae.getActionCommand()==Sample07.btnNumberRangeCheck_code) {
			str = this.tf02.getText();
			if(str.length() != 1) {
				final ErrDialog dia = new ErrDialog(this, ErrorDialog_title,
						message02,true);
				return;
			}
			if(str1to5.indexOf(str) == -1) {
				final ErrDialog dia = new ErrDialog(this,ErrorDialog_title,
						message02,true);
				return;
			}
		}
	}
	//Dialog
	class ErrDialog extends Dialog implements ActionListener {
		private static final String Dialog_button_title = "Close";
		private static final long serialVersionUID = 1L;
		ErrDialog(final Frame f,final String title,final String msg,final boolean modal){
			super(f,title,modal);
			this.setLayout(new FlowLayout());
			this.setSize(200, 100);
			final Label lbl = new Label(msg);
			this.add(lbl);
			final Button btc = new Button(ErrDialog.Dialog_button_title);
			this.add(btc);
			btc.addActionListener(this);
			this.setVisible(true);
		}
		//Event
		public void actionPerformed(final ActionEvent e) {
			this.dispose();
		}
	}
	
	
	
	
	
	
}
