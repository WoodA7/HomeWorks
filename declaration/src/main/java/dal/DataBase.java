package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String DB_BASE = "jdbc:mysql://localhost/tax_decl";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "25973";

    public DataBase() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(DB_BASE, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

}
