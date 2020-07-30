/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import Data.NhanVien;
import Modify.KetNoi;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien extends javax.swing.JInternalFrame {
    KetNoi ketnoi;
    ArrayList<NhanVien> list_NhanVien = new ArrayList<>();
    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() {
        initComponents();
        setSize(1000, 540);
        btnThem_NhanVien.setEnabled(true);
        btnSua_NhanVien.setEnabled(false);
        btnXoa_NhanVien.setEnabled(false);
        rdoNam_NhanVien.setSelected(true);
        try {
            ketnoi = new KetNoi();
            ketnoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            filltotable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void openNhanVien() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        quanLyNhanVien.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        txtMa_NhanVien = new javax.swing.JTextField();
        txtHoTen_NhanVien = new javax.swing.JTextField();
        txtNgaySinh_NhanVien = new javax.swing.JTextField();
        txtSoDT_NhanVien = new javax.swing.JTextField();
        rdoNam_NhanVien = new javax.swing.JRadioButton();
        rdoNu_NhanVien = new javax.swing.JRadioButton();
        txtEmail_NhanVien = new javax.swing.JTextField();
        txtLuong_NhanVien = new javax.swing.JTextField();
        txtUsername_NhanVien = new javax.swing.JTextField();
        txtPassword_NhanVien = new javax.swing.JTextField();
        txtCMND_NhanVien = new javax.swing.JTextField();
        cboChucVu_NhanVien = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem_NhanVien = new javax.swing.JButton();
        btnXoa_NhanVien = new javax.swing.JButton();
        btnMoi_NhanVien = new javax.swing.JButton();
        btnSua_NhanVien = new javax.swing.JButton();
        btnThoat_NhanVien = new javax.swing.JButton();

        setResizable(true);
        setTitle("Quản Lý Nhân Viên");

        tbl_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "CMND", "Email", "Chức Vụ", "Lương", "Username", "Password"
            }
        ));
        tbl_NhanVien.setRowHeight(30);
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        txtMa_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtHoTen_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtNgaySinh_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtSoDT_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Gender.add(rdoNam_NhanVien);
        rdoNam_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdoNam_NhanVien.setText("Nam");

        Gender.add(rdoNu_NhanVien);
        rdoNu_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdoNu_NhanVien.setText("Nữ");

        txtEmail_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtLuong_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtUsername_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtPassword_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtCMND_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cboChucVu_NhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboChucVu_NhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân viên" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Họ Tên");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Ngày Sinh");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Giới Tính");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Số ĐT");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("CMND");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Chức Vụ");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Lương");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Username");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Password");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThem_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem_NhanVien.setText("Thêm");
        btnThem_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_NhanVienActionPerformed(evt);
            }
        });

        btnXoa_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnXoa_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa_NhanVien.setText("Xoá");
        btnXoa_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_NhanVienActionPerformed(evt);
            }
        });

        btnMoi_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMoi_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnMoi_NhanVien.setText("Mới");
        btnMoi_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_NhanVienActionPerformed(evt);
            }
        });

        btnSua_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSua_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnSua_NhanVien.setText("Sửa");
        btnSua_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_NhanVienActionPerformed(evt);
            }
        });

        btnThoat_NhanVien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThoat_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnThoat_NhanVien.setText("Thoát");
        btnThoat_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat_NhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMoi_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem_NhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua_NhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa_NhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi_NhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat_NhanVien)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdoNam_NhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNu_NhanVien))
                            .addComponent(txtMa_NhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoDT_NhanVien)
                            .addComponent(txtNgaySinh_NhanVien, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboChucVu_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEmail_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCMND_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLuong_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsername_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPassword_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtCMND_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEmail_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboChucVu_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLuong_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam_NhanVien)
                            .addComponent(rdoNu_NhanVien)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUsername_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoat_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat_NhanVienActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoat_NhanVienActionPerformed

    private void btnThem_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_NhanVienActionPerformed
       them();
    }//GEN-LAST:event_btnThem_NhanVienActionPerformed

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        showDetail();
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btnXoa_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_NhanVienActionPerformed
       
    }//GEN-LAST:event_btnXoa_NhanVienActionPerformed

    private void btnMoi_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi_NhanVienActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoi_NhanVienActionPerformed

    private void btnSua_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_NhanVienActionPerformed
        try {
            // TODO add your handling code here:
            sua();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSua_NhanVienActionPerformed
    
    DefaultTableModel myModel;
    
    public void filltotable() throws SQLException {
        myModel = (DefaultTableModel)tbl_NhanVien.getModel();
        myModel.setRowCount(0);
        String sql = "select * from NhanVien";
        Statement stt = ketnoi.con.createStatement();
        ResultSet rs = stt.executeQuery(sql);
        while (rs.next()) {
            String maNV = rs.getString("MaNV");
            String tenNV = rs.getString("TenNV");
            String ngaysinhNV = rs.getString("NgaySinhNV");
            String gioiTinhNV = rs.getString("GioiTinhNV");
            String sdtNV = rs.getString("SDTNV");
            String cmndNV = rs.getString("CMNDNV");
            String emailNV = rs.getString("EmailNV");
            String chucvuNV = rs.getString("ChucVuNV");
            String luongNV = rs.getString("LuongNV");
            String usernameNV = rs.getString("UsernameNV");
            String passwordNV = rs.getString("PasswordNV");
            
            
            myModel.addRow(new Object[] {maNV,tenNV,ngaysinhNV,gioiTinhNV,sdtNV,cmndNV,emailNV,chucvuNV,luongNV,usernameNV,passwordNV});
            list_NhanVien.add(new NhanVien(maNV,tenNV,ngaysinhNV,gioiTinhNV,sdtNV,cmndNV,emailNV,chucvuNV,Double.parseDouble(luongNV),usernameNV,passwordNV));
        }
    }

    public void showDetail() {
        myModel = (DefaultTableModel)tbl_NhanVien.getModel();
        int row = tbl_NhanVien.getSelectedRow();
        txtMa_NhanVien.setText((String)myModel.getValueAt(row, 0));
        txtHoTen_NhanVien.setText((String)myModel.getValueAt(row, 1));
        txtNgaySinh_NhanVien.setText((String)myModel.getValueAt(row, 2));
        txtSoDT_NhanVien.setText((String)myModel.getValueAt(row, 4));
        txtCMND_NhanVien.setText((String)myModel.getValueAt(row, 5));
        txtEmail_NhanVien.setText((String)myModel.getValueAt(row, 6)); 
        txtLuong_NhanVien.setText((String)myModel.getValueAt(row, 8)); 
        txtUsername_NhanVien.setText((String)myModel.getValueAt(row, 9)); 
        txtPassword_NhanVien.setText((String)myModel.getValueAt(row, 10)); 
        cboChucVu_NhanVien.setSelectedItem((String)myModel.getValueAt(row, 7));
        String gioiTinh = (String)myModel.getValueAt(row, 3);
        if(gioiTinh.equals("Nam")) {
            rdoNam_NhanVien.setSelected(true);
        }
        else{
            rdoNu_NhanVien.setSelected(true);
        }
        btnThem_NhanVien.setEnabled(false);
        btnSua_NhanVien.setEnabled(true);
        btnXoa_NhanVien.setEnabled(true);
    }
    
    public void clearForm() {
        txtMa_NhanVien.setText("");
        txtMa_NhanVien.setEditable(true);
        txtHoTen_NhanVien.setText("");
        txtNgaySinh_NhanVien.setText("");
        rdoNam_NhanVien.setSelected(true);
        txtSoDT_NhanVien.setText("");
        txtEmail_NhanVien.setText("");
        txtCMND_NhanVien.setText("");
        txtLuong_NhanVien.setText("");
        txtUsername_NhanVien.setText("");
        txtPassword_NhanVien.setText("");
        cboChucVu_NhanVien.setSelectedIndex(0);
        btnThem_NhanVien.setEnabled(true);
        btnSua_NhanVien.setEnabled(false);
        btnXoa_NhanVien.setEnabled(false);
    }
    
    public void xoa() throws SQLException, ClassNotFoundException {
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa ?");
        if(chon == 0){
            
        }
    }
    
    public boolean check() {
        if(txtMa_NhanVien.getText().length()==0) {
            JOptionPane.showMessageDialog(this, "Không để trống mã Nhân Viên");
            return false;
        }
        for(NhanVien x : list_NhanVien) {
            if(txtMa_NhanVien.getText().equalsIgnoreCase(x.getMa())){
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
                txtMa_NhanVien.requestFocus(true);
                return false;
            }
        }
        
        if(txtHoTen_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống họ và tên");
            return false;
        }
        
        if(txtNgaySinh_NhanVien.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền ngày sinh nhân viên !");
            txtNgaySinh_NhanVien.requestFocus(true);
            return false;
        }
        Date date = null;
        try {
           date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySinh_NhanVien.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải đúng đính dạng yyyy-MM-dd");
            return false;
        }
        
        if(txtSoDT_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống số điện thoại");
            return false;
        }
        
        String sdtFormat = "0\\d{9}";
        if(!txtSoDT_NhanVien.getText().matches(sdtFormat)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại có 10 số và đúng định dạng 0[1->9]");
            txtSoDT_NhanVien.requestFocus(true);
            return false;
        }
        for(NhanVien x : list_NhanVien) {
            if(txtSoDT_NhanVien.getText().equalsIgnoreCase(x.getSodt())){
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                txtSoDT_NhanVien.requestFocus(true);
                return false;
            }
        }
        
        if(txtCMND_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống CMND");
            return false;
        }
        String cmndFormat = "\\d{12}";
        if(!txtCMND_NhanVien.getText().matches(cmndFormat)) {
            JOptionPane.showMessageDialog(this, "CMND không hợp lệ !");
            txtCMND_NhanVien.requestFocus(true);
            return false;
        } 
        for(NhanVien x : list_NhanVien) {
            if(txtCMND_NhanVien.getText().equalsIgnoreCase(x.getCmnd())){
                JOptionPane.showMessageDialog(this, "CMND đã tồn tại");
                txtCMND_NhanVien.requestFocus(true);
                return false;
            }
        }
       
        if(txtEmail_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống Email");
            return false;
        }
        String emailFormat = "\\w+@gmail.com";
        if(!txtEmail_NhanVien.getText().matches(emailFormat)){
            JOptionPane.showMessageDialog(this, "Email không hợp lệ !");
            txtEmail_NhanVien.requestFocus(true);
            return false;
        }
        for(NhanVien x : list_NhanVien) {
             if(txtEmail_NhanVien.getText().equalsIgnoreCase(x.getEmail())){
                 JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                 txtEmail_NhanVien.requestFocus(true);
                 return false;
             }
        }
        
        if(txtLuong_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống Lương");
            return false;
        }
        try {
            float luong = Float.parseFloat(txtLuong_NhanVien.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương phải là số");
            return false;
        }
        
        
        if(txtUsername_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống Username");
            return false;
        }
        for(NhanVien x : list_NhanVien) {
             if(txtUsername_NhanVien.getText().equalsIgnoreCase(x.getUsername())){
                 JOptionPane.showMessageDialog(this, "Username đã tồn tại");
                 txtUsername_NhanVien.requestFocus(true);
                 return false;
             }
        }
        
        if(txtPassword_NhanVien.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống Password");
            return false;
        }
        return true;
    }
    
    public void them(){
            if(check()) {
            String maNV = txtMa_NhanVien.getText();
            String tenNV = txtHoTen_NhanVien.getText();
            String ngaysinhNV = txtNgaySinh_NhanVien.getText();
            String gioitinhNV;
            if(rdoNam_NhanVien.isSelected()) {
                gioitinhNV = "Nam";
            }
            else{gioitinhNV = "Nữ";}
            String sdtNV = txtSoDT_NhanVien.getText();
            String cmndNV = txtCMND_NhanVien.getText();
            String emailNV = txtEmail_NhanVien.getText();
            String chucvuNV = (String)cboChucVu_NhanVien.getSelectedItem();
            String luongNV = txtLuong_NhanVien.getText();
            String usernameNV = txtUsername_NhanVien.getText();
            String passwordNV = txtPassword_NhanVien.getText();
            try {
                String sql = "INSERT INTO NhanVien " +
                    " VALUES ('"+maNV.trim()+"',N'"+tenNV.trim()+"','"+ngaysinhNV.trim() +"',N'"+gioitinhNV.trim()+"','"+sdtNV.trim()+"','"+cmndNV+"','"+emailNV.trim()+"',N'"+chucvuNV.trim()+"','"+luongNV.trim()+"','"+usernameNV.trim()+"','"+passwordNV.trim()+"')"; 
                Statement stt = ketnoi.con.createStatement();
                ResultSet rs = stt.executeQuery(sql);
                myModel.addRow(new Object[] {maNV, tenNV, ngaysinhNV, gioitinhNV, sdtNV, cmndNV,emailNV,chucvuNV,luongNV,usernameNV,passwordNV}); 
                JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            } catch (Exception e) {
            }
            
        } 
       
    }
    public void sua() throws SQLException {
        try {
           int row = tbl_NhanVien.getSelectedRow();
           list_NhanVien.remove(row);
           String gioitinhNV;
           if(rdoNam_NhanVien.isSelected()) {
                    gioitinhNV = "Nam";
                }
                else{gioitinhNV = "Nữ";}
           NhanVien x = new NhanVien((String)tbl_NhanVien.getValueAt(row, 0), (String)tbl_NhanVien.getValueAt(row, 1), gioitinhNV, (String)tbl_NhanVien.getValueAt(row, 3), (String)tbl_NhanVien.getValueAt(row, 4), (String)tbl_NhanVien.getValueAt(row, 5), (String)tbl_NhanVien.getValueAt(row, 6), (String)tbl_NhanVien.getValueAt(row, 7), Double.parseDouble((String)tbl_NhanVien.getValueAt(row, 8)), (String)tbl_NhanVien.getValueAt(row, 9), (String)tbl_NhanVien.getValueAt(row, 10));
           if(check()){
                String maNV = txtMa_NhanVien.getText();
                String tenNV = txtHoTen_NhanVien.getText();
                String ngaysinhNV = txtNgaySinh_NhanVien.getText();
                if(rdoNam_NhanVien.isSelected()) {
                    gioitinhNV = "Nam";
                }
                else{gioitinhNV = "Nữ";}
                String sdtNV = txtSoDT_NhanVien.getText();
                String cmndNV = txtCMND_NhanVien.getText();
                String emailNV = txtEmail_NhanVien.getText();
                String chucvuNV = (String)cboChucVu_NhanVien.getSelectedItem();
                String luongNV = txtLuong_NhanVien.getText();
                String usernameNV = txtUsername_NhanVien.getText();
                String passwordNV = txtPassword_NhanVien.getText();
                list_NhanVien.add(row, new NhanVien(maNV, sdtNV, ngaysinhNV, gioitinhNV, sdtNV, cmndNV, emailNV, chucvuNV, Double.parseDouble(luongNV), usernameNV, passwordNV));
                
                
                String sql = "UPDATE NhanVien " +
                        "SET MaNV ='"+maNV.trim()+"',TenNV =N'"+tenNV.trim()+"',NgaySinhNV ='"+ngaysinhNV.trim()+"',GioiTinhNV =N'"+gioitinhNV.trim()+"',SDTNV ='"+sdtNV.trim()+"',CMNDNV ='"+cmndNV.trim()+"',EmailNV ='"+emailNV.trim()+"',ChucVuNV =N'"+chucvuNV.trim()+"',LuongNv ='"+luongNV.trim()+"',UsernameNV= '"+usernameNV.trim()+"',PasswordNV ='"+passwordNV.trim()+"' " +
                        "WHERE MaNV ='"+maNV.trim()+"'";
                Statement stt = ketnoi.con.createStatement();
                int rs = stt.executeUpdate(sql);    
                myModel.setValueAt(txtMa_NhanVien.getText(), row, 0);
                myModel.setValueAt(txtHoTen_NhanVien.getText(), row, 1);
                myModel.setValueAt(txtNgaySinh_NhanVien.getText(), row, 2);
                myModel.setValueAt(gioitinhNV, row, 3);
                myModel.setValueAt(txtSoDT_NhanVien.getText(), row, 4);
                myModel.setValueAt(txtCMND_NhanVien.getText(), row, 5);
                myModel.setValueAt(txtEmail_NhanVien.getText(), row, 6);
                myModel.setValueAt(cboChucVu_NhanVien.getSelectedItem(), row, 7);
                myModel.setValueAt(txtLuong_NhanVien.getText(), row, 8);
                myModel.setValueAt(txtUsername_NhanVien.getText(), row, 9);
                myModel.setValueAt(txtPassword_NhanVien.getText(), row, 10);
                clearForm();
                JOptionPane.showMessageDialog(this, "Đã sửa");
           }
           else{
               list_NhanVien.add(row,x);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JButton btnMoi_NhanVien;
    private javax.swing.JButton btnSua_NhanVien;
    private javax.swing.JButton btnThem_NhanVien;
    private javax.swing.JButton btnThoat_NhanVien;
    private javax.swing.JButton btnXoa_NhanVien;
    private javax.swing.JComboBox<String> cboChucVu_NhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam_NhanVien;
    private javax.swing.JRadioButton rdoNu_NhanVien;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txtCMND_NhanVien;
    private javax.swing.JTextField txtEmail_NhanVien;
    private javax.swing.JTextField txtHoTen_NhanVien;
    private javax.swing.JTextField txtLuong_NhanVien;
    private javax.swing.JTextField txtMa_NhanVien;
    private javax.swing.JTextField txtNgaySinh_NhanVien;
    private javax.swing.JTextField txtPassword_NhanVien;
    private javax.swing.JTextField txtSoDT_NhanVien;
    private javax.swing.JTextField txtUsername_NhanVien;
    // End of variables declaration//GEN-END:variables
}
