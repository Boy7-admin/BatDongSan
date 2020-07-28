/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import Modify.KetNoi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyKhachHang extends javax.swing.JInternalFrame {
    KetNoi ketnoi;
    int index;
    /**
     * Creates new form QuanLyKhachHang
     */
//    public void ketnoi() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
//        con = DriverManager.getConnection(hosting, username, password);
//    }
    public QuanLyKhachHang() throws ClassNotFoundException {
        initComponents();
        setSize(1000, 540);
        rdoNam_Khachhang.setSelected(true);
        btnSua_Khachhang.setEnabled(false);
        btnXoa_Khachhang.setEnabled(false);
        try {
            ketnoi = new KetNoi();
            ketnoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            filltotable();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openKhachHang() throws ClassNotFoundException {
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        quanLyKhachHang.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMa_Khachhang = new javax.swing.JTextField();
        txtHoTen_Khachhang = new javax.swing.JTextField();
        txtNgaySinh_Khachhang = new javax.swing.JTextField();
        txtSoDT_Khachhang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Khachhang = new javax.swing.JTable();
        rdoNam_Khachhang = new javax.swing.JRadioButton();
        rdoNu_Khachhang = new javax.swing.JRadioButton();
        txtEmail_Khachhang = new javax.swing.JTextField();
        txtCMND_Khachhang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem_Khachhang = new javax.swing.JButton();
        btnXoa_Khachhang = new javax.swing.JButton();
        btnMoi_Khachhang = new javax.swing.JButton();
        btnSua_Khachhang = new javax.swing.JButton();
        btnThoat_Khachhang = new javax.swing.JButton();

        setResizable(true);
        setTitle("Quản Lý Khách Hàng");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Số ĐT");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("CMND");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        txtMa_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtHoTen_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtNgaySinh_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtSoDT_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        tbl_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tbl_Khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ Tên", "Ngày Sinh", "Giới Tính", "Số ĐT", "CMND", "Email"
            }
        ));
        tbl_Khachhang.setRowHeight(30);
        tbl_Khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Khachhang);

        buttonGroup1.add(rdoNam_Khachhang);
        rdoNam_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdoNam_Khachhang.setText("Nam");

        buttonGroup1.add(rdoNu_Khachhang);
        rdoNu_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdoNu_Khachhang.setText("Nữ");

        txtEmail_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtCMND_Khachhang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Họ Tên");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Ngày Sinh");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Giới Tính");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThem_Khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem_Khachhang.setText("Thêm");
        btnThem_Khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_KhachhangActionPerformed(evt);
            }
        });

        btnXoa_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnXoa_Khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa_Khachhang.setText("Xoá");
        btnXoa_Khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_KhachhangActionPerformed(evt);
            }
        });

        btnMoi_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMoi_Khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnMoi_Khachhang.setText("Mới");
        btnMoi_Khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_KhachhangActionPerformed(evt);
            }
        });

        btnSua_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSua_Khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnSua_Khachhang.setText("Sửa");

        btnThoat_Khachhang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnThoat_Khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnThoat_Khachhang.setText("Thoát");
        btnThoat_Khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat_KhachhangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMoi_Khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa_Khachhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua_Khachhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem_Khachhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat_Khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem_Khachhang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua_Khachhang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa_Khachhang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi_Khachhang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat_Khachhang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgaySinh_Khachhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtHoTen_Khachhang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdoNam_Khachhang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNu_Khachhang))
                            .addComponent(txtMa_Khachhang, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCMND_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtMa_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoDT_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoTen_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNgaySinh_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail_Khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdoNam_Khachhang)
                            .addComponent(rdoNu_Khachhang)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoat_KhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat_KhachhangActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoat_KhachhangActionPerformed

    private void btnThem_KhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_KhachhangActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThem_KhachhangActionPerformed

    private void btnMoi_KhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi_KhachhangActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btnMoi_KhachhangActionPerformed

    private void tbl_KhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachhangMouseClicked
        // TODO add your handling code here:
        showDetail();
    }//GEN-LAST:event_tbl_KhachhangMouseClicked

    private void btnXoa_KhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_KhachhangActionPerformed
