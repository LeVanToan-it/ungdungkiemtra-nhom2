package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name="t_nguoidung", indexes = {
		@Index(columnList = "tennguoidung", name = "nguoidung1")
})
@IndexOptions(@IndexOption(forIndex = "nguoidung1", options = "{text:true}"))

public class NguoiDung {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "tennguoidung")
	private String tenNguoidung;
	@Column(name = "gioitinh")
	private String gioiTinh;
	@Column(name = "sodienthoai")
	private String soDienthoai;
	@Column(name = "namsinh")
	private int namSinh;
	@Column(name = "diachi")
	private String diaChi;
	@Column(name = "matkhau")
	private String matKhau;
	
	
	@Column(name = "ngaytao")
	private Date ngayTao;
	@Column(name = "ngaysua")
	private Date ngaySua;
	
	
	@ManyToOne
	@JoinColumn(name = "tenlop")
	private Lop lop;
	
	@ManyToOne
	@JoinColumn(name = "tenvaitro")
	private VaiTro vaitro;
	
	public NguoiDung() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenNguoidung() {
		return tenNguoidung;
	}

	public void setTenNguoidung(String tenNguoidung) {
		this.tenNguoidung = tenNguoidung;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienthoai() {
		return soDienthoai;
	}

	public void setSoDienthoai(String soDienthoai) {
		this.soDienthoai = soDienthoai;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public VaiTro getVaitro() {
		return vaitro;
	}

	public void setVaitro(VaiTro vaitro) {
		this.vaitro = vaitro;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NguoiDung(String id, String tenNguoidung, String gioiTinh, String soDienthoai, int namSinh,
			String diaChi, Lop lop, VaiTro vt) {
		super();
		this.id = id;
		this.tenNguoidung = tenNguoidung;
		this.gioiTinh = gioiTinh;
		this.soDienthoai = soDienthoai;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.lop = lop;
		this.vaitro = vt;
	}
	
	public NguoiDung(String id) {
		this.id = id;
	}
	
	public NguoiDung(String id, String tenNguoidung) {
		this.id = id;
		this.tenNguoidung = tenNguoidung;
	}

	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", tenNguoidung=" + tenNguoidung + ", gioiTinh=" + gioiTinh + ", soDienthoai="
				+ soDienthoai + ", namSinh=" + namSinh + ", diaChi=" + diaChi + ", lop=" + lop + ", vaitro=" + vaitro
				+ "]";
	}

	
}


