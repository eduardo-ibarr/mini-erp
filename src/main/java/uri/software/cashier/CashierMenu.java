package uri.software.cashier;

import uri.software.products.gui.ProductsMenu;

import javax.swing.*;

public class CashierMenu {
    JFrame frame;

    public CashierMenu(JFrame frame) {
        this.frame = frame;
    }

    public JMenu render() {
        JMenu cashierMenu = new JMenu("Caixa");

        JMenuItem openCashier = new JMenuItem("Abertura de Caixa");
        JMenuItem closeCashier = new JMenuItem("Fechamento de Caixa");
        JMenuItem salesRegistry = new JMenuItem("Registro de Compras");

        cashierMenu.add(openCashier);
        cashierMenu.add(closeCashier);
        cashierMenu.add(salesRegistry);

        return cashierMenu;
    }
}
