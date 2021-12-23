package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name="t_lop", indexes = {
		@Index(columnList = "tenlop", name = "lop1")
})
@IndexOptions(@IndexOption(forIndex = "lop1", options = "{text:true}"))
public class Lop {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "tenlop")
	private String tenLop;
	@Column(name = "siso")
	private int siSo;
	
	@Column(name = "ngaytao")
	private Date ngayTao;
	
//	@OneToMany(mappedBy = "tenLop")
//	private List<NguoiDung> nguoidungs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSiSo() {
		return siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	/*
	 * public List<NguoiDung> getNguoidungs() { return nguoidungs; }
	 * 
	 * public void setNguoidungs(List<NguoiDung> nguoidungs) { this.nguoidungs =
	 * nguoidungs; }
	 */
	
	public Lop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lop(String id, String tenLop, int siSo, Date ngayTao) {
		super();
		this.id = id;
		this.tenLop = tenLop;
		this.siSo = siSo;
		this.ngayTao = ngayTao;
	}

	@Override
	public String toString() {
		return "Lop [id=" + id + ", tenLop=" + tenLop + ", siSo=" + siSo + ", ngayTao=" + ngayTao + ", nguoidungs=";
				/*+ nguoidungs + "]";*/
	}

	
}
