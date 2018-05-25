package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConn implements AutoCloseable {

    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String DB_NAME = "produsedb";
    public Connection conn;

   public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, USERNAME, PASSWORD);
            System.out.println("Database Connection success");
        }
        return conn;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}