package uri.software.products.models;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {

    private final String[] columnNames =
    {
        "ID",
        "Nome",
        "Descrição",
        "Valor Unitário",
        "Unidade",
        "Categoria"
    };
    private final List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> product.getId();
            case 1 -> product.getName();
            case 2 -> product.getDescription();
            case 3 -> product.getValue();
            case 4 -> product.getUnitOfMeasurement();
            case 5 -> product.getCategoryId();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
