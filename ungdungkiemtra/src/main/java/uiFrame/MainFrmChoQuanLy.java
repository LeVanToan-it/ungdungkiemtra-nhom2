package uiFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import action.ChuyenManHinh;
import bean.DanhMucBean;
import entity.NguoiDung;

public class MainFrmChoQuanLy extends javax.swing.JFrame {

    /**
     * Creates new form MainFrmChoQuanLy
     */
    public MainFrmChoQuanLy(NguoiDung nguoidung) {
        initComponents();
        
        setTitle("Ứng Dụng Kiểm Tra");
        
        ChuyenManHinh controller = new ChuyenManHinh(jpnViewQL);
        controller.setView(jpnQLMonhoc, jlbQLMonhoc);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("QLMonhoc", jpnQLMonhoc, jlbQLMonhoc));
        listItem.add(new DanhMucBean("QLNguoidung", jpnQLNguoidung, jlbQLNguoidung));
       
        jlbName.setText(nguoidung.getTenNguoidung());
        controller.setEvent(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jpnRootQL = new javax.swing.JPanel();
        jpnMenuQL = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlbName = new javax.swing.JLabel();
        jpnQLMonhoc = new javax.swing.JPanel();
        jlbQLMonhoc = new javax.swing.JLabel();
        jpnQLNguoidung = new javax.swing.JPanel();
        jlbQLNguoidung = new javax.swing.JLabel();
        jpnDangxuat = new javax.swing.JPanel();
        jlbDangxuat = new javax.swing.JLabel();
        jpnThoat = new javax.swing.JPanel();
        jlbThoat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpnViewQL = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenuQL.setBackground(new java.awt.Color(82, 83, 81));

        jPanel4.setBackground(new java.awt.Color(232, 64, 60));

        jlbName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbName.setForeground(new java.awt.Color(255, 255, 255));
        jlbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbName.setText("QUẢN LÝ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbName, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jpnQLMonhoc.setBackground(new java.awt.Color(0, 153, 51));

        jlbQLMonhoc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbQLMonhoc.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLMonhoc.setText("QUẢN LÝ MÔN HỌC");

        javax.swing.GroupLayout jpnQLMonhocLayout = new javax.swing.GroupLayout(jpnQLMonhoc);
        jpnQLMonhoc.setLayout(jpnQLMonhocLayout);
        jpnQLMonhocLayout.setHorizontalGroup(
            jpnQLMonhocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLMonhocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbQLMonhoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnQLMonhocLayout.setVerticalGroup(
            jpnQLMonhocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLMonhocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbQLMonhoc, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jpnQLNguoidung.setBackground(new java.awt.Color(0, 153, 51));

        jlbQLNguoidung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbQLNguoidung.setForeground(new java.awt.Color(255, 255, 255));
        jlbQLNguoidung.setText("QUẢN LÝ NGƯỜI DÙNG");

        javax.swing.GroupLayout jpnQLNguoidungLayout = new javax.swing.GroupLayout(jpnQLNguoidung);
        jpnQLNguoidung.setLayout(jpnQLNguoidungLayout);
        jpnQLNguoidungLayout.setHorizontalGroup(
            jpnQLNguoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNguoidungLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbQLNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnQLNguoidungLayout.setVerticalGroup(
            jpnQLNguoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNguoidungLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbQLNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jpnDangxuat.setBackground(new java.awt.Color(0, 153, 51));

        jlbDangxuat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbDangxuat.setForeground(new java.awt.Color(255, 255, 255));
        jlbDangxuat.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout jpnDangxuatLayout = new javax.swing.GroupLayout(jpnDangxuat);
        jpnDangxuat.setLayout(jpnDangxuatLayout);
        jpnDangxuatLayout.setHorizontalGroup(
            jpnDangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangxuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbDangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnDangxuatLayout.setVerticalGroup(
            jpnDangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangxuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbDangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jpnThoat.setBackground(new java.awt.Color(0, 153, 51));

        jlbThoat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbThoat.setForeground(new java.awt.Color(255, 255, 255));
        jlbThoat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbThoat.setText("THOÁT");

        javax.swing.GroupLayout jpnThoatLayout = new javax.swing.GroupLayout(jpnThoat);
        jpnThoat.setLayout(jpnThoatLayout);
        jpnThoatLayout.setHorizontalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThoatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnThoatLayout.setVerticalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThoatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lập trình phân tán Java - Nhóm 2");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jpnMenuQLLayout = new javax.swing.GroupLayout(jpnMenuQL);
        jpnMenuQL.setLayout(jpnMenuQLLayout);
        jpnMenuQLLayout.setHorizontalGroup(
            jpnMenuQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLMonhoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnDangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnMenuQLLayout.setVerticalGroup(
            jpnMenuQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuQLLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnQLMonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnQLNguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnViewQLLayout = new javax.swing.GroupLayout(jpnViewQL);
        jpnViewQL.setLayout(jpnViewQLLayout);
        jpnViewQLLayout.setHorizontalGroup(
            jpnViewQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
        );
        jpnViewQLLayout.setVerticalGroup(
            jpnViewQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootQLLayout = new javax.swing.GroupLayout(jpnRootQL);
        jpnRootQL.setLayout(jpnRootQLLayout);
        jpnRootQLLayout.setHorizontalGroup(
            jpnRootQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootQLLayout.createSequentialGroup()
                .addComponent(jpnMenuQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnViewQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootQLLayout.setVerticalGroup(
            jpnRootQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenuQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnViewQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRootQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRootQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>     

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrmChoQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrmChoQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrmChoQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrmChoQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrmChoQuanLy(new NguoiDung()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbDangxuat;
    private javax.swing.JLabel jlbQLMonhoc;
    private javax.swing.JLabel jlbQLNguoidung;
    private javax.swing.JLabel jlbThoat;
    private javax.swing.JPanel jpnDangxuat;
    private javax.swing.JPanel jpnMenuQL;
    private javax.swing.JPanel jpnQLMonhoc;
    private javax.swing.JPanel jpnQLNguoidung;
    private javax.swing.JPanel jpnRootQL;
    private javax.swing.JPanel jpnThoat;
    private javax.swing.JPanel jpnViewQL;
    // End of variables declaration                   
}
