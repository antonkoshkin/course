package view;

import graphics.MyButton;
import graphics.MyLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.LoginController;

public class LoginFrame extends JFrame {
    
    /** Ширина окна. */
    private final int WIDTH = 300;
    
    /** Высота окна. */
    private final int HEIGHT = 200;
    
    /** Метка логина. */
    private MyLabel lblLogin;
    
    /** Текстовое поле логина. */
    private JTextField txtLogin;
    
    /** Метка текста пароля. */
    private MyLabel lblPassword;
    
    /** Текстовое поле пароля. */
    private JTextField txtPassword;
    
    /** Кнопка принятия веденных данных. */
    private MyButton btnOk;
    
    /** Кнопка отмены авторизации. */
    private MyButton btnCancel;
    
    public LoginFrame() {
        super("Авторизация");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        
        lblLogin = new MyLabel("Логин:");
        txtLogin = new JTextField();
        lblPassword = new MyLabel("Пароль:");
        txtPassword = new JTextField();
        
        LoginController controller = new LoginController(this);
        
        btnOk = new MyButton("Войти", controller, "login");
        btnCancel = new MyButton("Отмена", controller, "cancel");
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 15, 5, 15);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(lblLogin, c);
        
        c.gridy = 1;
        add(lblPassword, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(txtLogin, c);
        
        c.gridy = 1;
        add(txtPassword, c);
        
        c.gridy = 2;
        c.gridwidth = 1;
        add(btnOk, c);
        
        c.gridx = 2;
        add(btnCancel, c);
        
        setEnabled(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    /**
     * Возвращает введенный логин.
     * @return введенный логин.
     */
    public String getUsername() {
        return this.txtLogin.getText();
    }
    
    /**
     * Возвращает введенный пароль.
     * @return введенный пароль
     */
    public String getPassword() {
        return this.txtPassword.getText();
    }
    
    /**
     * Проверяет пусты ли текстовые поля.
     */
    public boolean isAnyEmpty() {
        return txtLogin.getText().isEmpty() | txtPassword.getText().isEmpty();
    }
    
    /**
     * Закрывает окно.
     */
    public void close() {
        this.removeAll();
        this.dispose();
    }
    
}
