/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import Data.BatDongSan;
import Data.KhachHang;
import Data.NhanVien;
import Data.PicPanel;
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

    QuanLyNhanVien qlnv;
    QuanLyKhachHang qlkh;
    QuanLyBatDongSan qlbds;

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
        PicPanel pic = new PicPanel("C:\\Users\\admin\\Desktop\\FPT_DaoTao\\img\\bg.jpg");
        pic.setBounds(0, 0, 1000, 700);
        add(pic);
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
        try {

            qlnv = new QuanLyNhanVien();
            ArrayList<NhanVien> listNV = qlnv.list_NhanVien;

            qlkh = new QuanLyKhachHang();
            ArrayList<KhachHang> listKH = qlkh.listKH;

            qlbds = new QuanLyBatDongSan();
            List<BatDongSan> listBDS = qlbds.listBDS;

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
            int a = 0;
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getMa().equalsIgnoreCase(txtMaNV_HopDong.getText())) {
                    a++;
                }
            }
            if (a == 0) {
                JOptionPane.showMessageDialog(qlnv, "Ma nhan vien khong ton tai");
                System.out.println(listNV.size());
                txtMaNV_HopDong.setText("");
                txtMaNV_HopDong.requestFocus();
                return false;
            }
            if (txtMaKH_HopDong.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chua nhap ma khach hang");
                txtMaKH_HopDong.requestFocus();
                return false;
            }
            int b = 0;
            for (int i = 0; i < listKH.size(); i++) {
                if (listKH.get(i).getMakh().equalsIgnoreCase(txtMaKH_HopDong.getText())) {
                    b++;
                }
            }
            if (b == 0) {
                JOptionPane.showMessageDialog(qlkh, "Ma khach hang khong ton tai");
                txtMaKH_HopDong.setText("");
                txtMaKH_HopDong.requestFocus();
                return false;
            }
            if (txtMaBDS_HopDong.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chua nhap ma bat dong san");
                txtMaBDS_HopDong.requestFocus();
                return false;
            }
            int c = 0;
            for (int i = 0; i < listBDS.size(); i++) {
                if (listBDS.get(i).getMa().equalsIgnoreCase(txtMaBDS_HopDong.getText())) {
                    c++;
                }
            }
            if (c == 0) {
                JOptionPane.showMessageDialog(qlbds, "Ma bat dong san khong ton tai");
                txtMaBDS_HopDong.setText("");
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
        } catch (Exception e) {
            return false;
        }
    }

    public void them() {
        try {

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(qlnv, "Loi ngay tao hop dong");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD_HopDong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenHD_HopDong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV_HopDong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH_HopDong = new javax.swing.JTextField();
        txtMaBDS_HopDong = new javax.swing.JTextField();
        txtNgayTao_HopDong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThem_HopDong = new javax.swing.JButton();
        btnSua_HopDong = new javax.swing.JButton();
        btnXoa_HopDong = new javax.swing.JButton();
        btnMoi_HopDong = new javax.swing.JButton();
        btnThoat_HopDong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HopDong = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Quản Lý Hợp Đồng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hợp Đồng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã HĐ :");

        txtMaHD_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tên HĐ :");

        txtTenHD_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Mã NV :");

        txtMaNV_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Mã KH :");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Mã BĐS :");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Ngày Tạo :");

        txtMaKH_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtMaBDS_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtNgayTao_HopDong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaHD_HopDong)
                            .addComponent(txtTenHD_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(txtMaNV_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaKH_HopDong)
                        .addComponent(txtMaBDS_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayTao_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenHD_HopDong, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtMaBDS_HopDong)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtNgayTao_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaNV_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit"));

        btnThem_HopDong.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        btnThem_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem_HopDong.setText("Thêm");
        btnThem_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_HopDongActionPerformed(evt);
            }
        });

        btnSua_HopDong.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        btnSua_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnSua_HopDong.setText("Sửa  ");
        btnSua_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HopDongActionPerformed(evt);
            }
        });

        btnXoa_HopDong.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        btnXoa_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa_HopDong.setText("Xoá  ");
        btnXoa_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HopDongActionPerformed(evt);
            }
        });

        btnMoi_HopDong.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        btnMoi_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnMoi_HopDong.setText("Mới   ");
        btnMoi_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_HopDongActionPerformed(evt);
            }
        });

        btnThoat_HopDong.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        btnThoat_HopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Thoat-removebg-preview.png"))); // NOI18N
        btnThoat_HopDong.setText("Thoát");
        btnThoat_HopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat_HopDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua_HopDong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa_HopDong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat_HopDong))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThem_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua_HopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa_HopDong)
                .addGap(18, 18, 18)
                .addComponent(btnMoi_HopDong)
                .addGap(18, 18, 18)
                .addComponent(btnThoat_HopDong)
                .addContainerGap(54, Short.MAX_VALUE))
        );

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Quản Lý Hợp Đồng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnThoat_HopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat_HopDongActionPerformed
        this.hide();
    }//GEN-LAST:event_btnThoat_HopDongActionPerformed

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
