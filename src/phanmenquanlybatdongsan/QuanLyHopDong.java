/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shiro
 */
public class QuanLyHopDong extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    QuanLyHopDong quanLyHopDong;
    List<Data.HopDong> listHD = new ArrayList<>();
    Date date = null;

    /**
     * Creates new form QuanLyHopDong
     */
    public QuanLyHopDong() {
        initComponents();
        setSize(1000, 540);
        model = (DefaultTableModel) tbl_HopDong.getModel();
        fill();
    }

    private void fill() {
        listHD = Modify.HopDongModify.filltoTable();
        model.setRowCount(0);
        listHD.forEach((hds) -> {
            model.addRow(new Object[]{hds.getMa(), hds.getTen(), hds.getManv(), hds.getMakh(), hds.getMabds(), hds.getNgaytao()});
        });
    }

    public void openHopDong() {
        quanLyHopDong = new QuanLyHopDong();
        quanLyHopDong.setVisible(true);
    }

    public void moi() {
        txtMaHD_HopDong.setText("");
        txtTenHD_HopDong.setText("");
        txtMaNV_HopDong.setText("");
        txtMaKH_HopDong.setText("");
        txtMaBDS_HopDong.setText("");
        txtNgayTao_HopDong.setText("");
    }

    public boolean check() {
        listHD = new ArrayList<>();
        if (txtMaHD_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ma");
            txtMaHD_HopDong.requestFocus();
            return false;
        }
        for (int i = 0; i < tbl_HopDong.getRowCount(); i++) {
            String ma = (String) tbl_HopDong.getValueAt(i, 0);
            if (txtMaHD_HopDong.getText().equals(ma)) {
                JOptionPane.showMessageDialog(this, "Ma hop dong da duoc su dung");
                txtMaHD_HopDong.requestFocus();
                txtMaHD_HopDong.setText("");
                return false;

            }
        }

        if (txtTenHD_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten");
            txtTenHD_HopDong.requestFocus();
            return false;
        }
        if (txtMaNV_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ma nhan vien");
            txtMaNV_HopDong.requestFocus();
            return false;
        }
        if (txtMaKH_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ma khach hang");
            txtMaKH_HopDong.requestFocus();
            return false;
        }
        if (txtMaBDS_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ma bat dong san");
            txtMaBDS_HopDong.requestFocus();
            return false;
        }
        for (int i = 0; i < tbl_HopDong.getRowCount(); i++) {
            String ma = (String) tbl_HopDong.getValueAt(i, 4);
            if (txtMaBDS_HopDong.getText().equals(ma)) {
                JOptionPane.showMessageDialog(this, "bat dong san nay da duoc ban");
                txtMaBDS_HopDong.requestFocus();
                txtMaBDS_HopDong.setText("");
                return false;

            }
        }
        if (txtNgayTao_HopDong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ngay tao hop dong");
            txtNgayTao_HopDong.requestFocus();
            return false;
        }
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(txtNgayTao_HopDong.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Nhap lai ngay tao hop dong");
            txtNgayTao_HopDong.setText("");
            txtNgayTao_HopDong.requestFocus();
            return false;
        }
        return true;
    }

    public void them() {
        if (check()) {
            Data.HopDong hopDong = new Data.HopDong(txtMaHD_HopDong.getText(),
                    txtTenHD_HopDong.getText(),
                    txtMaNV_HopDong.getText(),
                    txtMaKH_HopDong.getText(),
                    txtMaBDS_HopDong.getText(),
                    txtNgayTao_HopDong.getText());
            Modify.HopDongModify.insert(hopDong);
            fill();
        }
    }

    public void showDetail() {
        int i = tbl_HopDong.getSelectedRow();
        if (i >= 0) {
            Data.HopDong hd = listHD.get(i);
            txtMaHD_HopDong.setText(hd.getMa());
            txtTenHD_HopDong.setText(hd.getTen());
            txtMaNV_HopDong.setText(hd.getManv());
            txtMaKH_HopDong.setText(hd.getMakh());
            txtMaBDS_HopDong.setText(hd.getMabds());
            txtNgayTao_HopDong.setText(hd.getNgaytao());
        }
    }

    public void xoa() {
        try {
            String macanxoa = JOptionPane.showInputDialog(this, "Nhap ma hop dong can xoa: ");
            int a = 0;
            for (int i = 0; i <= listHD.size(); i++) {
                if (macanxoa.equalsIgnoreCase(listHD.get(i).getMa())) {
                    a++;
                    int option = JOptionPane.showConfirmDialog(this, "Xoa hop dong co ma: " + macanxoa);
                    switch (option) {
                        case 0:
                            Modify.HopDongModify.delete(macanxoa);
                            fill();
                            moi();
                            return;
                        case 1:
                            return;
                        case 2:
                            return;
                        default:
                            break;
                    }
                }
            }
            if (a == 0) {
                JOptionPane.showMessageDialog(this, "Khong tim hop dong co ma: " + macanxoa);
            }
        } catch (java.lang.NullPointerException e) {

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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD_HopDong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenHD_HopDong = new javax.swing.JTextField();
        txtMaNV_HopDong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HopDong = new javax.swing.JTable();
        txtMaBDS_HopDong = new javax.swing.JTextField();
        txtNgayTao_HopDong = new javax.swing.JTextField();
        txtMaKH_HopDong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem_HopDong = new javax.swing.JButton();
        btnXoa_HopDong = new javax.swing.JButton();
        btnMoi_HopDong = new javax.swing.JButton();
        btnSua_HopDong = new javax.swing.JButton();
        btnThoat_HopDong = new javax.swing.JButton();

        setResizable(true);
        setTitle("Quản Lý Hợp Đồng");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Mã KH");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Mã BĐS");

        txtMaHD_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Ngày Tạo");

        txtTenHD_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtMaNV_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        tbl_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tbl_HopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Tên HĐ", "Mã NV", "Mã KH", "Mã BĐS", "Ngày Tạo"
            }
        ));
        tbl_HopDong.setRowHeight(30);
        tbl_HopDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HopDongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_HopDong);

        txtMaBDS_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtNgayTao_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtMaKH_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã HĐ");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tên HĐ");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Mã NV");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThem_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem_HopDong.setText("Thêm");
        btnThem_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_HopDongActionPerformed(evt);
            }
        });

        btnXoa_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnXoa_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa_HopDong.setText("Xoá");
        btnXoa_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HopDongActionPerformed(evt);
            }
        });

        btnMoi_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMoi_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnMoi_HopDong.setText("Mới");
        btnMoi_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_HopDongActionPerformed(evt);
            }
        });

        btnSua_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSua_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnSua_HopDong.setText("Sửa");
        btnSua_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HopDongActionPerformed(evt);
            }
        });

        btnThoat_HopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThoat_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnThoat_HopDong.setText("Thoát");
        btnThoat_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat_HopDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMoi_HopDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa_HopDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua_HopDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem_HopDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat_HopDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem_HopDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua_HopDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa_HopDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi_HopDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat_HopDong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaNV_HopDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtTenHD_HopDong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD_HopDong, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaBDS_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaKH_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHD_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaBDS_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenHD_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaNV_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoat_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat_HopDongActionPerformed
        this.hide();
    }//GEN-LAST:event_btnThoat_HopDongActionPerformed

    private void btnThem_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_HopDongActionPerformed
        them();
    }//GEN-LAST:event_btnThem_HopDongActionPerformed

    private void btnSua_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_HopDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua_HopDongActionPerformed

    private void btnXoa_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HopDongActionPerformed
        xoa();
    }//GEN-LAST:event_btnXoa_HopDongActionPerformed

    private void btnMoi_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi_HopDongActionPerformed
        moi();
    }//GEN-LAST:event_btnMoi_HopDongActionPerformed

    private void tbl_HopDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HopDongMouseClicked
        showDetail();
    }//GEN-LAST:event_tbl_HopDongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi_HopDong;
    private javax.swing.JButton btnSua_HopDong;
    private javax.swing.JButton btnThem_HopDong;
    private javax.swing.JButton btnThoat_HopDong;
    private javax.swing.JButton btnXoa_HopDong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_HopDong;
    private javax.swing.JTextField txtMaBDS_HopDong;
    private javax.swing.JTextField txtMaHD_HopDong;
    private javax.swing.JTextField txtMaKH_HopDong;
    private javax.swing.JTextField txtMaNV_HopDong;
    private javax.swing.JTextField txtNgayTao_HopDong;
    private javax.swing.JTextField txtTenHD_HopDong;
    // End of variables declaration//GEN-END:variables
}
