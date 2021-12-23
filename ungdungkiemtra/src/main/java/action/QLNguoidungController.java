package action;

import java.util.List;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import dao.LopDAO;
import dao.NguoiDungDAO;
import dao.VaiTroDAO;
import dao.impl.LopImpl;
import dao.impl.NguoidungImpl;
import dao.impl.VaiTroImpl;
import entity.NguoiDung;
import entity.VaiTro;
import uiFrame.NguoidungFrm;
import utility.ClassTableNguoidungModel;

public class QLNguoidungController{
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnSub;
	private JTextField jtfSearch;
	
	private NguoiDungDAO nguoidungDAO = null;
	private LopDAO lopDAO = null;
	private VaiTroDAO vaitroDAO = null;
	private String[] listColumn = {"STT","Mã người dùng","Tên người dùng","Giới tính", "Số điện thoại","Năm sinh","Địa chỉ","Lớp","Vai trò"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private JTable table = null;
	private DefaultTableModel model = null;
	
	public QLNguoidungController(JPanel jpnView, JButton btnAdd, JButton btnSub, JTextField jtfSearch){
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnSub = btnSub;
		this.jtfSearch = jtfSearch;
		
		this.nguoidungDAO = new NguoidungImpl();
		this.lopDAO = new LopImpl();
		this.vaitroDAO = new VaiTroImpl();
	}
	
	public void setDateToTable() {
		try {
			List<NguoiDung> listItem = nguoidungDAO.layTatCaNguoidung();
			
			model = new ClassTableNguoidungModel().setTableModel(listItem, listColumn);
			table = new JTable(model);
			
			rowSorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(rowSorter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(0);

		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int selectedRowIndex = table.getSelectedRow();
						selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
						
						NguoiDung nguoidung = new NguoiDung();
						nguoidung.setId((String)model.getValueAt(selectedRowIndex, 1));
						nguoidung.setTenNguoidung(model.getValueAt(selectedRowIndex, 2).toString());
						nguoidung.setGioiTinh(model.getValueAt(selectedRowIndex, 3).toString());
						nguoidung.setSoDienthoai(model.getValueAt(selectedRowIndex, 4).toString());
						nguoidung.setNamSinh(Integer.parseInt(model.getValueAt(selectedRowIndex, 5).toString()));
						nguoidung.setDiaChi(model.getValueAt(selectedRowIndex, 6).toString());
						nguoidung.setLop(lopDAO.timLopTheoTenlop(model.getValueAt(selectedRowIndex, 7).toString()));
						nguoidung.setVaitro(vaitroDAO.layVaitroTheoTenvaitro(model.getValueAt(selectedRowIndex, 8).toString()));
						NguoidungFrm frame = null;

							frame = new NguoidungFrm(nguoidung);

						frame.setTitle("Thông tin cá nhân");
						frame.setResizable(false);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
				
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
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
				NguoidungFrm frame = null;
				frame = new NguoidungFrm(new NguoiDung());
				frame.setTitle("Thông tin người dùng");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
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
				
					nguoidungDAO.xoaNguoidungTheoId(id);
				
				jtfSearch.setText("Xóa thành công người dùng " + id);
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
