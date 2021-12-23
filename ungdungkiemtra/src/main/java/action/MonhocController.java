package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.MonHocDAO;
import dao.impl.MonHocImpl;
import entity.MonHoc;
import entity.NguoiDung;

public class MonhocController {
	private JButton btnSubmit;
	private JTextField jtfMamonhoc;
	private JTextField jtfTenmonhoc;
	private JTextField jtfHocky;
	private JTextField jtfSoTC;
	
	private MonHoc monhoc = null;
	private MonHocDAO monhocDAO = null;
	
	public MonhocController(JButton btnSubmit, JTextField jtfMamonhoc, JTextField jtfTenmonhoc,
			 JTextField jtfHocky, JTextField jtfSoTC) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfMamonhoc = jtfMamonhoc;
		this.jtfTenmonhoc = jtfTenmonhoc;
		this.jtfHocky = jtfHocky;
		this.jtfSoTC = jtfSoTC;
		
		monhocDAO = new MonHocImpl();
	}



	public void setView(MonHoc monhoc) {
		this.monhoc = monhoc;
		
		jtfMamonhoc.setText(monhoc.getId());
		String ma = monhoc.getId();
		if(ma != null){
			jtfMamonhoc.setEditable(false);
		}else {
			jtfMamonhoc.setEditable(true);
		}
		jtfTenmonhoc.setText(monhoc.getTenMonhoc());
		jtfHocky.setText(String.valueOf(monhoc.getHocKy()));
		jtfSoTC.setText(String.valueOf(monhoc.getSoTC()));
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfMamonhoc.getText().length() == 0 || jtfTenmonhoc.getText().length() == 0 || jtfHocky.getText().length() == 0
						|| jtfSoTC.getText().length() == 0) {
					//jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
					btnSubmit.setEnabled(false);
				}else {
					monhoc.setId(jtfMamonhoc.getText());
					monhoc.setTenMonhoc(jtfTenmonhoc.getText());
					monhoc.setHocKy(Integer.parseInt(jtfHocky.getText()));
					monhoc.setSoTC(Integer.parseInt(jtfSoTC.getText()));
					
					monhocDAO.themHoacChinhsuaMonhoc(monhoc);
					
					//jlbMessage.setText("Cập nhật dữ liệu thành công");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(0,200,83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(100,221,23));
			}
			
		});
		
	}
}
