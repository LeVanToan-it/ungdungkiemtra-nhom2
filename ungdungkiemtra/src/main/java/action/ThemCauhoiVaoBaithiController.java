package action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.BaiThiDAO;
import dao.CauHoiDAO;
import dao.MonHocDAO;
import dao.impl.BaiThiImpl;
import dao.impl.CauHoiImpl;
import dao.impl.MonHocImpl;
import entity.BaiThi;
import entity.CauHoi;
import entity.NguoiDung;
import utility.ClassTableCauhoiModel;
import utility.ClassTableCauhoiTrongBaithiModel;

public class ThemCauhoiVaoBaithiController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JTextField jtfSearch;
	private String mabaithi;
	
	private CauHoiDAO cauhoiDAO = null;
	private BaiThiDAO baiThiDAO = null;
	private String[] listColumn = {"STT", "Tên câu hỏi"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private DefaultTableModel model = null;
	private JTable table = null;
	private BaiThi baithi = null;
	private List<CauHoi> listItem = null;
	private List<CauHoi> dsCauhoi = new ArrayList<CauHoi>();
	
	public ThemCauhoiVaoBaithiController(JPanel jpnView, JTextField jtfSearch, JButton btnAdd, String mabaithi) {
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;
		this.btnAdd = btnAdd;
		this.mabaithi = mabaithi;
		
		this.cauhoiDAO = new CauHoiImpl();
		this.baiThiDAO = new BaiThiImpl();
	}
	
	public void setDateToTable() {
		String mamonhoc = baiThiDAO.layBaithiTheoId(mabaithi).getMonhoc().getId();
			listItem = cauhoiDAO.layDanhsachCauhoiTheoMamonhoc(mamonhoc);
		
			model = new ClassTableCauhoiTrongBaithiModel().setTableModel(listItem, listColumn);
			table = new JTable(model);
			
			rowSorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(rowSorter);
			
			table.getColumnModel().getColumn(0).setMinWidth(80);
			table.getColumnModel().getColumn(0).setMaxWidth(80);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			
			table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
			table.getTableHeader().setPreferredSize(new Dimension(100, 50));
			table.setRowHeight(50);
			table.validate();
			table.repaint();
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.getViewport().add(table);
			scrollPane.setPreferredSize(new Dimension(1100,400));
			
			jpnView.removeAll();
			jpnView.setLayout(new BorderLayout());
			jpnView.add(scrollPane);
			jpnView.validate();
			jpnView.repaint();
	}
	
	public void setEvent() {
		btnAdd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					dsCauhoi.add(cauhoiDAO.layCauhoiTheoTencauhoi(String.valueOf(model.getValueAt(selectedRowIndex, 1))));
					listItem.remove(cauhoiDAO.layCauhoiTheoId(String.valueOf(model.getValueAt(selectedRowIndex, 1))));
					BaiThi baithi = baiThiDAO.layBaithiTheoId(mabaithi);
					baithi.setCauhois(dsCauhoi);
					baiThiDAO.taoHoacChinhsuaBaithi(baithi);
					//System.out.println(baithi);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,200,83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100,221,23));
			}
			
		});
	}
}
