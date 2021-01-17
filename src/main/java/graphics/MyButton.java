package graphics;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyButton extends JButton {
    
    public MyButton(String text) {
        super(text);
        setFocusPainted(false);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFont(new Font("Verdana", Font.PLAIN, 12));
    }
    
    public MyButton(String text, ActionListener actionListener, String acitonName) {
        super(text);
        setFocusPainted(false);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFont(new Font("Verdana", Font.PLAIN, 12));
        addActionListener(actionListener);
        setActionCommand(acitonName);
    }
}
