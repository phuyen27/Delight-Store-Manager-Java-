/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author USER
 */
public class DatabaseHelper {

    public static Connection connect() {
        String server = "UYENBABY2K4\\SQLEXPRESS";
        String user = "sa";
        String password = "123";
        String db = "ManagerDelight";
        int port = 49869;

        // Cấu hình kết nối
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setEncrypt(false); 

        Connection conn = null;
        try {
            conn = ds.getConnection();
            System.out.println("Kết nối với SQL Server thành công!");
            System.out.println(conn.getCatalog());  // In ra tên cơ sở dữ liệu
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;  // Trả về kết nối cho các thao tác khác
    }
}

