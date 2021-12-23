package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.BaiThi;

public class BaithiController {
	private JButton btnXemKQ, btnLambai;
	private JTextField jtfTenbaithi, jtfTenmonhoc;
	private JTextArea jtaMota;
	
	public BaithiController(JButton btnXemKQ, JButton btnLambai, JTextField jtfTenmonhoc, JTextField jtfTenbaithi, JTextArea jtaMota) {
		super();
		this.btnXemKQ = btnXemKQ;
		this.btnLambai = btnLambai;
		this.jtfTenmonhoc = jtfTenmonhoc;
		this.jtfTenbaithi = jtfTenbaithi;
		this.jtaMota = jtaMota;
	}



	public void setView(BaiThi baithi) {
		jtfTenbaithi.setText(baithi.getTenBaithi());
		jtfTenmonhoc.setText(baithi.getMonhoc().getTenMonhoc());
		jtaMota.setText(baithi.getMota());
	}
	
	public void setEvent() {
		btnXemKQ.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
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
				// TODO Auto-generated method stub
				
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
				btnLambai.setBackground(new Color(204,0,0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLambai.setBackground(new Color(204,0,0));
			}
			
		});
	}
}
