package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name="t_baithi", indexes = {
		@Index(columnList = "tenbaithi", name = "baithi1")
})
@IndexOptions(@IndexOption(forIndex = "baithi1", options = "{text:true}"))
public class BaiThi {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "baithi_id")
	private String id;
	@Column(name = "tenbaithi")
	private String tenBaithi;
	@Column
	private String mota;
	@Column(name = "ngaytao")
	private Date ngayTao;
	@Column(name = "ngaysua")
	private Date ngaySua;
		
	@ManyToOne
	@JoinColumn(name="tenmonhoc")
	private MonHoc monhoc;
	
	@OneToMany(mappedBy = "baithi", fetch = FetchType.EAGER)
	private List<CauHoi> cauhois;

	@Embedded
	private BangDiem bangdiem;
	
	public BaiThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTenBaithi() {
		return tenBaithi;
	}


	public void setTenBaithi(String tenBaithi) {
		this.tenBaithi = tenBaithi;
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


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}

	public List<CauHoi> getCauhois() {
		return cauhois;
	}


	public void setCauhois(List<CauHoi> cauhois) {
		this.cauhois = cauhois;
	}


	public BaiThi(String id, String tenBaithi, String mota, Date ngayTao, MonHoc monhoc) {
		super();
		this.id = id;
		this.tenBaithi = tenBaithi;
		this.mota = mota;
		this.ngayTao = ngayTao;
		this.monhoc = monhoc;
	}
	
	public BaiThi(String id, String tenBaithi, String mota, Date ngayTao, MonHoc monhoc, List<CauHoi> cauhois) {
		super();
		this.id = id;
		this.tenBaithi = tenBaithi;
		this.mota = mota;
		this.ngayTao = ngayTao;
		this.monhoc = monhoc;
		this.cauhois = cauhois;
	}


	@Override
	public String toString() {
		return "BaiThi [id=" + id + ", tenBaithi=" + tenBaithi + ", mota=" + mota + ", ngayTao=" + ngayTao
				+ ", ngaySua=" + ngaySua + ", monhoc=" + monhoc + "]";
	}	
}
