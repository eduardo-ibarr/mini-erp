package uri.software;

import uri.software.enums.UserRole;
import uri.software.menu.MenuBar;

import javax.swing.*;

public class MainContent {
    public void render() {
        JFrame frame = new JFrame("Mini ERP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        MenuBar menuBar = new MenuBar(frame);

        frame.setJMenuBar(menuBar.createMenuBar(UserRole.ADMIN));
        frame.setVisible(true);
    }
}
