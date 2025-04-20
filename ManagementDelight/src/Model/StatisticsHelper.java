/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsHelper {

    // Hàm để lấy tổng số khách hàng
    public static int getTotalCustomers() {
        int totalCustomers = 0;
        String sql = "SELECT COUNT(*) FROM KhachHang";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                totalCustomers = rs.getInt(1); // Lấy kết quả của COUNT(*)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return totalCustomers;
    }
    
     public static int getTotalNV() {
        int totalCustomers = 0;
        String sql = "SELECT COUNT(*) FROM NhanVien";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                totalCustomers = rs.getInt(1); // Lấy kết quả của COUNT(*)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return totalCustomers;
    }
    
    // Hàm để lấy tổng số đơn hàng
    public static int getTotalOrders() {
        int totalOrders = 0;
        String sql = "SELECT COUNT(*) FROM DonDH";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                totalOrders = rs.getInt(1); // Lấy kết quả của COUNT(*)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return totalOrders;
    }
    
     public static int getTotalPhieuNhap() {
        int totalOrders = 0;
        String sql = "SELECT COUNT(*) FROM PhieuNhapHang";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                totalOrders = rs.getInt(1); // Lấy kết quả của COUNT(*)
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return totalOrders;
    }
     
       public static int getTotalOrdersTime(Integer month, Integer year) {
    int totalOrders = 0;
    String sql = "SELECT COUNT(*) FROM DonDH WHERE 1=1";
    if (month != null) sql += " AND MONTH(NgayDat) = ?";
    if (year != null) sql += " AND YEAR(NgayDat) = ?";

    try (Connection conn = DatabaseHelper.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        int paramIndex = 1;
        if (month != null) ps.setInt(paramIndex++, month);
        if (year != null) ps.setInt(paramIndex++, year);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                totalOrders = rs.getInt(1);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return totalOrders;
}

        
     public static int getTotalPhieuNhapTime(Integer month, Integer year) {
    int total = 0;
    String sql = "SELECT COUNT(*) FROM PhieuNhapHang WHERE 1=1";
    if (month != null) sql += " AND MONTH(NgayNhap) = ?";
    if (year != null) sql += " AND YEAR(NgayNhap) = ?";

    try (Connection conn = DatabaseHelper.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        int paramIndex = 1;
        if (month != null) ps.setInt(paramIndex++, month);
        if (year != null) ps.setInt(paramIndex++, year);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt(1);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return total;
}



}