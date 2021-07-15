package np.edu.cite.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection conn;

    public Connection open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false", "root", "root");
        return conn;
    }

    public void close() throws SQLException {
        if(conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

}
