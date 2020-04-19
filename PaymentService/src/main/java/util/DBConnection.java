package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {

    }

    public static Connection connect() throws SQLException, ClassNotFoundException {

        if (connection == null || connection.isClosed()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // DBServer, DBName, username and password
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "");

        }
        return connection;

    }

}
