package dao;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import entity.CauHoi;

public interface CauHoiDAO {
	CauHoi layCauhoiTheoId(String id);
	CauHoi layCauhoiTheoTencauhoi(String tencauhoi);
	boolean capnhatCauhoi(CauHoi ch);
	List<CauHoi> layTatCaCauhoi();
	List<CauHoi> layDanhsachCauhoiDuocChon(List<CauHoi> cauhois);
	boolean taoHoacChinhsuaCauhoi(CauHoi cauhoi);
	boolean xoaCauhoi(List<CauHoi> cauhois);
	boolean xoaCauhoiTheoId(String id);
	List<String> layDanhsachCautraloi(String tencauhoi);
	List<CauHoi> layDanhsachCauhoiTheoMamonhoc(String mamonhoc);
	
	//Frame
	JFrame moGiaodienThemCauhoi();
	
}
