package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class MyTableModel extends AbstractTableModel {
    
    List data;
    
    public abstract Object getSelectedItem(int rowIndex);
    
    @Override
    public abstract int getColumnCount();
    
    @Override
    public abstract String getColumnName(int columnIndex);
    
    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
