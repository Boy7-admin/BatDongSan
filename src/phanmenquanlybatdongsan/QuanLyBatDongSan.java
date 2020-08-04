/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmenquanlybatdongsan;

import Data.BatDongSan;
import Data.PicPanel;
import Modify.KetNoi;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shiro
 */
public class QuanLyBatDongSan extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    QuanLyBatDongSan quanLyBatDongSan;
    List<Data.BatDongSan> listBDS = new ArrayList<>();

    /**
     * Creates new form QuanLyBatDongSan
     */
    public QuanLyBatDongSan() {
        initComponents();
        setSize(1000, 540);
        PicPanel pic = new PicPanel("C:\\Users\\admin\\Desktop\\FPT_DaoTao\\img\\bg.jpg");
        pic.setBounds(0, 0, 1000, 700);
        add(pic);
        model = (DefaultTableModel) tbl_BatDongSan.getModel();
        fill();
    }

    private void fill() {
        listBDS = Modify.BatDongSanModify.filltoTable();
        model.setRowCount(0);
        listBDS.forEach((bdse) -> {
            model.addRow(new Object[]{bdse.getMa(), bdse.getTen(), bdse.getGia(), bdse.getDiachi(), bdse.getLoai(), bdse.getMota(), bdse.getTrangthai()});
        });
    }

    public void openBatDongSan() {
        quanLyBatDongSan = new QuanLyBatDongSan();
        quanLyBatDongSan.setVisible(true);
    }

    public void moi() {
        txtMa_BatDongSan.setText("");
        txtTen_BatDongSan.setText("");
        txtGia_BatDongSan.setText("");
        txtDiaChi_BatDongSan.setText("");
        cboLoai_BatDongSan.setSelectedIndex(0);
        txtMoTa_BatDongSan.setText("");
        cboTrangThai_BatDongSan.setSelectedIndex(0);
    }

    public boolean check() {
        
        if (txtMa_BatDongSan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap Ma");
            txtMa_BatDongSan.requestFocus();
            return false;
        }
        for (int i = 0; i < listBDS.size(); i++) {
            if (txtMa_BatDongSan.getText().equalsIgnoreCase(listBDS.get(i).getMa())) {
                JOptionPane.showMessageDialog(this, "Ma BDS da duoc su dung");
                txtMa_BatDongSan.setText("");
                txtMa_BatDongSan.requestFocus();
                return false;
            }
        }
        if (txtTen_BatDongSan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten");
            txtTen_BatDongSan.requestFocus();
            return false;
        }
        if (txtGia_BatDongSan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap gia");
            txtGia_BatDongSan.requestFocus();
            return false;
        }
        try {
            double price = Double.parseDouble(txtGia_BatDongSan.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Gia khong dung dinh dang");
            txtGia_BatDongSan.setText("");
            txtGia_BatDongSan.requestFocus();
            return false;
        }
        if (txtDiaChi_BatDongSan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap dia chi");
            txtDiaChi_BatDongSan.requestFocus();
            return false;
        }
        if (txtMoTa_BatDongSan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap mo ta");
            txtMoTa_BatDongSan.requestFocus();
            return false;
        }
        return true;
    }

    public void them() {
        if (check()) {
            Data.BatDongSan batDongSan = new Data.BatDongSan(txtMa_BatDongSan.getText(),
                    txtTen_BatDongSan.getText(),
                    Double.parseDouble(txtGia_BatDongSan.getText()),
                    txtDiaChi_BatDongSan.getText(),
                    cboLoai_BatDongSan.getSelectedItem().toString(),
                    txtMoTa_BatDongSan.getText(),
                    cboTrangThai_BatDongSan.getSelectedItem().toString());
            Modify.BatDongSanModify.insert(batDongSan);
            fill();
        }
    }

    public void showDetail() {
        int i = tbl_BatDongSan.getSelectedRow();
        if (i >= 0) {
            Data.BatDongSan bds = listBDS.get(i);
            txtMa_BatDongSan.setText(bds.getMa());
            txtTen_BatDongSan.setText(bds.getTen());
            txtGia_BatDongSan.setText(String.valueOf(bds.getGia()));
            txtDiaChi_BatDongSan.setText(bds.getDiachi());
            cboLoai_BatDongSan.setSelectedItem(bds.getLoai());
            txtMoTa_BatDongSan.setText(bds.getMota());
            cboTrangThai_BatDongSan.setSelectedItem(bds.getTrangthai());
        }
    }

    public void xoa() {
        try {
            String macanxoa = JOptionPane.showInputDialog(this, "Nhap ma BDS can xoa: ");
            int a = 0;
            for (int i = 0; i <= listBDS.size(); i++) {
                if (macanxoa.equalsIgnoreCase(listBDS.get(i).getMa())) {
                    a++;
                    int option = JOptionPane.showConfirmDialog(this, "Xoa BDS co ma: " + macanxoa);
                    switch (option) {
                        case 0:
                            Modify.BatDongSanModify.delete(macanxoa);
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
                JOptionPane.showMessageDialog(this, "Khong tim thay BDS co ma: " + macanxoa);
            }
        } catch (java.lang.NullPointerException e) {

        }
    }

    KetNoi ketnoi;
    
    public void sua() {
        ketnoi = new KetNoi();
        try {
            ketnoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyBatDongSan.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int i = tbl_BatDongSan.getSelectedRow();
            listBDS.remove(i);
            BatDongSan batDongSan = new BatDongSan(
                    (String) tbl_BatDongSan.getValueAt(i, 0),
                    (String) tbl_BatDongSan.getValueAt(i, 1),
                    (Double) tbl_BatDongSan.getValueAt(i, 2),
                    (String) tbl_BatDongSan.getValueAt(i, 3),
                    (String) tbl_BatDongSan.getValueAt(i, 4),
                    (String) tbl_BatDongSan.getValueAt(i, 5),
                    (String) tbl_BatDongSan.getValueAt(i, 6));
            if (check()) {
                String ma = txtMa_BatDongSan.getText();
                String ten = txtTen_BatDongSan.getText();
                String gia = txtGia_BatDongSan.getText();
                String diachi = txtDiaChi_BatDongSan.getText();
                String loai = (String) cboLoai_BatDongSan.getSelectedItem();
                String mota = txtMoTa_BatDongSan.getText();
                String trangthai = (String) cboTrangThai_BatDongSan.getSelectedItem();
                listBDS.add(i, new BatDongSan(ma, ten, i, diachi, loai, mota, trangthai));
                String sql = "UPDATE BatDongSan " + "SET MaBDS = N'"+ma.trim()+"',TenBDS = N'"+ten.trim()+"',GiaBDS ='"+gia.trim()+"',DiaChiBDS = N'"+diachi.trim()+"',LoaiBDS = N'"+loai.trim()+"',MoTaBDS = N'"+mota.trim()+"',TrangThai = N'"+trangthai.trim()+"'";
                Statement statement = ketnoi.con.createStatement();
                int a = statement.executeUpdate(sql);
                model.setValueAt(txtMa_BatDongSan.getText(), i, 0);
                model.setValueAt(txtTen_BatDongSan.getText(), i, 1);
                model.setValueAt(txtGia_BatDongSan.getText(), i, 2);
                model.setValueAt(txtDiaChi_BatDongSan.getText(), i, 3);
                model.setValueAt(cboLoai_BatDongSan.getSelectedItem(), i, 4);
                model.setValueAt(txtMoTa_BatDongSan, i, 5);
                model.setValueAt(cboTrangThai_BatDongSan.getSelectedItem(), i, 6);
                JOptionPane.showMessageDialog(this, "Sua thanh cong");
            } else {
                listBDS.add(i, batDongSan);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
//        int i = tbl_BatDongSan.getSelectedRow();
//        if (i >= 0) {
//            if (check()) {
//                BatDongSan bds = listBDS.get(i);
//                try {
//                    bds.setMa(txtMa_BatDongSan.getText());
//                    bds.setTen(txtTen_BatDongSan.getText());
//                    bds.setGia(Double.parseDouble(txtGia_BatDongSan.getText()));
//                    bds.setDiachi(txtDiaChi_BatDongSan.getText());
//                    bds.setLoai((String) cboLoai_BatDongSan.getSelectedItem());
//                    bds.setMota(txtMoTa_BatDongSan.getText());
//                    bds.setTrangthai((String) cboTrangThai_BatDongSan.getSelectedItem());
//                    Modify.BatDongSanModify.update(bds);
//                    fill();
//                    JOptionPane.showMessageDialog(this, "Cap nhat du lieu thanh cong");
//                } catch (HeadlessException | NumberFormatException e) {
//                    JOptionPane.showMessageDialog(this, e);
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Chon Bat Dong San can sua");
//        }
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
        btnThem_BatDongSan = new javax.swing.JButton();
        btnSua_BatDongSan = new javax.swing.JButton();
        btnXoa_BatDongSan = new javax.swing.JButton();
        btnMoi_BatDongSan = new javax.swing.JButton();
        btnThoat_BatDongSan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMa_BatDongSan = new javax.swing.JTextField();
        txtTen_BatDongSan = new javax.swing.JTextField();
        txtGia_BatDongSan = new javax.swing.JTextField();
        txtDiaChi_BatDongSan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboTrangThai_BatDongSan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa_BatDongSan = new javax.swing.JTextArea();
        cboLoai_BatDongSan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_BatDongSan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Quản Lý Bất Động Sản");
        setPreferredSize(new java.awt.Dimension(1000, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit"));

        btnThem_BatDongSan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnThem_BatDongSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem_BatDongSan.setText("Thêm");
        btnThem_BatDongSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_BatDongSanActionPerformed(evt);
            }
        });

        btnSua_BatDongSan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSua_BatDongSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnSua_BatDongSan.setText("Sửa  ");
        btnSua_BatDongSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_BatDongSanActionPerformed(evt);
            }
        });

        btnXoa_BatDongSan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnXoa_BatDongSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa_BatDongSan.setText("Xóa   ");
        btnXoa_BatDongSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_BatDongSanActionPerformed(evt);
            }
        });

        btnMoi_BatDongSan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnMoi_BatDongSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnMoi_BatDongSan.setText("Mới   ");
        btnMoi_BatDongSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_BatDongSanActionPerformed(evt);
            }
        });

        btnThoat_BatDongSan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnThoat_BatDongSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Thoat-removebg-preview.png"))); // NOI18N
        btnThoat_BatDongSan.setText("Thoát");
        btnThoat_BatDongSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat_BatDongSanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem_BatDongSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi_BatDongSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSua_BatDongSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa_BatDongSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                    .addComponent(btnThoat_BatDongSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThem_BatDongSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSua_BatDongSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa_BatDongSan)
                .addGap(18, 18, 18)
                .addComponent(btnMoi_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Bất Động Sản"));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã :");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tên :");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Giá :");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Địa Chỉ :");

        txtMa_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtTen_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtGia_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDiaChi_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Loại :");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Mô Tả :");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Trạng Thái :");

        cboTrangThai_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboTrangThai_BatDongSan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa bán", "Đã bán" }));

        txtMoTa_BatDongSan.setColumns(20);
        txtMoTa_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMoTa_BatDongSan.setRows(5);
        jScrollPane2.setViewportView(txtMoTa_BatDongSan);

        cboLoai_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboLoai_BatDongSan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đất nền", "Biệt thự", "Căn Hộ" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi_BatDongSan)
                    .addComponent(txtTen_BatDongSan)
                    .addComponent(txtMa_BatDongSan)
                    .addComponent(txtGia_BatDongSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTrangThai_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLoai_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboLoai_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTen_BatDongSan)
                                .addGap(30, 30, 30)
                                .addComponent(txtGia_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTrangThai_BatDongSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tbl_BatDongSan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tbl_BatDongSan.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã", "Tên", "Giá", "Địa Chỉ", "Loại", "Mô Tả", "Trạng Thái"
            }
        ));
        tbl_BatDongSan.setRowHeight(30);
        tbl_BatDongSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BatDongSanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_BatDongSan);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Quản Lý Bất Động Sản");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(406, 406, 406))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_BatDongSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BatDongSanMouseClicked
        showDetail();
    }//GEN-LAST:event_tbl_BatDongSanMouseClicked

    private void btnThem_BatDongSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_BatDongSanActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThem_BatDongSanActionPerformed

    private void btnSua_BatDongSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_BatDongSanActionPerformed
        // TODO add your handling code here:
        sua();
    }//GEN-LAST:event_btnSua_BatDongSanActionPerformed

    private void btnMoi_BatDongSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi_BatDongSanActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btnMoi_BatDongSanActionPerformed

    private void btnXoa_BatDongSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_BatDongSanActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btnXoa_BatDongSanActionPerformed

    private void btnThoat_BatDongSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat_BatDongSanActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_btnThoat_BatDongSanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi_BatDongSan;
    private javax.swing.JButton btnSua_BatDongSan;
    private javax.swing.JButton btnThem_BatDongSan;
    private javax.swing.JButton btnThoat_BatDongSan;
    private javax.swing.JButton btnXoa_BatDongSan;
    private javax.swing.JComboBox<String> cboLoai_BatDongSan;
    private javax.swing.JComboBox<String> cboTrangThai_BatDongSan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_BatDongSan;
    private javax.swing.JTextField txtDiaChi_BatDongSan;
    private javax.swing.JTextField txtGia_BatDongSan;
    private javax.swing.JTextField txtMa_BatDongSan;
    private javax.swing.JTextArea txtMoTa_BatDongSan;
    private javax.swing.JTextField txtTen_BatDongSan;
    // End of variables declaration//GEN-END:variables
}
