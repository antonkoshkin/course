package graphics;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/** Класс элемента меню. */
public class MyMenuItem extends JMenuItem {

    public MyMenuItem(String text, ActionListener actionListener, String acitonName) {
        super(text);
        setFont(new Font("Verdana", Font.PLAIN, 11));
        addActionListener(actionListener);
        setActionCommand(acitonName);
    }
}
