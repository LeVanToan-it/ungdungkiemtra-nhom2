package dao;

import java.util.List;

import javax.swing.JFrame;

import entity.CauHoi;
import entity.MonHoc;

public interface MonHocDAO {
	List<String> layTatcaTenmonhoc();
	MonHoc layMonhocTheoTenmonhoc(String tenmonhoc);
	List<CauHoi> layCauhoiTheoTenmonhoc(String tenmonhoc);
	List<MonHoc> layTatCaMonhoc();
	String layMamonhoc(String monhoc);
	MonHoc layMonhocTheoId(String id);
	boolean themHoacChinhsuaMonhoc(MonHoc monhoc);
	boolean xoaMonhocTheoId(String id);
	
	//Frame
	JFrame moGiaodienMonhoc();
}
