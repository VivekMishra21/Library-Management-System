package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static final String Url = "jdbc:mysql://localhost:3306/Library_Management_System";
    public static final String username = "root";
    public static final String password = "1996";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(Url, username, password);
        } catch (Exception e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
