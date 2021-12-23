package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.LopDAO;
import entity.Lop;
import util.HibernateUtil;

public class LopImpl implements LopDAO {
private OgmSessionFactory sessionFactory;
	
	public LopImpl(){
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public Lop timLopTheoTenlop(String tenlop) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Lop lop = new Lop();
		
		try {
			String query = "db.t_lop.find({'tenlop':'"+ tenlop +"'})";
			lop = session.createNativeQuery(query, Lop.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return lop;
	}

}
