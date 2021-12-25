package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String username = "sqlUser";
    private static final String password = "Passw0rd!";
    private static final String ipAddress = "//localhost/";
    private static final String dbName = "client_schedule";
    private static final String protocol = "jdbc";
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static final String vendorName = ":mysql:";
    private static final String jdbcURL = protocol + vendorName + ipAddress + dbName;
    private static Connection conn = null;


    public static Connection startConnection() {
        System.out.println("Attempting database connection...");
        try {
            Class.forName(MYSQLJDBCDriver);
            conn = (Connection)DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection successful");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void closeConnection () {
        try {
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
