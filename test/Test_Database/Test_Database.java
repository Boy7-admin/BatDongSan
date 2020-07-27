/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiro
 */
public class Test_Database {
    
    Connection conn;
    String hostting = "jdbc:sqlserver://localhost\\DESKTOP-DAR31D1\\SQLEXPRESS:1433;databaseName=QL_BDS";
    String username = "sa";
    String password = "19216811";
    
    private void ketNoi() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(hostting, username, password);
    }
    
    private void loading() throws SQLException {
        String sql = "select * from NhanVien";
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(sql);
        while (true) {
            String manv = rs.getString("MaNV");
            String tennv = rs.getString("TenNV");
            double luongnv = rs.getDouble("LuongNV");
            System.out.println(manv + " " + tennv + " " + luongnv);
        }
    }
    
    public static void main(String[] args) {
        try {
            Test_Database test_Database = new Test_Database();
            test_Database.ketNoi();
            test_Database.loading();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Test_Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error : \n" + ex.getMessage());
        }
    }
    
}
