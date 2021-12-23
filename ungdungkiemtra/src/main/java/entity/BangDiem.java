package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "t_bangdiem")
public class BangDiem {
	@Column(name = "lanthi")
	private int lanThi;
	@Column(name = "diemthi")
	private float diemThi;
	
	@ManyToOne
	@JoinColumn(name = "nguoidung_id")
	private NguoiDung nguoidung;
	
	public BangDiem() {
		// TODO Auto-generated constructor stub
	}

	public int getLanThi() {
		return lanThi;
	}

	public void setLanThi(int lanThi) {
		this.lanThi = lanThi;
	}

	public float getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public BangDiem(int lanThi, float diemThi) {
		super();
		this.lanThi = lanThi;
		this.diemThi = diemThi;
	}

	@Override
	public String toString() {
		return "BangDiem [lanThi=" + lanThi + ", diemThi=" + diemThi + ", nguoidung=" + nguoidung.getId() + "]";
	}

	
}
