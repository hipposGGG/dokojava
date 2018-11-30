package SourceSample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Sample1a {
	private static final String window_title = "テーブルを表示";
	private static final int locateX = 50;
	private static final int locateY = 50;
	private static final int window_width = 320;
	private static final int window_height = 160;
	private static final int table_width = 300;
	private static final int table_height = 120;
	private static final int row_height = 20;
	Object[] colnames = {"名前","材質","サイズ","色","判定基準"};
	Object[][] rowData = {
			{"A01","布","大","白","柔らかさ"},
			{"K01","糸","細","赤","強度"},
			{"U01","紙","中","黄","安価"},
			{"S01","紐","中","黒","上質"},};
	//主処理
	public static void main(final String args[]) {
		final Sample1a sample = new Sample1a();
	}
	//コンストラクタ
	public Sample1a() {
		final JFrame f = new JFrame(Sample1a.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTable t = new JTable(this.rowData,this.colnames);
		t.setGridColor(Color.gray);
		final JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(t);
		sp.setPreferredSize(new Dimension(Sample1a.table_width,
				Sample1a.table_height));
		final JPanel p = new JPanel();
		p.add(sp);
		f.getContentPane().add(p, BorderLayout.CENTER);
		f.setBounds(Sample1a.locateX, Sample1a.locateY, 
				Sample1a.window_width, Sample1a.window_height);
		f.setVisible(true);
	}
}
