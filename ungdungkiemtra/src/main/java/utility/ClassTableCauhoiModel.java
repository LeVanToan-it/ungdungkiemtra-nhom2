package utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.BaiThi;
import entity.CauHoi;

public class ClassTableCauhoiModel {
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
		try {
			if(rows > 0) {
				for(int i=0; i<rows; i++) {
					CauHoi cauhoi = listItem.get(i);
					obj = new Object[columns];
					obj[0] = (i+1);
					obj[1] = cauhoi.getId();
					obj[2] = cauhoi.getTenCauhoi();
					obj[3] = cauhoi.getMonhoc().getTenMonhoc();
					obj[4] = cauhoi.getTralois().get(0);
					obj[5] = cauhoi.getTralois().get(1);
					obj[6] = cauhoi.getTralois().get(2);
					obj[7] = cauhoi.getTralois().get(3);
					
					dtm.addRow(obj);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return dtm;
	}
}
