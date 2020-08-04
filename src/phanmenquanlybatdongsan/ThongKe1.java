/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import Data.PicPanel;
import Modify.KetNoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public final class ThongKe1 extends javax.swing.JInternalFrame {

    KetNoi ketNoi;

    /**
     * Creates new form ThongKe
     */
    public ThongKe1() {
        initComponents();
        setSize(1000, 540);
        setTitle("Thống Kê");
        PicPanel pic = new PicPanel("C:\\Users\\admin\\Desktop\\FPT_DaoTao\\img\\bg.jpg");
        pic.setBounds(0, 0, 1000, 700);
        add(pic);
        try {
            FillToTable("select * from BatDongSan");
            cbxLoaiBDS();
            cboTrangThaibds.setSelectedIndex(1);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiBDS = new javax.swing.JComboBox<>();
        lblSoLuongBDS = new javax.swing.JLabel();
        cboTrangThaibds = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Loại:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Trạng Thái:");

        cboLoaiBDS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đất nền", "Căn hộ", "Biệt thự" }));
        cboLoaiBDS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiBDSItemStateChanged(evt);
            }
        });

        lblSoLuongBDS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSoLuongBDS.setForeground(new java.awt.Color(255, 255, 0));
        lblSoLuongBDS.setText("Số Lượng:");

        cboTrangThaibds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã bán", "Chưa bán" }));
        cboTrangThaibds.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTrangThaibdsItemStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Giá", "Địa chỉ", "Mô tả"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Thoat-removebg-preview.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Thông Kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLoaiBDS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTrangThaibds, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(lblSoLuongBDS, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(435, 435, 435))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboLoaiBDS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTrangThaibds, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoLuongBDS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboLoaiBDSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiBDSItemStateChanged
        try {
            // TODO add your handling code here:
            cbxLoaiBDS();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboLoaiBDSItemStateChanged

    private void cboTrangThaibdsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTrangThaibdsItemStateChanged
        try {
            // TODO add your handling code here:
            cbxTrangThaiBDS();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboTrangThaibdsItemStateChanged
    public void ketnoi() throws ClassNotFoundException, SQLException {
        ketNoi = new KetNoi();
        ketNoi.ketnoi();
    }

    List<ThongKeBDS> list = new ArrayList<>();

    public void FillToTable(String lenh) throws SQLException {
        try {
            ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement stt = ketNoi.con.createStatement();
        ResultSet rs = stt.executeQuery(lenh);
        list.removeAll(list);
        while (rs.next()) {
            String maBds = rs.getString("MaBDS");
            String TenBDS = rs.getString("TenBDS");
            String GiaBDS = rs.getString("GiaBDS");
            String DiaChiBDS = rs.getString("DiaChiBDS");
            String LoaiBDS = rs.getString("LoaiBDS");
            String MotaBDS = rs.getString("MotaBDS");
            String TrangThai = rs.getString("TrangThai");
            list.add(new ThongKeBDS(maBds, TenBDS, GiaBDS, DiaChiBDS, LoaiBDS, MotaBDS, TrangThai));
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.removeAll();
        model.setRowCount(0);
        list.forEach((tk) -> {
            model.addRow(new Object[]{tk.getMa(), tk.getTen(), tk.getGia(), tk.getDiachi(), tk.getMota()});
        });
        lblSoLuongBDS.setText("Số lượng : " + list.size());
    }

    public void cbxLoaiBDS() throws SQLException {

        switch (cboLoaiBDS.getSelectedIndex()) {
            case 0:
                FillToTable("SELECT *FROM BatDongSan where LoaiBDS=N'Đất nền'");
                break;
            case 1:
                FillToTable("SELECT *FROM BatDongSan where LoaiBDS=N'Căn hộ'");
                break;
            case 2:
                FillToTable("SELECT *FROM BatDongSan where LoaiBDS=N'Biệt thự'");
                break;
            default:
                break;
        }
    }

    public void cbxTrangThaiBDS() throws SQLException {
        if (cboTrangThaibds.getSelectedIndex() == 0) {
            FillToTable("select * from BatDongSan where TrangThai=N'Đã bán'");
        } else if (cboTrangThaibds.getSelectedIndex() == 1) {
            FillToTable("select * from BatDongSan where TrangThai=N'Chưa bán'");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLoaiBDS;
    private javax.swing.JComboBox<String> cboTrangThaibds;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSoLuongBDS;
    // End of variables declaration//GEN-END:variables
}
