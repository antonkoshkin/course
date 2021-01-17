package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.RequestsTableModel;
import model.Request;
import view.ChangeRequestFrame;
import view.RequestsTable;
import view.MainMenuFrame;


public class RequestTableController implements ActionListener {
    
    private RequestsTable table;
    
    private RequestsTableModel model;
    
    private DBHelper db;
    
    public RequestTableController(RequestsTable t) {
        this.model = new RequestsTableModel();
        this.table = t;
        this.table.setModel(model);
        try {
            this.db = new DBHelper();
        } catch (SQLException e) {
            String text = ""
                    + "<html>"
                    + "Необработанное исключение.<br>"
                    + e.getMessage()
                    + "</html>";
            JOptionPane.showMessageDialog(null, text, "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand();
        if (actionName.equals("change")) {
            if (!table.getSelectionModel().isSelectionEmpty()) {
                changeAction();
            }
        }
        else if (actionName.equals("delete")) {
            if (!table.getSelectionModel().isSelectionEmpty()) {
                deleteAction();
            }
        }
        else if (actionName.equals("close")) {
            this.table.close();
            new MainMenuFrame();
        }
    }

    private void changeAction() {
        Request r = this.model.getSelectedItem(this.table.getSelectedRow()); // получаем объект заявления, который выделен в таблице
        table.setEnabled(false);
        new ChangeRequestFrame(table, r);
    }
    
    private void deleteAction() {
        Request r = this.model.getSelectedItem(this.table.getSelectedRow()); // получаем объект заявления, который выделен в таблице
        try {
            db.deleteRequest(r);
            refreshData();
            String text = ""
                    + "<html>"
                    + "Запись успешно удалена."
                    + "</html>";
            JOptionPane.showMessageDialog(null, text, "Сообщение",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            String text = ""
                    + "<html>"
                    + "Запись не удалена: неизвестная ошибка.<br>"
                    + ex.getMessage()
                    + "</html>";
            JOptionPane.showMessageDialog(null, text, "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Обновляет данные в таблице.
     */
    private void refreshData() {
        this.model = new RequestsTableModel();
        this.table.setModel(model);
    }
    
}
