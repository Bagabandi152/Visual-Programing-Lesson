package com.example.uliraldemo.conn;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * @author Bagaa
 * @project uliral-demo
 * @created 28/05/2022 - 12:02 PM
 * @purpose
 * @definition
 */
public class DbConnectionUtils {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_HOSTNAME = "localhost";
    private static final String DB_NAME = "demo_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    //Connection
    private static Connection conn = null;

    //Connect to DB
    public static void dbConnect() throws SQLException, ClassNotFoundException {

        Class.forName(DB_DRIVER);

        //Connection url
        String connectionURL = "jdbc:mysql://" + DB_HOSTNAME + ":3306/" + DB_NAME;

        conn = DriverManager.getConnection(connectionURL, DB_USER,
                DB_PASSWORD);
    }

    //Close Connection
    public static void dbDisconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
}
