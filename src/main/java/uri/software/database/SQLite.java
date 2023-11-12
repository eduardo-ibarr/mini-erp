package uri.software.database;

import java.sql.*;

public class SQLite {
    private static final String URL = "jdbc:sqlite:mini_erp.db";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL);

            System.out.println("Conexão com o SQLite estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
