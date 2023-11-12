package uri.software.products.gui;

import uri.software.products.controllers.ProductsController;
import uri.software.products.repository.ProductsRepository;

import javax.swing.*;

public class ProductRegisterForm {
    private JPanel mainPanel;
    private JTextField name;
    private JTextField description;
    private JTextField category;
    private JTextField unitaryValue;
    private JComboBox<String> unitOfMeasurement;
    private JButton registerButton;
    private final ProductsController productsController;

    public ProductRegisterForm() {
        this.setUnitsOfMeasurement();
        this.onButtonClick();

        this.productsController =
                new ProductsController(new ProductsRepository());
    }

    private void onButtonClick() {
        this.registerButton.addActionListener(e -> {
            String nameText = name.getText();
            String descriptionText = description.getText();
            String categoryText = category.getText();
            String unitaryValueText = unitaryValue.getText();
            String unitSelected = (String) unitOfMeasurement.getSelectedItem();

            this.productsController.create(nameText, descriptionText,
                     Float.parseFloat(unitaryValueText), unitSelected,
                    Integer.parseInt(categoryText));
        });
    }

    private void setUnitsOfMeasurement() {
        String[] units = {
                "Unidade (UN)",
                "Quilogramas (KG)",
                "Gramas (G)",
                "Metros (M)",
                "Litros (L)",
                "Mililitros (ML)"
        };

        for (String unit : units) {
            unitOfMeasurement.addItem(unit);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
