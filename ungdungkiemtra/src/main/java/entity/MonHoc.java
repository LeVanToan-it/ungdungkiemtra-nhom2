package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name="t_monhoc", indexes = {
		@Index(columnList = "tenmonhoc", name = "monhoc1")
})
@IndexOptions(@IndexOption(forIndex = "monhoc1", options = "{text:true}"))
public class MonHoc {
	@Id
	private String id;
	@Column(name = "tenmonhoc")
	private String tenMonhoc;
	
	@Column(name = "hocky")
	private int hocKy;
	@Column(name = "sotinchi")
	private int soTC;
	
	@Column(name = "ngaytao")
	private Date ngayTao;
	@Column(name = "ngaysua")
	private Date ngaySua;
	
	@OneToMany(mappedBy = "monhoc")
	private List<CauHoi> cauhois;
	
	@OneToMany(mappedBy = "monhoc")
	private List<BaiThi> baithis;
	
	public MonHoc() {
		super();
	}

	public MonHoc(String id, String tenMonhoc, int hocKy, int soTC, Date ngayTao) {
		super();
		this.id = id;
		this.tenMonhoc = tenMonhoc;
		this.hocKy = hocKy;
		this.soTC = soTC;
		this.ngayTao = ngayTao;
	}
	
	public MonHoc(String tenmonhoc) {
		this.tenMonhoc = tenmonhoc;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	

	public void setBaithis(List<BaiThi> baithis) {
		this.baithis = baithis;
	}

	public String getTenMonhoc() {
		return tenMonhoc;
	}

	public void setTenMonhoc(String tenMonhoc) {
		this.tenMonhoc = tenMonhoc;
	}

	public int getHocKy() {
		return hocKy;
	}

	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		this.soTC = soTC;
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

	public List<CauHoi> getCauhois() {
		return cauhois;
	}

	public void setCauhois(List<CauHoi> cauhois) {
		this.cauhois = cauhois;
	}

	public String getId() {
		return id;
	}

	public List<BaiThi> getBaithis() {
		return baithis;
	}

	@Override
	public String toString() {
		return "MonHoc [id=" + id + ", tenMonhoc=" + tenMonhoc + ", hocKy=" + hocKy + ", soTC=" + soTC + ", ngayTao="
				+ ngayTao;
	}
	
}
