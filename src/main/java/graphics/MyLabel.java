package graphics;

import java.awt.Font;
import javax.swing.JLabel;

public class MyLabel extends JLabel {
    
    public MyLabel() {
        super();
        setFont(new Font("Verdana", Font.PLAIN, 12));
    }
    
    public MyLabel(String text) {
        super(text);
        setFont(new Font("Verdana", Font.PLAIN, 12));
    }
}
