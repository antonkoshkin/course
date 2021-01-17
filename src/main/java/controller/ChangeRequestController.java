package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.Group;
import model.Institute;
import model.Reason;
import model.Request;
import model.RequestsTableModel;
import view.ChangeRequestFrame;
import view.RequestsTable;


public class ChangeRequestController implements ActionListener {
    
    private DBHelper db;
    
    private ChangeRequestFrame frame;
    
    private RequestsTable tableFrame;
    
    private Request request;
    
    public ChangeRequestController(ChangeRequestFrame f, RequestsTable tableFrame, Request request) {
        this.frame = f;
        this.tableFrame = tableFrame;
        this.request = request;
        try {
            this.db = new DBHelper();
            addItemsToComboBox(frame.getCbInstitutes(), db.getAllInstitutes());
            addItemsToComboBox(frame.getCbReasons(), db.getAllReasons());
            int instituteIndex = findInstituteInComboBox(frame.getCbInstitutes(), this.request.getInstitute());
            int reasonIndex = findReasonInComboBox(frame.getCbReasons(), this.request.getReason());
            frame.setData(request, instituteIndex, reasonIndex);
            fillGroups((Institute) frame.getCbInstitutes().getSelectedItem());
            int groupIndex = findGroupInComboBox(frame.getCbGroup(), this.request.getGroup());
            frame.setSelectedGroup(groupIndex);
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
        if (actionName.equals("changeRequest")) {
            if (frame.isAnyEmpty()) {
                String text = ""
                        + "<html>"
                        + "Заявление не изменено: заполните все поля."
                        + "</html>";
                JOptionPane.showMessageDialog(null, text, "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                getRequest();
                try {
                    db.updateRequest(request);
                    refreshData();
                    String text = ""
                            + "<html>"
                            + "Заявление успешно изменено."
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Сообщение",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    String text = ""
                            + "<html>"
                            + "Заявление не изменено: неизвестная ошибка."
                            + ex.getMessage()
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    frame.close();
                    tableFrame.setEnabled(true);
                }
            }
        }
        else if (actionName.equals("cancel")) {
            frame.close();
            tableFrame.setEnabled(true);
        }
        else if (actionName.equals("instituteChanged")) {
            Institute i = (Institute) frame.getCbInstitutes().getSelectedItem();
            fillGroups(i);
        }
    }
    
    private void fillGroups(Institute institute) {
        frame.clearCbGroup();
        if (institute != null) {
                try {
                    List l = db.getGroupsByInstituteId(institute.getId());
                    addItemsToComboBox(frame.getCbGroup(), l);
                } catch (SQLException ex) {
                    String text = ""
                            + "<html>"
                            + "Не удалось получить список групп."
                            + ex.getMessage()
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
    }
    
    private Request getRequest() {
        request.setName(frame.getTxtName().getText());
        request.setPhoneNumber(frame.getTxtPhoneNumber().getText());
        request.setInstitute((Institute) frame.getCbInstitutes().getSelectedItem());
        request.setGroup((Group) frame.getCbGroup().getSelectedItem());
        request.setPassportSeries(Integer.valueOf(frame.getTxtPassportSeries().getText()));
        request.setPassportNumber(Integer.valueOf(frame.getTxtPassportNumber().getText()));
        request.setPassportIssued(frame.getTxtPassportIssued().getText());
        request.setPassportDate(frame.getTxtPassportIssuedDate().getText());
        request.setReason((Reason) frame.getCbReasons().getSelectedItem());
        return request;
    }
    
    /**
     * Добавляет элементы из списка в выпадающие списки.
     * @param cb
     * @param items 
     */
    private void addItemsToComboBox(JComboBox cb, List items) {
        for (int i = 0; i < items.size(); i++) {
            cb.addItem(items.get(i));
        }
    }
    
    private int findInstituteInComboBox(JComboBox cb, Institute institute) {
        for (int i = 0; i < cb.getItemCount(); i++) {
            Institute item = (Institute) cb.getItemAt(i);
            if (item != null) {
                if (item.equals(institute)) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    private int findGroupInComboBox(JComboBox cb, Group group) {
        for (int i = 0; i < cb.getItemCount(); i++) {
            Group item = (Group) cb.getItemAt(i);
            if (item != null) {
                if (item.equals(group)) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    private int findReasonInComboBox(JComboBox cb, Reason reason) {
        for (int i = 0; i < cb.getItemCount(); i++) {
            Reason item = (Reason) cb.getItemAt(i);
            if (item != null) {
                if (item.equals(reason)) {
                    System.out.println(i);
                    return i;
                }
            }
        }
        return 0;
    }
    
    /**
     * Обновляет данные в таблице.
     */
    private void refreshData() {
        tableFrame.setModel(new RequestsTableModel());
    }
}
