package action;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.BaiThi;

public class LambaiController {
	private JButton btnNopbai;
	private JTextField jtfTenmonhoc;
	private JTextField jtfTenbaithi;
	private JTextField jtfHocky;
	private JTextField jtfManguoidung;
	private JTextField jtfTennguoidung;
	
	private JTextArea jtaCau1, jtaCau2, jtaCau3, jtaCau4, jtaCau5, jtaCau6, jtaCau7, jtaCau8, jtaCau9, jtaCau10;
	
	private JTextArea jtaCauA1, jtaCauA2, jtaCauA3, jtaCauA4, jtaCauA5, jtaCauA6, jtaCauA7, jtaCauA8, jtaCauA9, jtaCauA10;
	private JTextArea jtaCauB1, jtaCauB2, jtaCauB3, jtaCauB4, jtaCauB5, jtaCauB6, jtaCauB7, jtaCauB8, jtaCauB9, jtaCauB10;
	private JTextArea jtaCauC1, jtaCauC2, jtaCauC3, jtaCauC4, jtaCauC5, jtaCauC6, jtaCauC7, jtaCauC8, jtaCauC9, jtaCauC10;
	private JTextArea jtaCauD1, jtaCauD2, jtaCauD3, jtaCauD4, jtaCauD5, jtaCauD6, jtaCauD7, jtaCauD8, jtaCauD9, jtaCauD10;
	
	private JRadioButton jrdCauA1, jrdCauA2, jrdCauA3, jrdCauA4, jrdCauA5, jrdCauA6, jrdCauA7, jrdCauA8, jrdCauA9, jrdCauA10;
	private JRadioButton jrdCauB1, jrdCauB2, jrdCauB3, jrdCauB4, jrdCauB5, jrdCauB6, jrdCauB7, jrdCauB8, jrdCauB9, jrdCauB10;
	private JRadioButton jrdCauC1, jrdCauC2, jrdCauC3, jrdCauC4, jrdCauC5, jrdCauC6, jrdCauC7, jrdCauC8, jrdCauC9, jrdCauC10;
	private JRadioButton jrdCauD1, jrdCauD2, jrdCauD3, jrdCauD4, jrdCauD5, jrdCauD6, jrdCauD7, jrdCauD8, jrdCauD9, jrdCauD10;
	
	
	public LambaiController(JButton btnNopbai, JTextField jtfTenmonhoc, JTextField jtfTenbaithi, JTextField jtfHocky, JTextField jtfManguoidung, JTextField jtfTennguoidung) {
		super();
		this.btnNopbai = btnNopbai;
		this.jtfTenmonhoc = jtfTenmonhoc;
		this.jtfTenbaithi = jtfTenbaithi;
		this.jtfHocky = jtfHocky;
		this.jtfManguoidung = jtfManguoidung;
		this.jtfTennguoidung = jtfTennguoidung;
	}
	
	public void setView(BaiThi baithi) {
		jtfTenmonhoc.setText(baithi.getMonhoc().getTenMonhoc());
		jtfTenbaithi.setText(baithi.getTenBaithi());
		jtfHocky.setText(String.valueOf(baithi.getMonhoc().getHocKy()));
		//jtfSoTC.setText(String.valueOf(monhoc.getSoTC()));
	}
}
