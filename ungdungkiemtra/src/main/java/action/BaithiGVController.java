package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.BaiThiDAO;
import dao.MonHocDAO;
import dao.impl.BaiThiImpl;
import dao.impl.MonHocImpl;
import entity.BaiThi;
import entity.NguoiDung;

public class BaithiGVController {
	private JButton btnSubmit;
	private JTextField jtfMabaithi;
	private JTextField jtfTenbaithi;
	private JTextField jtfMonhoc;
	private JTextArea jtaMota;
	
	private BaiThi baithi = null;
	private MonHocDAO monhocDAO = null;
	private BaiThiDAO baithiDAO = null;
	
	public BaithiGVController(JButton btnSubmit, JTextField jtfMabaithi, JTextField jtfTenbaithi, JTextField jtfMonhoc, JTextArea jtaMota) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfMabaithi = jtfMabaithi;
		this.jtfTenbaithi = jtfTenbaithi;
		this.jtfMonhoc = jtfMonhoc;
		this.jtaMota = jtaMota;
		
		this.monhocDAO = new MonHocImpl();
		this.baithiDAO = new BaiThiImpl();
	}



	public void setView(BaiThi baithi) {
		this.baithi = baithi;
		
		try {
			jtfMabaithi.setText(baithi.getId());
			String ma = baithi.getId();
			if(ma != null) {
				jtfMabaithi.setEditable(false);
			}else {
				jtfMabaithi.setEditable(true);
			}
			jtfTenbaithi.setText(baithi.getTenBaithi());
			jtfMonhoc.setText(baithi.getMonhoc().getTenMonhoc());
			jtaMota.setText(baithi.getMota());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfMabaithi.getText().length() == 0 || jtfTenbaithi.getText().length() == 0 || jtfMonhoc.getText().length() == 0
						|| jtaMota.getText().length() == 0) {
					//jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
					btnSubmit.setEnabled(false);
				}else {
					baithi.setId(jtfMabaithi.getText());
					baithi.setTenBaithi(jtfTenbaithi.getText());
					baithi.setMota(jtaMota.getText());
					baithi.setMonhoc(monhocDAO.layMonhocTheoTenmonhoc(jtfMonhoc.getText()));
					
					baithiDAO.taoHoacChinhsuaBaithi(baithi);
					
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
