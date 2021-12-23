package action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.BaiThiDAO;
import dao.CauHoiDAO;
import dao.impl.BaiThiImpl;
import dao.impl.CauHoiImpl;
import entity.BaiThi;
import entity.CauHoi;
import entity.NguoiDung;
import uiFrame.BaithiGVFrm;
import uiFrame.CauhoiFrm;
import uiFrame.ThemCauhoiVaoBaithiFrm;
import utility.ClassTableCauhoiTrongBaithiModel;

public class QLCauhoiTrongBaithiGVController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnSub;
	private String mabaithi;
	
	private CauHoiDAO cauhoiDAO = null;
	private BaiThiDAO baiThiDAO = null;
	private String[] listColumn = {"STT", "Tên câu hỏi"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private DefaultTableModel model = null;
	private JTable table = null;
	private BaiThi baithi = null;
	private List<CauHoi> listItem = null;
	
	public QLCauhoiTrongBaithiGVController(JPanel jpnView, JButton btnAdd, JButton btnSub, String mabaithi) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnSub = btnSub;
		this.mabaithi = mabaithi;
		
		this.cauhoiDAO = new CauHoiImpl();
		this.baiThiDAO = new BaiThiImpl();
	}
	
	public void setDateToTable() {
		try {
			listItem = baiThiDAO.layDanhsachCauhoiTuMabaithi(mabaithi);
		
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
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setEvent() {
		btnAdd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ThemCauhoiVaoBaithiFrm frame = new ThemCauhoiVaoBaithiFrm(baiThiDAO.layBaithiTheoId(mabaithi));
				frame.setTitle("Danh sách câu hỏi");
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
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
		
		btnSub.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
				
				NguoiDung nguoidung = new NguoiDung();
				String id = (String)model.getValueAt(selectedRowIndex, 1);
				CauHoi ch = cauhoiDAO.layCauhoiTheoId(id);
				listItem.remove(ch);
				//jtfSearch.setText("Xóa thành công người dùng " + id);
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
				btnSub.setBackground(new Color(204,0,0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSub.setBackground(new Color(204,0,0));
			}
			
		});
	}
}
