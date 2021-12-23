package dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.BaiThiDAO;
import dao.NguoiDungDAO;
import entity.BaiThi;
import entity.BangDiem;
import entity.CauHoi;
import entity.NguoiDung;
import util.HibernateUtil;

public class BaiThiImpl implements BaiThiDAO {

	private OgmSessionFactory sessionFactory;
	private NguoiDungDAO nguoidungDAO;
	
	public BaiThiImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	//db.t_baithi.find()
	@Override
	public List<BaiThi> layTatCaBaithi() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<BaiThi> baithis = null;
		try {
			String query = "db.t_baithi.find({})";
			baithis = session.createNativeQuery(query, BaiThi.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return baithis;
	}

	@Override
	public boolean taoHoacChinhsuaBaithi(BaiThi baithi) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.saveOrUpdate(baithi);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}	
	}

	@Override
	public BaiThi layBaithiTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		BaiThi baithi = null;
		try {
			baithi = session.find(BaiThi.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return baithi;
	}

	@Override
	public boolean capnhatBaithiTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			String query = "db.t_baithi.updateOne({_id:'"+ id +"'})";
			int rs = session.createNativeQuery(query).executeUpdate();
			tr.commit();
			return rs > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean xoaBaiThiTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.t_baithi.deleteOne({_id:'"+ id +"'})";
			int rs = session.createNativeQuery(query).executeUpdate();
			tr.commit();
			return rs > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public double xemKetquaBaithi(NguoiDung nguoidung ,String baithiId) throws RemoteException {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		NguoiDung nd = nguoidungDAO.layNguoidungTheoId(nguoidung.getId());
		if(nd.getVaitro().equals("sinhvien")){
			List<BangDiem> bangdiems = null;
		}
		try {
			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return 0;
	}

	@Override
	public List<BaiThi> layDanhsachBaithiDuocChon(List<BaiThi> baithis) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			
			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	//===================================================
	
	@Override
	public JFrame moGiaodienBaithi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame moGiaodienCapnhatBaithi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame moGiaodienTaoBaithiMoi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame moGiaodienThongtinBaithi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame moGiaodienThamgiaBaithi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CauHoi> layDanhsachCauhoiTuMabaithi(String baithiId) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		BaiThi baithi = null;
		try {
			baithi = session.find(BaiThi.class, baithiId);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return baithi.getCauhois();
	}

}
