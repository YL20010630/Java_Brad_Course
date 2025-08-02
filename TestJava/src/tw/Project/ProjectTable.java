package tw.Project;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProjectTable extends JTable {
	private ProjectDB db;
	public ProjectTable() {
		try {
			db = new ProjectDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		setModel(new dataModel());
	}
	
	private class dataModel extends DefaultTableModel {
		
		@Override
		public int getRowCount() {
			return db.getRows();
		}
		@Override
		public int getColumnCount() {
			return db.getCols();
		}
		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}
		@Override
		public String getColumnName(int column) {
			return db.getColName(column);
		}
		@Override
		public void setValueAt(Object Value, int row, int column) {
			db.updateData(row, column, (String)Value);
		}
		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0;
		}
		
	}
}
