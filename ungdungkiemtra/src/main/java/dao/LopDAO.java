package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Lop;

public interface LopDAO {
	Lop timLopTheoTenlop(String tenlop);
}
