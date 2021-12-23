package util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

import entity.BaiThi;
import entity.BangDiem;
import entity.CauHoi;
import entity.Lop;
import entity.MonHoc;
import entity.NguoiDung;
import entity.VaiTro;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private OgmSessionFactory sessionFactory;
	//Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	public HibernateUtil() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
											.applySetting(OgmProperties.ENABLED, true)
											.configure()
											.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(BaiThi.class)
				.addAnnotatedClass(CauHoi.class)
				.addAnnotatedClass(BangDiem.class)
				.addAnnotatedClass(Lop.class)
				.addAnnotatedClass(MonHoc.class)
				.addAnnotatedClass(NguoiDung.class)
				.addAnnotatedClass(VaiTro.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory  = metadata
				.getSessionFactoryBuilder()
				.unwrap(OgmSessionFactoryBuilder.class)
				.build();
	
	}
	
	public synchronized static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	
	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
