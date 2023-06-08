package Database;

import java.sql.*;

public class DatabaseConnection {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://20.89.43.136:5432/postgres";
    private static final String USERNAME = "pbokelompok9";
    private static final String PASSWORD = "password";
    private static Connection connection;

    public DatabaseConnection() {
    }

    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                connection.setAutoCommit(false);
            }
            catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
