package entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.JRadioButton;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name="t_cauhoi", indexes = {
		@Index(columnList = "tencauhoi", name = "cauhoi1")
})
@IndexOptions(@IndexOption(forIndex = "cauhoi1", options = "{text:true}"))
public class CauHoi {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "cauhoi_id")
	private String id;
	@Column(name = "tencauhoi")
	private String tenCauhoi;	
	@Column(name = "ngaytao")
	private Date ngayTao;
	@Column(name = "ngaysua")
	private Date ngaySua;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> tralois;
	
	@Column(name = "ketqua")
	private String kq;
	
	@ManyToOne
	@JoinColumn(name = "tenbaithi")
	private BaiThi baithi;
	
	@ManyToOne
	@JoinColumn(name = "tenmonhoc")
	private MonHoc monhoc;

	public CauHoi() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public CauHoi(String id, String tenCauhoi, List<String> tralois, Date ngayTao, MonHoc mh) {
		super();
		this.id = id;
		this.tenCauhoi = tenCauhoi;
		this.tralois = tralois;
		this.ngayTao = ngayTao;
		this.monhoc = mh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenCauhoi() {
		return tenCauhoi;
	}

	public void setTenCauhoi(String tenCauhoi) {
		this.tenCauhoi = tenCauhoi;
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

	public MonHoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(MonHoc monhoc) {
		this.monhoc = monhoc;
	}
	

	public List<String> getTralois() {
		return tralois;
	}

	public void setTralois(List<String> tralois) {
		this.tralois = tralois;
	}	
	
	public String getKq() {
		return kq;
	}



	public void setKq(String kq) {
		this.kq = kq;
	}



	@Override
	public String toString() {
		return "CauHoi [id=" + id + ", tenCauhoi=" + tenCauhoi + ", ngayTao=" + ngayTao + ", tralois=" + tralois;
	}

	
	
	
	
	
	
}
