package uri.software;

import uri.software.database.DatabaseInitializer;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        SwingUtilities.invokeLater(() -> {
            new MainContent().render();
        });
    }
}
