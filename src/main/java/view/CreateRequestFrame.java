package view;

import graphics.MyButton;
import graphics.MyLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.CreateRequestController;
import graphics.MyCheckBox;


public class CreateRequestFrame extends AbstractRequestFrame {
    
    /** Чекбокс. */
    private MyCheckBox chbAgreement;
    
    public CreateRequestFrame() {
        super("Оформление заявления");
        
        CreateRequestController controller = new CreateRequestController(this);
        
        chbAgreement = new MyCheckBox(
                "Я согласен(сна) на обработку моих персональных данных",
                controller,
                "agreement");
        
        btnSend.addActionListener(controller);
        btnSend.setActionCommand("sendRequest");
        btnSend.setEnabled(false);
        
        btnCancel.addActionListener(controller);
        btnCancel.setActionCommand("cancel");
        
        cbInstitute.addActionListener(controller);
        cbInstitute.setActionCommand("instituteChanged");
        cbInstitute.setSelectedItem(null);
        
        GridBagConstraints c = new GridBagConstraints();
        
        
        c.insets = new Insets(5, 15, 5, 5);
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(chbAgreement, c);
        
        setEnabled(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Метод для формирования маски JFormattedTextField.
     * @param s
     * @return 
     */
    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    public boolean isAgreementSelected() {
        return this.chbAgreement.isSelected();
    }
    
    public void setSendButtonEnabled(boolean enabled) {
        this.btnSend.setEnabled(enabled);
    }
    
    /**
     * Очищает поля после отправки заявления.
     */
    public void clearFields() {
        setTextName("");
        setTextPhoneNumber("");
        setSelectedInstitute(0);
        this.clearCbGroup();
        setTextPassportSeries("");
        setTextPassportNumber("");
        setTextPassportIssued("");
        setTextPassportIssuedDate("");
        setSelectedReason(0);
    }
    
}
