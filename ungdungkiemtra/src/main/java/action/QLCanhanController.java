package action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.LopDAO;
import dao.NguoiDungDAO;
import dao.VaiTroDAO;
import dao.impl.LopImpl;
import dao.impl.NguoidungImpl;
import dao.impl.VaiTroImpl;
import entity.BaiThi;
import entity.NguoiDung;

public class QLCanhanController {
	private JButton btnSubmit;
	private JTextField jtfManguoidung;
	private JTextField jtfTennguoidung;
	private JRadioButton jrdNam;
	private JRadioButton jrdNu;
	private JTextField jtfLop;
	private JTextField jtfVaitro;
	private JTextField jtfSodienthoai;
	private JTextField jtfNamsinh;
	private JTextArea jtaDiachi;
	private JLabel jlbMessage;
	
	private NguoiDung nguoidung = null;
	private LopDAO lopDAO = null;
	private VaiTroDAO vaitroDAO = null;
	private NguoiDungDAO nguoidungDAO = null;
	
	public QLCanhanController(JButton btnSubmit, JTextField jtfManguoidung, JTextField jtfTennguoidung, JRadioButton jrdNam, JLabel jlbMessage,
			JRadioButton jrdNu, JTextField jtfLop, JTextField jtfVaitro, JTextField jtfSodienthoai, JTextField jtfNamsinh, JTextArea jtaDiachi) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfManguoidung = jtfManguoidung;
		this.jtfTennguoidung = jtfTennguoidung;
		this.jrdNam = jrdNam;
		this.jrdNu = jrdNu;
		this.jtfLop = jtfLop;
		this.jtfVaitro = jtfVaitro;
		this.jtfSodienthoai = jtfSodienthoai;
		this.jtfNamsinh = jtfNamsinh;
		this.jtaDiachi = jtaDiachi;
		this.jlbMessage = jlbMessage;
		
		this.lopDAO = new LopImpl();
		this.vaitroDAO = new VaiTroImpl();
		this.nguoidungDAO = new NguoidungImpl();
	}
	
	public void setView(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
		
		jtfManguoidung.setText(nguoidung.getId());
		jtfTennguoidung.setText(nguoidung.getTenNguoidung());
		if(nguoidung.getGioiTinh().equalsIgnoreCase("Nam")) {
			jrdNam.setSelected(true);
			jrdNu.setSelected(false);
		}else {
			jrdNam.setSelected(false);
			jrdNu.setSelected(true);
		}
		jtfLop.setText(nguoidung.getLop().getTenLop());
		jtfVaitro.setText(nguoidung.getVaitro().getTenVaitro());
		jtfSodienthoai.setText(nguoidung.getSoDienthoai());
		jtfNamsinh.setText(String.valueOf(nguoidung.getNamSinh()));
		jtaDiachi.setText(nguoidung.getDiaChi());
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfManguoidung.getText().length() == 0 || jtfTennguoidung.getText().length() == 0 || jtfNamsinh.getText().length() == 0
						|| jtfSodienthoai.getText().length() == 0 || jtaDiachi.getText().length() == 0
						|| jtfLop.getText().length() == 0 || jtfVaitro.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
					btnSubmit.setEnabled(false);
				}else {
					nguoidung.setId(jtfManguoidung.getText());
					nguoidung.setTenNguoidung(jtfTennguoidung.getText());
					nguoidung.setGioiTinh(jrdNam.isSelected()? "Nam" : "Nữ");
					nguoidung.setSoDienthoai(jtfSodienthoai.getText());
					nguoidung.setNamSinh(Integer.parseInt(jtfNamsinh.getText()));
					nguoidung.setDiaChi(jtaDiachi.getText());
					nguoidung.setLop(lopDAO.timLopTheoTenlop(jtfLop.getText()));
			
					nguoidung.setVaitro(vaitroDAO.layVaitroTheoTenvaitro(jtfVaitro.getText()));				
				
					nguoidungDAO.taoHoacCapnhatNguoidung(nguoidung);
					
					jlbMessage.setText("Cập nhật dữ liệu thành công");
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
