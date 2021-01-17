package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBHelper;
import model.User;
import view.LoginFrame;
import view.MainMenuFrame;
import view.RequestsTable;


public class LoginController implements ActionListener {
    
    private LoginFrame loginFrame;
    
    private DBHelper db;
    
    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
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
        if (actionName.equals("login")) {
            if (this.loginFrame.isAnyEmpty()) {
                String text = ""
                        + "<html>"
                        + "Вход не произведен:<br>заполните все поля."
                        + "</html>";
                JOptionPane.showMessageDialog(null, text, "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                String username = loginFrame.getUsername();
                String password = loginFrame.getPassword();
                User user = new User(username, password);
                try {
                    User matchingUser = db.getMatchingUser(user);
                    if (matchingUser == null) {
                        String text = ""
                            + "<html>"
                                + "Вход не произведен:<br>неверный логин или пароль."
                                + "</html>";
                        JOptionPane.showMessageDialog(null, text, "Предупреждение",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        this.loginFrame.close();
                        new RequestsTable();
                    }
                } catch (SQLException ex) {
                    String text = ""
                        + "<html>"
                            + "Вход не произведен:<br>заполните все поля."
                            + ex.getMessage()
                            + "</html>";
                    JOptionPane.showMessageDialog(null, text, "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if (actionName.equals("cancel")) {
            this.loginFrame.close();
            new MainMenuFrame();
        }
    }
}
