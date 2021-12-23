package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.BaiThi;
import entity.MonHoc;
import entity.NguoiDung;
import uiFrame.KQBaithiFrm;
import uiFrame.LambaiFrm;
import uiFrame.NguoidungFrm;

public class TTBaithiController {
	private JButton btnXemKQ;
	private JButton btnLambai;
	private JTextField jtfTenmonhoc;
	private JTextField jtfTenbaithi;
	private JTextArea jtaMota;
	
	public TTBaithiController(JButton btnXemKQ, JButton btnLambai, JTextField jtfTenmonhoc, JTextField jtfTenbaithi, JTextArea jtaMota) {
		super();
		this.btnXemKQ = btnXemKQ;
		this.btnLambai = btnLambai;
		this.jtfTenbaithi = jtfTenbaithi;
		this.jtfTenmonhoc = jtfTenmonhoc;
		this.jtaMota = jtaMota;
	}
	
	public void setView(BaiThi baithi) {
		jtfTenmonhoc.setText(baithi.getMonhoc().getTenMonhoc());
		jtfTenbaithi.setText(baithi.getTenBaithi());
		jtaMota.setText(baithi.getMota());
		
	}
	
	public void setEvent() {
		btnXemKQ.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				BaiThi baithi = new BaiThi();
				baithi.setTenBaithi(jtfTenbaithi.getText());
				baithi.setMonhoc(new MonHoc(jtfTenmonhoc.getText()));
				baithi.setMota(jtaMota.getText());
				
				KQBaithiFrm frame = new KQBaithiFrm(baithi);
				frame.setTitle("Kết quả bài thi");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
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
				btnXemKQ.setBackground(new Color(0,200,83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnXemKQ.setBackground(new Color(100,221,23));
			}
			
		});
		
		btnLambai.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				BaiThi baithi = new BaiThi();
				baithi.setTenBaithi(jtfTenbaithi.getText());
				baithi.setMonhoc(new MonHoc(jtfTenmonhoc.getText()));
				baithi.setMota(jtaMota.getText());
				
				LambaiFrm frame = new LambaiFrm(baithi);
				frame.setTitle("Kết quả bài thi");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
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
				btnLambai.setBackground(new Color(0,200,83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLambai.setBackground(new Color(100,221,23));
			}
			
		});
	}
	
}
