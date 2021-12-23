package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_vaitro")
public class VaiTro {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "vaitro_id")
	private String id;
	@Column(name = "tenvaitro")
	private String tenVaitro;
	
	@OneToMany(mappedBy = "vaitro")
	private List<NguoiDung> nguoidungs;

	public VaiTro(String id, String tenVaitro) {
		super();
		this.id = id;
		this.tenVaitro = tenVaitro;
	}

	public VaiTro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenVaitro() {
		return tenVaitro;
	}

	public void setTenVaitro(String tenVaitro) {
		this.tenVaitro = tenVaitro;
	}

	public List<NguoiDung> getNguoidungs() {
		return nguoidungs;
	}

	public void setNguoidungs(List<NguoiDung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}

	@Override
	public String toString() {
		return "VaiTro [id=" + id + ", tenVaitro=" + tenVaitro;
	}
	
	
	
}
