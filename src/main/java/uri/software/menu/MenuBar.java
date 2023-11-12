package uri.software.menu;

import uri.software.cashier.CashierMenu;
import uri.software.categories.gui.CategoriesMenu;
import uri.software.enums.UserRole;
import uri.software.products.gui.ProductsMenu;

import javax.swing.*;

public class MenuBar {
    JFrame frame;

    public MenuBar(JFrame frame) {
        this.frame = frame;
    }
    public JMenuBar createMenuBar(UserRole userRole) {
        JMenuBar menuBar = new JMenuBar();

        if (userRole == UserRole.ADMIN) {
            menuBar.add(new ProductsMenu(this.frame).render());
            menuBar.add(new CategoriesMenu().render());
        }

        if (userRole == UserRole.CASHIER) {
            menuBar.add(new CashierMenu(this.frame).render());
        }

        this.frame.setJMenuBar(menuBar);
        this.frame.setVisible(true);

        return menuBar;
    }

}
