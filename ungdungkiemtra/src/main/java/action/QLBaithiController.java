package action;

import java.awt.BorderLayout;
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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.BaiThiDAO;
import dao.MonHocDAO;
import dao.impl.BaiThiImpl;
import dao.impl.MonHocImpl;
import entity.BaiThi;
import uiFrame.BaithiGVFrm;
import uiFrame.TTBaithiFrm;
import utility.ClassTableBaithiGVModel;
import utility.ClassTableBaithiModel;

public class QLBaithiController {
	private JPanel jpnView;
	private JTextField jtfSearch;
	
	private BaiThiDAO baithiDAO = null;
	private MonHocDAO monhocDAO = null;
	private String[] listColumn = {"STT","Tên bài thi","Môn học"};
	private TableRowSorter<TableModel> rowSorter = null;
	private DefaultTableModel model = null;
	private JTable table = null;
	
	public QLBaithiController(JPanel jpnView, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;
		
		this.baithiDAO = new BaiThiImpl();
		this.monhocDAO = new MonHocImpl();
	}
	
	public void setDateToTable() {
		try {
			List<BaiThi> listItem = baithiDAO.layTatCaBaithi();
			
			model = new ClassTableBaithiModel().setTableModel(listItem, listColumn);
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
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					BaiThi baithi = new BaiThi();
					baithi.setTenBaithi(model.getValueAt(selectedRowIndex, 1).toString());
					baithi.setMonhoc(monhocDAO.layMonhocTheoTenmonhoc(model.getValueAt(selectedRowIndex, 2).toString()));
					
					TTBaithiFrm frame = new TTBaithiFrm(baithi);
					frame.setTitle("Thông tin bài thi");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
