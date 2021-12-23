package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.CauHoiDAO;
import entity.BaiThi;
import entity.CauHoi;
import entity.NguoiDung;
import util.HibernateUtil;

public class CauHoiImpl implements CauHoiDAO {

	private OgmSessionFactory sessionFactory;
	
	public CauHoiImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	@Override
	public CauHoi layCauhoiTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		CauHoi cauHoi = null;
		try {
			cauHoi =  session.find(CauHoi.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}	
		return cauHoi;
	}

	@Override
	public boolean capnhatCauhoi(CauHoi ch) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.t_cauhoi.updateOne({_id:'"+ ch.getId() +"'})";
			int rs = session.createNativeQuery(query).executeUpdate();
			tr.commit();
			return rs > 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public List<CauHoi> layTatCaCauhoi() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<CauHoi> cauhois = null;
		try {
			String query = "db.t_cauhoi.find({})";
			cauhois = session.createNativeQuery(query, CauHoi.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return cauhois;
	}

	@Override
	public List<CauHoi> layDanhsachCauhoiDuocChon(List<CauHoi> cauhois) {
		
		return null;
	}

	@Override
	public boolean taoHoacChinhsuaCauhoi(CauHoi cauHoi) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.saveOrUpdate(cauHoi);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}	
	}

	@Override
	public boolean xoaCauhoi(List<CauHoi> cauhois) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();		
		try {
			for(CauHoi cauHoi : cauhois) {
				session.delete(cauHoi);
			}			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}		
	}
	
	@Override
	public List<String> layDanhsachCautraloi(String tencauhoi) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		CauHoi cauhoi = null;
		try {
			String query = "db.t_cauhoi.find({'tencauhoi':'"+ tencauhoi +"'})";
			cauhoi = session.createNativeQuery(query, CauHoi.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return cauhoi.getTralois();
	}

	
	@Override
	public JFrame moGiaodienThemCauhoi() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean xoaCauhoiTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.t_cauhoi.deleteOne({_id:'"+ id +"'})";
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
	public CauHoi layCauhoiTheoTencauhoi(String tencauhoi) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		CauHoi cauhoi = null;
		try {
			String query = "db.t_cauhoi.find({'tencauhoi':'"+ tencauhoi +"'})";
			cauhoi = session.createNativeQuery(query, CauHoi.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return cauhoi;
	}
	
	//db.t_cauhoi.find({tenmonhoc:'MH005'})
	@Override
	public List<CauHoi> layDanhsachCauhoiTheoMamonhoc(String mamonhoc) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<CauHoi> cauhois = null;
		try {
			String query = "db.t_cauhoi.find({tenmonhoc:'"+ mamonhoc +"'})";
			cauhois = session.createNativeQuery(query, CauHoi.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return cauhois;
	}
	

}
