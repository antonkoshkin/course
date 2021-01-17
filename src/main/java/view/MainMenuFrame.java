package view;

import graphics.MyButton;
import javax.swing.JFrame;

import controller.MainMenuController;
import javax.swing.BoxLayout;


public class MainMenuFrame extends JFrame {
    
    /** Ширина окна. */
    private final int WIDTH = 300;
    
    /** Высота окна. */
    private final int HEIGHT = 200;
    
    private MyButton btnLogin;
    
    private MyButton btnCreateRequest;
    
    private MyButton btnExit;
    
    public MainMenuFrame() {
        super("Главное меню");
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        MainMenuController controller = new MainMenuController(this);
        
        btnLogin = new MyButton("Войти как администратор", controller, "login");
        btnCreateRequest = new MyButton("Оформить заявление", controller, "createRequest");
        btnExit = new MyButton("Выход", controller, "exit");
        
        add(btnLogin);
        add(btnCreateRequest);
        add(btnExit);
        
        setEnabled(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void close() {
        removeAll();
        dispose();
    }
    
}
