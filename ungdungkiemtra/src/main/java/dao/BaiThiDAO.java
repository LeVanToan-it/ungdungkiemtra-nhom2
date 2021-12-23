package dao;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;

import entity.BaiThi;
import entity.CauHoi;
import entity.NguoiDung;

public interface BaiThiDAO {
	List<BaiThi> layTatCaBaithi();
	boolean taoHoacChinhsuaBaithi(BaiThi baithi);
	BaiThi layBaithiTheoId(String id);
	boolean capnhatBaithiTheoId(String id);
	boolean xoaBaiThiTheoId(String id);
	double xemKetquaBaithi(NguoiDung nguoidung ,String baithiId) throws RemoteException;
	List<BaiThi> layDanhsachBaithiDuocChon(List<BaiThi> baithis);
	List<CauHoi> layDanhsachCauhoiTuMabaithi(String baithiId);
	
	
	//Frm
	JFrame moGiaodienBaithi();
	JFrame moGiaodienCapnhatBaithi();
	JFrame moGiaodienTaoBaithiMoi();
	JFrame moGiaodienThongtinBaithi();
	JFrame moGiaodienThamgiaBaithi();
}
