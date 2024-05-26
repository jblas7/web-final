package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MotorSQL {
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;

    private static final String URL  = "jdbc:oracle:thin:@database-1.cl4so6ecolo7.us-east-1.rds.amazonaws.com:1521:orcl";
    private static final String USER  = "admin";
    private static final String PASSWORD  = "123456789";

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public void connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }






    public ResultSet executeQuery(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }

    public int executeUpdate(String sql, Integer id) {
        int iResults = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            iResults = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return iResults;
    }

    public void disconnect() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException sqlEx) {
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
