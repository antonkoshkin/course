package graphics;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

public class MyCheckBox extends JCheckBox {
    
    public MyCheckBox(String text, ActionListener actionListener, String actionName) {
        super(text);
        setFont(new Font("Verdana", Font.PLAIN, 12));
        addActionListener(actionListener);
        setActionCommand(actionName);
    }
    
}
