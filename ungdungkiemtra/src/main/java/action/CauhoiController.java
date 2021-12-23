package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.CauHoiDAO;
import dao.MonHocDAO;
import dao.impl.CauHoiImpl;
import dao.impl.MonHocImpl;
import entity.CauHoi;
import entity.MonHoc;

public class CauhoiController {
	private JButton btnSubmit;
	private JTextField jtfMacauhoi;
	private JTextArea jtaTencauhoi;
	private JRadioButton jrdCau1;
	private JRadioButton jrdCau2;
	private JRadioButton jrdCau3;
	private JRadioButton jrdCau4;
	private JTextArea jtaCau1;
	private JTextArea jtaCau2;
	private JTextArea jtaCau3;
	private JTextArea jtaCau4;
	private JTextField jtfMonhoc;
	
	private CauHoi cauhoi = null;
	private CauHoiDAO cauhoiDAO = null;
	private MonHocDAO monhocDAO = null;
	private Map<JRadioButton, String> map = new HashMap<JRadioButton, String>();
	public CauhoiController(JButton btnSubmit, JTextField jtfMacauhoi, JTextArea jtaTencauhoi,JRadioButton jrdCau1,JRadioButton jrdCau2,JRadioButton jrdCau3,JRadioButton jrdCau4, 
			JTextArea jtaCau1,JTextArea jtaCau2,JTextArea jtaCau3,JTextArea jtaCau4,Map<JRadioButton, String> map, JTextField jtfMonhoc) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfMacauhoi = jtfMacauhoi;
		this.jtaTencauhoi = jtaTencauhoi;
		this.jrdCau1 = jrdCau1;
		this.jrdCau2 = jrdCau2;
		this.jrdCau3 = jrdCau3;
		this.jrdCau4 = jrdCau4;
		this.jtaCau1 = jtaCau1;
		this.jtaCau2 = jtaCau2;
		this.jtaCau3 = jtaCau3;
		this.jtaCau4 = jtaCau4;
		
		this.map = map;
		this.jtfMonhoc = jtfMonhoc;
		this.cauhoiDAO = new CauHoiImpl();
		this.monhocDAO = new MonHocImpl();
	}
	
	public void setView(CauHoi cauhoi) {
		this.cauhoi = cauhoi;
		
		try {
			jtfMacauhoi.setText(cauhoi.getId());
			jtaTencauhoi.setText(cauhoi.getTenCauhoi());
			String ten = cauhoi.getTenCauhoi();
			if(ten != null) {
				jtaTencauhoi.setEditable(false);
				jtfMacauhoi.setEditable(false);
			}else {
				jtaTencauhoi.setEditable(true);
				jtfMacauhoi.setEditable(true);
			}
			List<String> tralois = cauhoiDAO.layDanhsachCautraloi(jtaTencauhoi.getText());
			String cau1 = tralois.get(0);
			String cau2 = tralois.get(1);
			String cau3 = tralois.get(2);
			String cau4 = tralois.get(3);
			
			jtaCau1.setText(cau1);
			jtaCau2.setText(cau2);
			jtaCau3.setText(cau3);
			jtaCau4.setText(cau4);
			
			map.put(jrdCau1, cau1);
			map.put(jrdCau2, cau2);
			map.put(jrdCau3, cau3);
			map.put(jrdCau4, cau4);
			
			String tl = cauhoi.getKq();
			if(map.get(jrdCau1).equalsIgnoreCase(tl)) {
				jrdCau1.setSelected(true);
			}else if(map.get(jrdCau2).equalsIgnoreCase(tl)) {
				jrdCau2.setSelected(true);
			}else if(map.get(jrdCau3).equalsIgnoreCase(tl)) {
				jrdCau3.setSelected(true);
			}else if(map.get(jrdCau4).equalsIgnoreCase(tl)) {
				jrdCau4.setSelected(true);
			}
			
			jtfMonhoc.setText(cauhoi.getMonhoc().getTenMonhoc());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfMacauhoi.getText().length() == 0 || jtaTencauhoi.getText().length() == 0 || jtaCau1.getText().length() == 0 || jtaCau2.getText().length() == 0
						|| jtaCau3.getText().length() == 0 || jtaCau4.getText().length() == 0) {
					//jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
					btnSubmit.setEnabled(false);
				}else {
					try {
						cauhoi.setId(jtfMacauhoi.getText());
						cauhoi.setTenCauhoi(jtaTencauhoi.getText());
						List<String> tralois = Arrays.asList(jtaCau1.getText(),jtaCau2.getText(),jtaCau3.getText(),jtaCau4.getText());
						cauhoi.setTralois(tralois);
						
						if(jrdCau1.isSelected() == true) {
							cauhoi.setKq(map.get(jrdCau1));
						}else if(jrdCau2.isSelected() == true) {
							cauhoi.setKq(map.get(jrdCau2));
						}else if(jrdCau3.isSelected() == true) {
							cauhoi.setKq(map.get(jrdCau3));
						}else if(jrdCau4.isSelected() == true) {
							cauhoi.setKq(map.get(jrdCau4));
						}
						
						cauhoi.setMonhoc(monhocDAO.layMonhocTheoTenmonhoc(jtfMonhoc.getText()));
						
						cauhoiDAO.taoHoacChinhsuaCauhoi(cauhoi);
					
					} catch (NullPointerException e2) {
						e2.printStackTrace();
					}
					
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
