package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.MonHocDAO;
import entity.CauHoi;
import entity.MonHoc;
import entity.NguoiDung;
import util.HibernateUtil;

public class MonHocImpl implements MonHocDAO {

private OgmSessionFactory sessionFactory;
	
	public MonHocImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	@Override
	public MonHoc layMonhocTheoTenmonhoc(String tenmonhoc) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		MonHoc monhoc = null;
		try {
			String query = "db.t_monhoc.find({'tenmonhoc':'"+tenmonhoc+"'})";
			monhoc = session.createNativeQuery(query, MonHoc.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return monhoc;
	}
	
	@Override
	public List<CauHoi> layCauhoiTheoTenmonhoc(String tenmonhoc) {
		List<CauHoi> cauhois = new ArrayList<CauHoi>();
		
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			String query = "";
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<MonHoc> layTatCaMonhoc() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<MonHoc> monhocs = null;
		try {
			String query = "db.t_monhoc.find({})";
			monhocs = session.createNativeQuery(query, MonHoc.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return monhocs;
	}

	@Override
	public MonHoc layMonhocTheoId(String id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		MonHoc monhoc = null;
		try {
			monhoc = session.find(MonHoc.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return monhoc;
	}

	@Override
	public boolean themHoacChinhsuaMonhoc(MonHoc monhoc) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.saveOrUpdate(monhoc);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}	
	}

	@Override
	public boolean xoaMonhocTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.t_monhoc.deleteOne({_id:'"+ id +"'})";
			int rs = session.createNativeQuery(query).executeUpdate();
			tr.commit();
			return rs > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}
	
	// db.t_nguoidung.aggregate([{$match:{tennguoidung:'Le Van Toan'}},{$group:{_id:'$_id'}}])
		@Override
		public String layMamonhoc(String tenmonhoc) {
			OgmSession session = sessionFactory.getCurrentSession();
			Transaction tr = session.beginTransaction();
			String ma = null;
			try {
				String query = " db.t_monhoc.aggregate([{$match:{tenmonhoc:'"+ tenmonhoc +"'}},{$group:{_id:'$_id'}}])";
				ma = (String) session.createNativeQuery(query).getSingleResult();
				tr.commit();
				return ma;
			} catch (Exception e) {
				e.printStackTrace();
				tr.rollback();
			}
			return null;
		}

	@Override
	public JFrame moGiaodienMonhoc() {
		// TODO Auto-generated method stub
		return null;
	}

	//db.t_monhoc.aggregate([{$group:{_id:{tenMH:'$tenmonhoc'}}},{$replaceWith:'$_id'}])
	@Override
	public List<String> layTatcaTenmonhoc() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<String> monhocs = null;
		try {
			String query = "db.t_monhoc.aggregate([{$group:{_id:{tenMH:'$tenmonhoc'}}},{$replaceWith:'$_id'}])";
			List<?> list = session.createNativeQuery(query).getResultList();
			
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				String tenmonhoc = (String) o[0];
				monhocs.add(tenmonhoc);
			}
			tr.commit();
			return monhocs;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	


}
