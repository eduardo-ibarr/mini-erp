package uri.software.products.repository;

import uri.software.database.SQLite;
import uri.software.products.models.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductsRepository {
    public void store(
        String name,
        String description,
        float value,
        String unit,
        Integer category_id
    ) {
        String sql =
            "INSERT INTO products (" +
                "name, " +
                "description, " +
                "value, " +
                "unit, " +
                "category_id" +
            ") VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLite.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setFloat(3, value);
            pstmt.setString(4, unit);
            pstmt.setInt(5, category_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> list() {
        String sql = "SELECT * FROM products";
        ArrayList<Product> products = new ArrayList<>();

        try (Connection conn = SQLite.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setValue(rs.getFloat("value"));
                product.setUnitOfMeasurement(rs.getString("unit"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setCreatedAt(rs.getString("created_at"));

                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }
}
