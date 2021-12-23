package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.NguoiDung;

public class DanhMucBean {
	private String kind;
	private JPanel jpn;
	private JLabel jlb;
	private NguoiDung nguoidung;
	
	public DanhMucBean() {
		// TODO Auto-generated constructor stub
	}

	public DanhMucBean(String kind, JPanel jpn, JLabel jlb) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
	}
	
	public DanhMucBean(String kind, JPanel jpn, JLabel jlb, NguoiDung nguoidung) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
		this.nguoidung = nguoidung;
	}
	
	public DanhMucBean(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public JPanel getJpn() {
		return jpn;
	}

	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}

	public JLabel getJlb() {
		return jlb;
	}

	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}
	
	
	
}
