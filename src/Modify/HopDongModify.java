/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class HopDongModify {

    public static KetNoi ketNoi;

    public static List<Data.HopDong> filltoTable() {
        List<Data.HopDong> hdlist = new ArrayList<>();

        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement statement = ketNoi.con.createStatement();
            String sql = "select * from HopDong";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Data.HopDong hopDong = new Data.HopDong(resultSet.getString("MaHD"),
                        resultSet.getString("TenHD"),
                        resultSet.getString("MaNV"),
                        resultSet.getString("MaKH"),
                        resultSet.getString("MaBDS"),
                        resultSet.getString("NgayTaoHD"));
                hdlist.add(hopDong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hdlist;
    }

    public static void insert(Data.HopDong hd) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "insert into HopDong values (?, ?, ?, ?, ? ,?)";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, hd.getMa());
            statement.setString(2, hd.getTen());
            statement.setString(3, hd.getManv());
            statement.setString(4, hd.getMakh());
            statement.setString(5, hd.getMabds());
            statement.setString(6, hd.getNgaytao());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Data.HopDong hd) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "update HopDong set MaHD = ?, TenHD = ?, MaNV = ?, MaKH = ?, MaBDS = ?, NgayTao = ?";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, hd.getMa());
            statement.setString(2, hd.getTen());
            statement.setString(3, hd.getManv());
            statement.setString(4, hd.getMakh());
            statement.setString(5, hd.getMabds());
            statement.setString(6, hd.getNgaytao());
            statement.setString(7, hd.getMa());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String ma) {
        try {
            ketNoi = new KetNoi();
            ketNoi.ketnoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "delete from HopDong where MaHD = ?";
            PreparedStatement statement = ketNoi.con.prepareCall(sql);
            statement.setString(1, ma);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HopDongModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
