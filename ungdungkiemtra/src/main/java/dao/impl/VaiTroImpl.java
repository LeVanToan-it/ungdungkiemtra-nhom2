package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.VaiTroDAO;
import entity.Lop;
import entity.VaiTro;
import util.HibernateUtil;

public class VaiTroImpl implements VaiTroDAO {
	private OgmSessionFactory sessionFactory;
	
	public VaiTroImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	@Override
	public List<VaiTro> layTatcaVaitro() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<VaiTro> vaitros = new ArrayList<>();
		try {
			String query = "db.t_vaitro.find()";
			List<?> list = session.createNativeQuery(query).getResultList();
			
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				String vaitroId = (String) o[0];
				VaiTro vaitro = session.find(VaiTro.class, vaitroId);
				vaitros.add(vaitro);
			}
			tr.commit();
			return vaitros;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public VaiTro layVaitroTheoId(String id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		VaiTro vaitro = null;
		try {
			vaitro = session.find(VaiTro.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return vaitro;
	}

	@Override
	public VaiTro layVaitroTheoTenvaitro(String tenvaitro) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		VaiTro vaitro = new VaiTro();
		try {
			String query = "db.t_vaitro.find({'tenvaitro':'"+ tenvaitro +"'})";
			vaitro = session.createNativeQuery(query, VaiTro.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return vaitro;
	}

	

}
