package SourceSample;


/**
 * メニューバーからファイル保存を選択して一覧表をファイルに保存します。
 * セルをダブルクリックすると値の修正ができます。
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Sample1c {
	private static final String window_title = "メニューバー";
	private static final int locateX = 50;
	private static final int locateY = 50;
	private static final int window_width = 320;
	private static final int window_height = 185;
	private static final int table_width = 300;
	private static final int table_height = 120;
	private static final int row_height = 20;
	private static final String tab = "\t";
	//　データ
	Object[] colNames = {"名前","材質","サイズ","色","判断基準"};
	Object[][] rowData = {
			{"A01","布","大","白","柔らかさ"},
			{"K01","糸","細","赤","強度"},
			{"U01","紙","中","黄","安価"},
			{"S01","紐","中","黒","上質"},};
	JTable t = new JTable(this.rowData,this.colNames);
	//　主処理
	public static void main(final String args[]) {
		final Sample1c sample = new Sample1c();
	}
	//　コンストラクタ
	public Sample1c() {
		//　フレームを作成
		final JFrame f = new JFrame(Sample1c.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//　メニューバー
		final JMenuBar mb = new JMenuBar();
		final JMenu mFile = new JMenu("ファイル");
		final JMenuItem iSaveAs = new JMenuItem("別名で保存…");
		final JMenuItem iExit = new JMenuItem("終了");
		mFile.add(iSaveAs);
		mFile.addSeparator();
		mFile.add(iExit);
		mb.add(mFile);
		f.getRootPane().setJMenuBar(mb);
		//　テーブルを追加
		this.t.setRowHeight(Sample1c.row_height);
		this.t.setGridColor(Color.gray);
		final JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(this.t);
		sp.setPreferredSize(new Dimension(Sample1c.table_width,Sample1c.window_height));
		final JPanel p = new JPanel();
		p.add(sp);
		f.getContentPane().add(p, BorderLayout.CENTER);
		//　フレームを表示
		f.setBounds(Sample1c.locateX,Sample1c.locateY,
				Sample1c.window_width,Sample1c.window_height);
		f.setVisible(true);
		//　終了クリック時のアクションリスナ
		iExit.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent ae) {
				System.exit(0);
			}
		});
		//　別名で保存クリック時のアクションリスナ
		iSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent ae) {
				final JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
				//　ダイアログの表示
				final int fd = fc.showSaveDialog(f);
				try {
					if(fd == JFileChooser.APPROVE_OPTION) {
						final FileOutputStream fo = new FileOutputStream(fc.getSelectedFile());
						final PrintStream ps = new PrintStream(fo);
						ps.println(Sample1c.this.t.getValueAt(0, 0)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(0, 1)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(0, 2)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(0, 3)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(0, 4));
						ps.println(Sample1c.this.t.getValueAt(1, 0)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(1, 1)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(1, 2)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(1, 3)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(1, 4));
						ps.println(Sample1c.this.t.getValueAt(2, 0)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(2, 1)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(2, 2)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(2, 3)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(2, 4));
						ps.println(Sample1c.this.t.getValueAt(3, 0)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(3, 1)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(3, 2)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(3, 3)
								+ Sample1c.tab
								+ Sample1c.this.t.getValueAt(3, 4));
						ps.close();
						fo.close();
					}
				}catch(final Exception ex) {
				}
			}
		});
	}
}
