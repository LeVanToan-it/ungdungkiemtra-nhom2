package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.bson.types.ObjectId;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.NguoiDungDAO;
import entity.BaiThi;
import entity.NguoiDung;
import util.HibernateUtil;

public class NguoidungImpl implements NguoiDungDAO {
	private OgmSessionFactory sessionFactory;
	
	public NguoidungImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	@Override
	public void taoHoacCapnhatNguoidung(NguoiDung nguoidung) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			session.saveOrUpdate(nguoidung);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}	
	}

	@Override
	public NguoiDung layNguoidungTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		NguoiDung nguoidung = new NguoiDung();
		try {
			nguoidung = session.find(NguoiDung.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return nguoidung;
	}
	
	@Override
	public NguoiDung layNguoidungTheoTen(String tennguoidung) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		NguoiDung nguoidung = null;
		try {
			String query = "db.t_nguoidung.find({'tennguoidung':'"+ tennguoidung +"'})";
			nguoidung = session.createNativeQuery(query, NguoiDung.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return nguoidung;
	}

	@Override
	public List<NguoiDung> layTatCaNguoidung() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<NguoiDung> nguoidungs = null;
		try {
			String query = "db.t_nguoidung.find({})";
			nguoidungs = session.createNativeQuery(query, NguoiDung.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return nguoidungs;
	}

	@Override
	public boolean xoaNguoidungTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.t_nguoidung.deleteOne({_id:'"+ id +"'})";
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
	public NguoiDung login(String manguoidung, String matkhau) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		NguoiDung nguoidung = null;
		try {
			String query = "db.t_nguoidung.find({$and:[{'_id':'"+ manguoidung +"'},{'matkhau':'"+ matkhau +"'}]})";
			nguoidung = session.createNativeQuery(query, NguoiDung.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return nguoidung;
	}

	
}
