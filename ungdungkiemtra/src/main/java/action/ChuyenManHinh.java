package action;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.objectweb.asm.tree.analysis.Frame;

import bean.DanhMucBean;
import dao.NguoiDungDAO;
import dao.impl.NguoidungImpl;
import entity.NguoiDung;
import uiFrame.DangnhapDialog;
import uiFrame.MainFrm;
import uiFrame.QLBaithiGVPanel;
import uiFrame.QLBaithiPanel;
import uiFrame.QLCanhanPanel;
import uiFrame.QLCauhoiPanel;
import uiFrame.QLMonhocPanel;
import uiFrame.QLNguoidungPanel;


public class ChuyenManHinh{
	private JPanel root ;
    public String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    private DanhMucBean dmb = null;
    private NguoiDung nguoidung = null;
    
    public ChuyenManHinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "QLBaithi";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QLBaithiPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        this.dmb = listItem.get(listItem.size()-1);
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb(), item.getNguoidung()));
        }
    }
    
    class LabelEvent implements MouseListener{

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;
        private NguoiDung nd;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem, NguoiDung nd) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.nd = nd;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
	            case "QLBaithi":
	                node = new QLBaithiPanel();
	                break;
	            case "QLCanhan":
					node = new QLCanhanPanel(nd);
	                break;
	            case "QLBaithiGV":
	                node = new QLBaithiGVPanel();
	                break;
	            case "QLCauhoi":
	                node = new QLCauhoiPanel();
	                break;
	            case "QLMonhoc":
	                node = new QLMonhocPanel();
	                break;
	            case "QLNguoidung":
					node = new QLNguoidungPanel();
	                break;
	            case "Thoat":
	            	System.exit(0);
	            	break;
	            case "DangXuat":
	            	
					break;
	            default:
	                break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
    }
    
    private void setChangeBackground(String kind){
        for(DanhMucBean item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            }else{
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }
}