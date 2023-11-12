package uri.software.products.gui;

import javax.swing.*;

public class ProductsMenu {
    private JFrame parentFrame;
    ProductRegisterForm registerForm;
    ProductsList listProducts;

    public ProductsMenu(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.registerForm = new ProductRegisterForm();
        this.listProducts = new ProductsList();
    }

    public JMenu render() {
        JMenu productsMenu = new JMenu("Produtos");

        JMenuItem registerProduct = new JMenuItem("Cadastro de Produto");
        JMenuItem searchProduct = new JMenuItem("Consulta de Produtos");

        registerProduct.addActionListener(e -> {
            JDialog createProductDialog = new JDialog(parentFrame, "Cadastrar" +
                    " um novo Produto", true);
            createProductDialog.setSize(600, 300);
            createProductDialog.setLocationRelativeTo(parentFrame);
            createProductDialog.add(registerForm.getMainPanel());
            createProductDialog.setVisible(true);
        });

        searchProduct.addActionListener(e -> {
            JDialog searchProductDialog = new JDialog(parentFrame, "Lista de " +
                    "Produtos", true);
            searchProductDialog.setSize(1100, 550);
            searchProductDialog.setLocationRelativeTo(parentFrame);
            searchProductDialog.add(listProducts.getMainPanel());
            listProducts.updateTableData();
            searchProductDialog.setVisible(true);
        });

        productsMenu.add(registerProduct);
        productsMenu.add(searchProduct);

        return productsMenu;
    }

}
