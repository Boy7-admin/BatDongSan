/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiro
 */
public class BatDongSanModify {

    public static KetNoi ketNoi;

    public static List<Data.BatDongSan> filltoTable() {

        List<Data.BatDongSan> bdslist = new ArrayList<>();
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement statement = ketNoi.con.createStatement();
            String sql = "select * from BatDongSan";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Data.BatDongSan batDongSan = new Data.BatDongSan(resultSet.getString("MaBDS"),
                        resultSet.getString("TenBDS"),
                        resultSet.getDouble("GiaBDS"),
                        resultSet.getString("DiaChiBDS"),
                        resultSet.getString("LoaiBDS"),
                        resultSet.getString("MotaBDS"),
                        resultSet.getString("TrangThai"));
                bdslist.add(batDongSan);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bdslist;
    }

    public static void insert(Data.BatDongSan bds) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "insert into batDongSan values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, bds.getMa());
            statement.setString(2, bds.getTen());
            statement.setString(3, String.valueOf(bds.getGia()));
            statement.setString(4, bds.getDiachi());
            statement.setString(5, bds.getLoai());
            statement.setString(6, bds.getMota());
            statement.setString(7, bds.getTrangthai());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Data.BatDongSan bds) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "update BatDongSan set MaBDS = ?, TenBDS = ?, GiaBDS = ?, DiaChiBDS = ?, LoaiBDS = ?, MotaBDS = ?, TrangThai = ? where MaBDS = ?";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, bds.getMa());
            statement.setString(2, bds.getTen());
            statement.setString(3, String.valueOf(bds.getGia()));
            statement.setString(4, bds.getDiachi());
            statement.setString(5, bds.getLoai());
            statement.setString(6, bds.getMota());
            statement.setString(7, bds.getTrangthai());
            statement.setString(8, bds.getMa());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String ma) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "delete from BatDongSan where MaBDS = ?";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, ma);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BatDongSanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
