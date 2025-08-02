package tw.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
	自訂表格
*/

public class GiftTable extends JTable {
	
	private GiftDB db;
	public GiftTable() {
		
//		外接class要在主建構式外宣告，內new
//		因外接的類別GiftDB是外接資料庫的類別，可能拋出例外，故須try-catch
		try {
			db = new GiftDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		
//		使用內部類別當作表格的資料模型，根據new GiftModel()設置模型
		setModel(new GiftModel());
	}
	
	public void delRow() {
		System.out.println(getSelectedRow());		// 要在監聽點擊del裡print才有用
		int delRow = getSelectedRow();		// 選取該行的行號
		if (delRow != -1) {
			db.delData(delRow);
			repaint();
		}
	}

//	extends DefaultTableModel 可以自訂 table 的值、行、列
//	有這個才能用getRowCount()、getValueAt(row, col)、setValueAt()、isCellEditable(row, col)等
	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}
		
//		回傳某格的值，為了JTable顯示格子內容
		@Override
		public Object getValueAt(int row, int column) {
//			return String.format("lab: %d×%d", row, column);
			return db.getData(row, column);
		}

		@Override
		public String getColumnName(int column) {
			return db.getColName(column);
		}

//		設定某格的新值，使用者改寫內容時需要更新資料，編輯儲存格時自動呼叫
		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData(row, column, (String)aValue);
		}

//		isCellEditable() 是用來控制哪一格能能被編輯
		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0;		
//			第一欄（id）不可編輯，除了第一欄都可以被編輯，避免修改主鍵（ID）
		}
		
		
//		系統會自動呼叫（callback） -> 有 @Override，而且繼承某個已知框架類別（JTable、JPanel 等）
//		一定要自己手動呼叫 -> 沒有 @Override，是你自己命名的函式
		
	}
	
}

