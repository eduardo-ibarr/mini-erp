package uri.software.categories.gui;

import javax.swing.*;

public class CategoriesMenu {
    public JMenu render() {
        JMenu categoriesMenu = new JMenu("Categorias");

        JMenuItem registerCategory = new JMenuItem("Cadastrar");
        JMenuItem searchCategory = new JMenuItem("Consultar");

        categoriesMenu.add(registerCategory);
        categoriesMenu.add(searchCategory);

        registerCategory.addActionListener(e -> {
        });

        searchCategory.addActionListener(e -> {
        });

        return categoriesMenu;
    }
}
