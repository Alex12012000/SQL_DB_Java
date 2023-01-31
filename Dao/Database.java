package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String jdbcURL = "";
    private static String jdbcUtente = "";
    private static String jdbcPassWord = "";


    public Database() {

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(jdbcURL, jdbcUtente, jdbcPassWord);
        return conn;
    }
}