//        xoa();
    }//GEN-LAST:event_btnXoa_KhachhangActionPerformed
    
    
    DefaultTableModel myModel;
    public void filltotable() throws SQLException {
        myModel = (DefaultTableModel)tbl_Khachhang.getModel();
        myModel.setRowCount(0);
        String sql = "select * from KhachHang";
        Statement stt = ketnoi.con.createStatement();
        ResultSet rs = stt.executeQuery(sql);
        while(rs.next()) {
            String maKH = rs.getString("MaKH");
            String hoTen = rs.getString("TenKH");
            String ngaySinh = rs.getString("NgaySinhKH");
            String gioiTinh = rs.getString("GioiTinhKH");
            String SDT = rs.getString("SDTKH");
            String CMND = rs.getString("CMNDKH");
            String Email = rs.getString("EmailKH");
            myModel.addRow(new Object[]{maKH, hoTen, ngaySinh, gioiTinh, SDT, CMND, Email});
        }
    }
    
    public boolean check() {
        if(txtMa_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền mã khách hàng !");
            txtMa_Khachhang.requestFocus(true);
            return false;
        }
        for(int i = 0; i < tbl_Khachhang.getRowCount();i++) {
            String maKH = (String)tbl_Khachhang.getValueAt(i, 0);
            if(txtMa_Khachhang.getText().equalsIgnoreCase(maKH)){
                JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
                txtMa_Khachhang.requestFocus(true);
                return false;
            }
        }
        if(txtHoTen_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền họ tên khách hàng !");
            txtHoTen_Khachhang.requestFocus(true);
            return false;
        }
        if(txtNgaySinh_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền ngày sinh khách hàng !");
            txtNgaySinh_Khachhang.requestFocus(true);
            return false;
        }
        Date date = null;
        try {
           date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySinh_Khachhang.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải đúng đính dạng yyyy-MM-dd");
            return false;
        }
        //Check Số điện thoại
        if(txtSoDT_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền số điện thoại khách hàng !");
            txtSoDT_Khachhang.requestFocus(true);
            return false;
        }
        String sdtFormat = "0\\d{9}";
        if(!txtSoDT_Khachhang.getText().matches(sdtFormat)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại có 10 số và đúng định dạng 0[1->9]");
            txtSoDT_Khachhang.requestFocus(true);
            return false;
        }
        for(int i = 0; i < tbl_Khachhang.getRowCount();i++) {
            String sdt  = (String)tbl_Khachhang.getValueAt(i, 4);
            if(txtSoDT_Khachhang.getText().equalsIgnoreCase(sdt)){
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                txtSoDT_Khachhang.requestFocus(true);
                return false;
            }
        }
        if(txtCMND_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền cmnd khách hàng !");
            txtCMND_Khachhang.requestFocus(true);
            return false;
        }
        String cmndFormat = "\\d{12}";
        if(!txtCMND_Khachhang.getText().matches(cmndFormat)) {
            JOptionPane.showMessageDialog(this, "CMND không hợp lệ !");
            txtCMND_Khachhang.requestFocus(true);
            return false;
        } 
        for(int i = 0; i < tbl_Khachhang.getRowCount();i++) {
            String cmnd  = (String)tbl_Khachhang.getValueAt(i, 5);
            if(txtCMND_Khachhang.getText().equalsIgnoreCase(cmnd)){
                JOptionPane.showMessageDialog(this, "CMND đã tồn tại");
                txtCMND_Khachhang.requestFocus(true);
                return false;
            }
        }
        if(txtEmail_Khachhang.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Hãy điền email khách hàng !");
            txtEmail_Khachhang.requestFocus(true);
            return false;
        }
        String emailFormat = "\\w+@gmail.com";
        if(!txtEmail_Khachhang.getText().matches(emailFormat)){
            JOptionPane.showMessageDialog(this, "Email không hợp lệ !");
            txtEmail_Khachhang.requestFocus(true);
            return false;
        }
        for(int i = 0; i < tbl_Khachhang.getRowCount();i++) {
             String email  = (String)tbl_Khachhang.getValueAt(i, 6);
             if(txtEmail_Khachhang.getText().equalsIgnoreCase(email)){
                 JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                 txtEmail_Khachhang.requestFocus(true);
                 return false;
             }
        }
        return true;
    }
    
    public void them() {
        if(check()) {
            String gt = null;
            if(rdoNam_Khachhang.isSelected()){
                gt = "Nam";
            }
            else{gt = "Nữ";}
            String maKH = txtMa_Khachhang.getText();
            String hoTen = txtHoTen_Khachhang.getText();
            String ngaySinh = txtNgaySinh_Khachhang.getText();
            String SDT = txtSoDT_Khachhang.getText();
            String CMND = txtCMND_Khachhang.getText();
            String Email = txtEmail_Khachhang.getText();
            try {
                String sql = "INSERT INTO KhachHang " +
                        "VALUES ('"+maKH.trim()+"',N'"+hoTen.trim()+"','"+ngaySinh.trim()+"',N'"+gt.trim()+"','"+SDT.trim()+"','"+CMND.trim()+"','"+Email.trim()+"')";
                Statement stt = ketnoi.con.createStatement();
                ResultSet rs = stt.executeQuery(sql);
                myModel.addRow(new Object[] {maKH, hoTen, ngaySinh, gt, SDT,CMND,Email}); 
                JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            } catch (Exception e) {
            }
            
        }
    }
    
    public void moi() {
        btnThem_Khachhang.setEnabled(true);
        btnSua_Khachhang.setEnabled(false);
        btnXoa_Khachhang.setEnabled(false);
        tbl_Khachhang.clearSelection();
        txtMa_Khachhang.setText("");
        txtHoTen_Khachhang.setText("");
        txtNgaySinh_Khachhang.setText("");
        rdoNam_Khachhang.setSelected(true);
        txtSoDT_Khachhang.setText("");
        txtEmail_Khachhang.setText("");
        txtCMND_Khachhang.setText("");
        txtMa_Khachhang.requestFocus(true);
    }
    
    public void xoa(){
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa");
        if(chon == 0){
            
        }
    }
   
    public void update() {
        
    }
    public void showDetail() {
        index = tbl_Khachhang.getSelectedRow();
        txtMa_Khachhang.setText((String)myModel.getValueAt(index, 0));
        txtHoTen_Khachhang.setText((String)myModel.getValueAt(index, 1));
        txtNgaySinh_Khachhang.setText((String)myModel.getValueAt(index, 2));
        txtSoDT_Khachhang.setText((String)myModel.getValueAt(index, 4));
        txtCMND_Khachhang.setText((String)myModel.getValueAt(index, 5));
        txtEmail_Khachhang.setText((String)myModel.getValueAt(index, 6));
        String gt = (String)myModel.getValueAt(index, 3);
        if(gt.equals("Nam")) {
            rdoNam_Khachhang.setSelected(true);
        }
        else{
            rdoNu_Khachhang.setSelected(true);
        }
        btnSua_Khachhang.setEnabled(true);
        btnXoa_Khachhang.setEnabled(true);
        btnThem_Khachhang.setEnabled(false);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi_Khachhang;
    private javax.swing.JButton btnSua_Khachhang;
    private javax.swing.JButton btnThem_Khachhang;
    private javax.swing.JButton btnThoat_Khachhang;
    private javax.swing.JButton btnXoa_Khachhang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam_Khachhang;
    private javax.swing.JRadioButton rdoNu_Khachhang;
    private javax.swing.JTable tbl_Khachhang;
    private javax.swing.JTextField txtCMND_Khachhang;
    private javax.swing.JTextField txtEmail_Khachhang;
    private javax.swing.JTextField txtHoTen_Khachhang;
    private javax.swing.JTextField txtMa_Khachhang;
    private javax.swing.JTextField txtNgaySinh_Khachhang;
    private javax.swing.JTextField txtSoDT_Khachhang;
    // End of variables declaration//GEN-END:variables
}
