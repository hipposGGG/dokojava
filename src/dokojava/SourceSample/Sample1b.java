package SourceSample;

/**
  *  ソース上に作ったデータをちょっと修飾して一覧表に表示します。
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Sample1b {
	private static final String window_title = "ちょっと編集してテーブル表示";
	private static final int locate_X = 50;
	private static final int locate_Y = 50;
	private static final int window_width = 320;
	private static final int window_height = 160;
	private static final int table_width = 300;
	private static final int table_height = 120;
	private static final int table_row_height = 20;
	//　データ
	Object[] colNames = { "名前","数","サイズ","色","判断基準"};
	Object[][] rowData = {{ "A01","20","大","白","柔らかさ"},
			{ "K01","5","細","赤","強度"},
			{ "U01","100","中","黄","安価"},
			{ "S01","2.5","中","緑","上質"},};
	//　主処理
	public static void main(final String args[]) {
		final Sample1b sample = new Sample1b();
	}
	//　コンストラクタ
	public Sample1b() {
		final JFrame f = new JFrame(Sample1b.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTable t = new JTable(this.rowData,this.colNames);
		t.setRowHeight(Sample1b.table_row_height);
		t.setGridColor(Color.gray);
		for(int i = 0; i<t.getColumnCount(); i++) {
			final TableColumn tc = t.getColumn(t.getColumnName(i));
			tc.setCellRenderer(new MyRenderer());
		}
		final JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(t);

		sp.setPreferredSize(new Dimension(Sample1b.table_width,
				Sample1b.table_height));
		final JPanel p = new JPanel();
		p.add(sp);
		f.getContentPane().add(p, BorderLayout.CENTER);
		f.setBounds(Sample1b.locate_X, Sample1b.locate_Y, 
				Sample1b.window_width, Sample1b.window_height);
		f.setVisible(true);
	}
	//　セルレンダラ
	class MyRenderer extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;
		@Override
		public  Component getTableCellRendererComponent(final JTable table,
				final Object value, final boolean isSelected,
				final boolean hasFocus,final int row, final int column) {
			switch(column) {
			case 1:
				this.setHorizontalAlignment(SwingConstants.RIGHT);
				break;
			case 2:
				this.setHorizontalAlignment(SwingConstants.CENTER);
				break;
			case 3:
				this.setHorizontalAlignment(SwingConstants.CENTER);
				switch(row){
				case 0:
					this.setBackground(Color.black);
					this.setForeground(Color.white);
					break;
				default:
					this.setBackground(Color.yellow);
					this.setForeground(Color.red);
					break;
				}
			default:
				break;
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					
		}
		
	}
}

