package dao;

import java.util.List;

import entity.VaiTro;

public interface VaiTroDAO {
	List<VaiTro> layTatcaVaitro();
	VaiTro layVaitroTheoId(String id);
	VaiTro layVaitroTheoTenvaitro(String tenvaitro);
}
