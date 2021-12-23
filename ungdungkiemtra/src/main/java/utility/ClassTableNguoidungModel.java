package utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.NguoiDung;

public class ClassTableNguoidungModel {

	public DefaultTableModel setTableModel(List<NguoiDung> listItem, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			
		};
		try {
			dtm.setColumnIdentifiers(listColumn);
			int columns = listColumn.length;
			Object[] obj = null;
			int rows = listItem.size();
			if(rows > 0) {
				for(int i=0; i<rows; i++) {
					NguoiDung nguoiDung = listItem.get(i);
					obj = new Object[columns];
					obj[0] = (i+1);
					obj[1] = nguoiDung.getId();
					obj[2] = nguoiDung.getTenNguoidung();
					obj[3] = nguoiDung.getGioiTinh();
					obj[4] = nguoiDung.getSoDienthoai();
					obj[5] = nguoiDung.getNamSinh();
					obj[6] = nguoiDung.getDiaChi();
					obj[7] = nguoiDung.getLop().getTenLop();
					obj[8] = nguoiDung.getVaitro().getTenVaitro();
					dtm.addRow(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}
}
