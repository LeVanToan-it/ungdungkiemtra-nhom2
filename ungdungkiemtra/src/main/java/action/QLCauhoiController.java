package action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
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
import entity.MonHoc;
import entity.NguoiDung;
import uiFrame.BaithiGVFrm;
import uiFrame.CauhoiFrm;
import uiFrame.NguoidungFrm;
import utility.ClassTableBaithiGVModel;
import utility.ClassTableCauhoiModel;

public class QLCauhoiController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnSub;
	private JTextField jtfSearch;
	
	private CauHoiDAO cauhoiDAO = null;
	private MonHocDAO monhocDAO = null;
	private String[] listColumn = {"STT","Mã câu hỏi","Tên câu hỏi","Môn học","Câu a","Câu b","Câu c","Câu d"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private DefaultTableModel model = null;
	private JTable table = null;
	
	public QLCauhoiController(JPanel jpnView, JButton btnAdd, JButton btnSub, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnSub = btnSub;
		this.jtfSearch = jtfSearch;
		
		this.cauhoiDAO = new CauHoiImpl();
		this.monhocDAO = new MonHocImpl();
	}
	
	public void setDateToTable() {
		List<CauHoi> listItem = cauhoiDAO.layTatCaCauhoi();
		
		model = new ClassTableCauhoiModel().setTableModel(listItem, listColumn);
		table = new JTable(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
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
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		table.getColumnModel().getColumn(1).setMinWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					CauHoi cauhoi = new CauHoi();
					cauhoi.setId((String)model.getValueAt(selectedRowIndex, 1));
					cauhoi.setTenCauhoi(model.getValueAt(selectedRowIndex, 2).toString());
					cauhoi.setMonhoc(monhocDAO.layMonhocTheoTenmonhoc(model.getValueAt(selectedRowIndex, 3).toString()));
					List<String> tls = Arrays.asList(String.valueOf(model.getValueAt(selectedRowIndex, 4)),
							String.valueOf(model.getValueAt(selectedRowIndex, 5)),String.valueOf(model.getValueAt(selectedRowIndex, 6)),
							String.valueOf(model.getValueAt(selectedRowIndex, 7)));
					cauhoi.setTralois(tls);
					 
					CauhoiFrm frame = new CauhoiFrm(cauhoi);
					frame.setTitle("Thông tin câu hỏi");
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
				CauhoiFrm frame = new CauhoiFrm(new CauHoi());
				frame.setTitle("Thông tin câu hỏi");
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
				
				CauHoi cauhoi = new CauHoi();
				String id = (String)model.getValueAt(selectedRowIndex, 1);
				cauhoiDAO.xoaCauhoiTheoId(id);
				jtfSearch.setText("Xóa thành công câu hỏi " + id);
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
