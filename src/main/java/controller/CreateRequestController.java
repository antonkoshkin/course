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
import view.CreateRequestFrame;
import view.MainMenuFrame;


public class CreateRequestController implements ActionListener {
    
    private DBHelper db;
    
    private CreateRequestFrame frame;
    
    public CreateRequestController(CreateRequestFrame f) {
        this.frame = f;
        try {
            this.db = new DBHelper();
            addItemsToComboBox(frame.getCbInstitutes(), db.getAllInstitutes());
            addItemsToComboBox(frame.getCbReasons(), db.getAllReasons());
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
        if (actionName.equals("agreement")) {
            if (frame.isAgreementSelected()) {
                frame.setSendButtonEnabled(true);
            }
            else {
                frame.setSendButtonEnabled(false);
            }
        }
        else if (actionName.equals("sendRequest")) {
            if (frame.isAnyEmpty()) {
                String text = ""
                        + "<html>"
                        + "Заявка не отправлена: заполните все поля."
                        + "</html>";
                JOptionPane.showMessageDialog(null, text, "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                Request r = getRequest();
                try {
                    db.addRequest(r);
                    frame.clearFields();
                    String text = ""
                            + "<html>"
                            + "Заявление успешно отправлена."
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Сообщение",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    String text = ""
                            + "<html>"
                            + "Заявление не отправлено: неизвестная ошибка."
                            + ex.getMessage()
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if (actionName.equals("instituteChanged")) {
            Institute i = (Institute) frame.getCbInstitutes().getSelectedItem();
            frame.clearCbGroup();
            if (i != null) {
                try {
                    List l = db.getGroupsByInstituteId(i.getId());
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
        else if (actionName.equals("cancel")) {
            this.frame.close();
            new MainMenuFrame();
        }
    }
    
    private Request getRequest() {
        return new Request(frame.getTxtName().getText(),
                frame.getTxtPhoneNumber().getText(),
                (Institute) frame.getCbInstitutes().getSelectedItem(),
                (Group) frame.getCbGroup().getSelectedItem(),
                Integer.valueOf(frame.getTxtPassportSeries().getText()),
                Integer.valueOf(frame.getTxtPassportNumber().getText()),
                frame.getTxtPassportIssued().getText(),
                frame.getTxtPassportIssuedDate().getText(),
                (Reason) frame.getCbReasons().getSelectedItem());
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
    
}
