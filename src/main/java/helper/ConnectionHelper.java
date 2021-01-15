package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC.JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC.DATABASE_URL, JDBC.USER, JDBC.PASSWORD);
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return connection;
    }
}
