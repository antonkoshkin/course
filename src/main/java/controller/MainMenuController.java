package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CreateRequestFrame;
import view.LoginFrame;
import view.MainMenuFrame;


public class MainMenuController implements ActionListener {
    
    private MainMenuFrame mainMenu;
    
    public MainMenuController(MainMenuFrame mainMenu) {
        this.mainMenu = mainMenu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand();
        if (actionName.equals("login")) {
            mainMenu.close();
            new LoginFrame();
        }
        else if (actionName.equals("createRequest")) {
            mainMenu.close();
            new CreateRequestFrame();
        }
        else if (actionName.equals("exit")) {
            mainMenu.close();
        }
    }
}
