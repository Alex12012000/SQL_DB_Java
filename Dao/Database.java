package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String jdbcURL = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static String jdbcUtente = "root";
    private static String jdbcPassWord = "@AtonSQL1234";


    public Database() {

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(jdbcURL, jdbcUtente, jdbcPassWord);
        return conn;
    }
}