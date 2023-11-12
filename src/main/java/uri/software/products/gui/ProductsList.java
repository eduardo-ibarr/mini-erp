package uri.software.products.gui;

import uri.software.products.controllers.ProductsController;
import uri.software.products.models.Product;
import uri.software.products.models.ProductTableModel;
import uri.software.products.repository.ProductsRepository;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class ProductsList {
    private JTable productsTable;
    private JPanel mainPanel;
    private final ProductsController productsController;

    public ProductsList() {
        this.productsController =
                new ProductsController(new ProductsRepository());
        List<Product> products = getProductList();
        ProductTableModel model = new ProductTableModel(products);

        productsTable.setModel(model);
    }

    private List<Product> getProductList() {
        return this.productsController.list();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateTableData() {
        List<Product> products = getProductList();
        ProductTableModel model = new ProductTableModel(products);
        productsTable.setModel(model);
    }

}
