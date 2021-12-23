package app;

import java.rmi.registry.LocateRegistry;

import dao.LopDAO;
import dao.NguoiDungDAO;
import dao.impl.LopImpl;
import dao.impl.NguoidungImpl;

public class ServerApp {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			LocateRegistry.createRegistry(1099);
			NguoiDungDAO nguoidungDAO = new NguoidungImpl(); //Remote Object
			LopDAO lopDAO = new LopImpl();
//			NewsFacade newsFacade = new NewsImpl();
//			JNDI
			//Naming.bind("rmi://192.168.1.73:1099/nguoidungDAO", nguoidungDAO);
//			Naming.bind("rmi://192.168.1.73:1099/newsFacade", newsFacade);
			
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
