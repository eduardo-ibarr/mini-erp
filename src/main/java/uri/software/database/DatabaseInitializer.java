package uri.software.database;

import java.sql.*;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection connection = SQLite.connect()) {
            createCategoriesTable(connection);
            createProductsTable(connection);
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }

    private static void createProductsTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql =
                "CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "description TEXT NOT NULL," +
                    "unit TEXT NOT NULL," +
                    "value FLOAT NOT NULL," +
                    "category_id INTEGER NOT NULL," +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY (category_id) REFERENCES categories(id)" +
                ")";

            statement.execute(sql);
        }
    }

    private static void createCategoriesTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql =
                "CREATE TABLE IF NOT EXISTS categories (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "created_at TEXT NOT NULL" +
                ")";

            statement.execute(sql);
        }
    }
}
