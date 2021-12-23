package action;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import dao.NguoiDungDAO;
import dao.impl.NguoidungImpl;
import entity.NguoiDung;
import uiFrame.MainFrm;
import uiFrame.MainFrmChoGiaoVien;
import uiFrame.MainFrmChoQuanLy;
import uiFrame.QLCanhanPanel;

import java.awt.Color;
import java.awt.Dialog;

public class DangnhapController {
	private Dialog dialog;
    private JButton btnDangnhap;
    private JTextField jtfManguoidung;
    private JTextField jtfMatkhau;
    private JLabel jlbMessage;
    
    private NguoiDungDAO nguoidungDAO = null;
    
    public DangnhapController(Dialog dialog, JButton btnDangnhap, JTextField jtfManguoidung, JTextField jtfMatkhau, JLabel jlbMessage) throws RemoteException {
    	this.dialog = dialog;
    	this.btnDangnhap = btnDangnhap;
    	this.jtfManguoidung = jtfManguoidung;
    	this.jtfMatkhau = jtfMatkhau;
    	this.jlbMessage = jlbMessage;
    	
    	this.nguoidungDAO = new NguoidungImpl();
    }
    
    public void setEvent() {
    	btnDangnhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(jtfManguoidung.getText().length() == 0 || jtfMatkhau.getText().length() == 0) {
						jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
					}else {
						NguoiDung nguoidung = nguoidungDAO.login(jtfManguoidung.getText(), jtfMatkhau.getText());
						if(nguoidung == null) {
							jlbMessage.setText("Tên đăng nhập và mật khẩu không đúng1");
						}else {
								dialog.dispose();
								if(nguoidung.getVaitro().getTenVaitro().equalsIgnoreCase("Quan Ly")) {
									MainFrmChoQuanLy frame = new MainFrmChoQuanLy(nguoidung);
									frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
									frame.setVisible(true);
								}else if(nguoidung.getVaitro().getTenVaitro().equalsIgnoreCase("Giao Vien")) {
									MainFrmChoGiaoVien frame = new MainFrmChoGiaoVien(nguoidung);
									frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
									frame.setVisible(true);
								}else {
									MainFrm frame = new MainFrm(nguoidung);
									frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
									frame.setVisible(true);
								}
					
						}
					}
				} catch (Exception e2) {
					jlbMessage.setText(e2.toString());
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
				 btnDangnhap.setBackground(new Color(0, 200, 83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDangnhap.setBackground(new Color(100, 221, 23));
			}
    		
    	});
    	
    }
}
