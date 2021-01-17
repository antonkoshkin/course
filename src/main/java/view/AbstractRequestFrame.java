package view;

import controller.CreateRequestController;
import graphics.MyButton;
import graphics.MyCheckBox;
import graphics.MyLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;
import model.Group;
import model.Institute;
import model.Reason;


public abstract class AbstractRequestFrame extends JFrame {
    
    /** Ширина окна. */
    private final int WIDTH = 600;
    
    /** Высота окна. */
    private final int HEIGHT = 450;
    
    /** Метка названия группы. */
    private MyLabel lblGroup;
    
    /** Текстовое поле названия группы. */
    private JComboBox cbGroup;
    
    /** Метка текста ФИО. */
    private MyLabel lblName;
    
    /** Текстовое поле ФИО. */
    private JTextField txtName;
    
    /** Метка серии паспорта. */
    private MyLabel lblPassportSeries;
    
    /** Текстовое поле серии паспорта. */
    private JFormattedTextField txtPassportSeries;
    
    /** Метка номера паспорта. */
    private MyLabel lblPassportNumber;
    
    /** Текстовое поле номера паспорта. */
    private JFormattedTextField txtPassportNumber;
    
    /** Метка "кем выдан" паспорта. */
    private MyLabel lblPassportIssued;
    
    /** Текстовое поле "кем выдан" паспорта. */
    private JTextField txtPassportIssued;
    
    /** Метка даты выдачи паспорта. */
    private MyLabel lblPassportIssuedDate;
    
    /** Текстовое поле даты выдачи паспорта. */
    private JTextField txtPassportIssuedDate;
    
    /** Метка номер телефона. */
    private MyLabel lblPhoneNumber;
    
    /** Текстовое поле номера телефона. */
    private JFormattedTextField txtPhoneNumber;
    
    /** Метка института. */
    private MyLabel lblInstitute;
    
    /** Выпадающий список институтов. */
    JComboBox<String> cbInstitute;
    
    /** Метка причин мат. помощи. */
    private MyLabel lblReason;
    
    /** Выпадающий список причин мат. помощи. */
    private JComboBox<String> cbReason;
    
    /** Кнопка отправки заявления. */
    MyButton btnSend;

    /** Кнопка отмены. */
    MyButton btnCancel;
    
    public AbstractRequestFrame(String text) {
        super(text);
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        
        lblName = new MyLabel("ФИО:");
        txtName = new JTextField();
        
        lblPhoneNumber = new MyLabel("Номер телефона:");
        txtPhoneNumber = new JFormattedTextField(createFormatter("+7 (###) ###-##-##"));
        
        lblInstitute = new MyLabel("Институт:");
        
        lblGroup = new MyLabel("Группа:");
        cbGroup = new JComboBox<>();
        cbGroup.addItem(null);
        
        lblPassportSeries = new MyLabel("Серия паспорта:");
        txtPassportSeries = new JFormattedTextField(createFormatter("####"));
        
        lblPassportNumber = new MyLabel("Номер паспорта:");
        txtPassportNumber = new JFormattedTextField(createFormatter("######"));
        
        lblPassportIssued = new MyLabel("Кем выдан:");
        txtPassportIssued = new JTextField();
        
        lblPassportIssuedDate = new MyLabel("Дата выдачи паспорта:");
        txtPassportIssuedDate = new JTextField();
        
        lblReason = new MyLabel("<html>Причина заявления<br>на материальную помощь:</html>");
        cbReason = new JComboBox<>();
        cbReason.addItem(null);
        
        cbInstitute = new JComboBox<>();
        cbInstitute.addItem(null);
        
        btnSend = new MyButton("Отправить");
        btnCancel = new MyButton("Отмена");
        
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 15, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(lblName, c);
        
        c.gridy = 1;
        add(lblPhoneNumber, c);
        
        c.gridy = 2;
        add(lblInstitute, c);
        
        c.gridy = 3;
        add(lblGroup, c);
        
        c.gridy = 4;
        add(lblPassportSeries, c);
        
        c.gridy = 5;
        add(lblPassportNumber, c);
        
        c.gridy = 6;
        add(lblPassportIssued, c);
        
        c.gridy = 7;
        add(lblPassportIssuedDate, c);
        
        c.gridy = 8;
        add(lblReason, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        add(txtName, c);
        
        c.gridy = 1;
        add(txtPhoneNumber, c);
        
        c.gridy = 2;
        add(cbInstitute, c);
        
        c.gridy = 3;
        add(cbGroup, c);
        
        c.gridy = 4;
        add(txtPassportSeries, c);
        
        c.gridy = 5;
        add(txtPassportNumber, c);
        
        c.gridy = 6;
        add(txtPassportIssued, c);
        
        c.gridy = 7;
        add(txtPassportIssuedDate, c);
        
        c.gridy = 8;
        add(cbReason, c);
        
        c.insets = new Insets(20, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 10;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        add(btnSend, c);
        
        c.gridx = 1;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        add(btnCancel, c);
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
        } catch (java.text.ParseException e) {
            System.err.println("formatter is bad: " + e.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    public boolean isAnyEmpty() {
        return txtName.getText().isEmpty() |
                cbInstitute.getSelectedItem() == null |
                cbGroup.getSelectedItem() == null |
                txtPassportSeries.getText().isEmpty() |
                txtPassportNumber.getText().isEmpty() |
                txtPassportIssued.getText().isEmpty() |
                txtPassportIssuedDate.getText().isEmpty() |
                txtPhoneNumber.getText().isEmpty() |
                cbReason.getSelectedItem() == null;
    }
    
    /**
     * Очищает выпадающий список групп.
     */
    public void clearCbGroup() {
        cbGroup.removeAllItems();
        cbGroup.addItem(null);
    }
    
    /**
     * Закрывает окно.
     */
    public void close() {
        removeAll();
        dispose();
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JFormattedTextField getTxtPassportSeries() {
        return txtPassportSeries;
    }

    public JFormattedTextField getTxtPassportNumber() {
        return txtPassportNumber;
    }

    public JTextField getTxtPassportIssued() {
        return txtPassportIssued;
    }

    public JTextField getTxtPassportIssuedDate() {
        return txtPassportIssuedDate;
    }

    public JFormattedTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public JComboBox<String> getCbInstitutes() {
        return cbInstitute;
    }
    
    public JComboBox getCbGroup() {
        return cbGroup;
    }

    public JComboBox<String> getCbReasons() {
        return cbReason;
    }
    
    void setTextName(String text) {
        this.txtName.setText(text);
    }
    
    void setTextPhoneNumber(String text) {
        this.txtPhoneNumber.setText(text);
    }
    
    public void setSelectedInstitute(int index) {
        this.cbInstitute.setSelectedIndex(index);
    }
    
    public void setSelectedGroup(int index) {
        this.cbGroup.setSelectedIndex(index);
    }
    
    void setTextPassportSeries(String text) {
        this.txtPassportSeries.setText(text);
    }
    
    void setTextPassportNumber(String text) {
        this.txtPassportNumber.setText(text);
    }
    
    void setTextPassportIssued(String text) {
        this.txtPassportIssued.setText(text);
    }
    
    void setTextPassportIssuedDate(String text) {
        this.txtPassportIssuedDate.setText(text);
    }
    
    public void setSelectedReason(int index) {
        this.cbReason.setSelectedIndex(index);
    }
}
