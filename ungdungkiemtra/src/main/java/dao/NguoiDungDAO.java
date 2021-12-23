package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;

import entity.NguoiDung;

public interface NguoiDungDAO{
	void taoHoacCapnhatNguoidung(NguoiDung nguoidung);
	List<NguoiDung> layTatCaNguoidung();
	NguoiDung layNguoidungTheoId(String id);
	NguoiDung layNguoidungTheoTen(String tennguoidung);
	boolean xoaNguoidungTheoId(String id);
	NguoiDung login(String manguoidung, String matkhau);

}
