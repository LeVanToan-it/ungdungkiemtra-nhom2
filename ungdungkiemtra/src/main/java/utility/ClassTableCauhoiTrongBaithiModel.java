package utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.CauHoi;

public class ClassTableCauhoiTrongBaithiModel {
	public DefaultTableModel setTableModel(List<CauHoi> listItem, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 8 ? Boolean.class : String.class;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		int columns = listColumn.length;
		Object[] obj = null;
		int rows = listItem.size();
		if(rows > 0) {
			for(int i=0; i<rows; i++) {
				CauHoi cauhoi = listItem.get(i);
				obj = new Object[columns];
				obj[0] = (i+1);
				obj[1] = cauhoi.getTenCauhoi();
				
				dtm.addRow(obj);
			}
		}
		return dtm;
	}
}
