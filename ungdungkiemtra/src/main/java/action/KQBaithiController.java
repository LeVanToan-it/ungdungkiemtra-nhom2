package action;

import javax.swing.JButton;
import javax.swing.JTextField;

import entity.BaiThi;
import entity.MonHoc;

public class KQBaithiController {
	private JTextField jtfTenmonhoc;
	private JTextField jtfTenbaithi;
	private JTextField jtfHocky;
	private JTextField jtfDiem;
	
	public KQBaithiController(JTextField jtfTenmonhoc, JTextField jtfTenbaithi, JTextField jtfHocky, JTextField jtfDiem) {
		super();
		this.jtfTenmonhoc = jtfTenmonhoc;
		this.jtfTenbaithi = jtfTenbaithi;
		this.jtfHocky = jtfHocky;
		this.jtfDiem = jtfDiem;
	}
	
	public void setView(BaiThi baithi) {
		jtfTenmonhoc.setText(baithi.getMonhoc().getTenMonhoc());
		jtfTenbaithi.setText(baithi.getTenBaithi());
		jtfHocky.setText(String.valueOf(baithi.getMonhoc().getHocKy()));
		//jtfSoTC.setText(String.valueOf(monhoc.getSoTC()));
	}
}
