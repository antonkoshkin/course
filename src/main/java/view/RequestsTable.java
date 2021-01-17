package view;

import graphics.MyMenuItem;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import controller.RequestTableController;
import javax.swing.ListSelectionModel;
import model.RequestsTableModel;


public class RequestsTable extends JFrame {
    
    /** Ширина окна. */
    private final int WIDTH = 1000;
    
    /** Высота окна. */
    private final int HEIGHT = 450;
    
    /** Таблица заявлений на мат. помощь. */
    private JTable table;
    
    private JMenu mOptions;
    
    public RequestsTable() {
        super("Список институтов");
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        mOptions = new JMenu("Опции");
        mOptions.setFont(new Font("Verdana", Font.PLAIN, 11));
        
        this.table = new JTable();
        RequestTableController controller = new RequestTableController(this);
        MyMenuItem miChange = new MyMenuItem("Изменить запись", controller, "change");
        MyMenuItem miDelete = new MyMenuItem("Удалить запись", controller, "delete");
        MyMenuItem miClose = new MyMenuItem("Закрыть окно", controller, "close");
        
        mOptions.add(miChange);
        mOptions.add(miDelete);
        mOptions.add(new JSeparator());
        mOptions.add(miClose);
        
        menuBar.add(mOptions);
        setJMenuBar(menuBar);
        
        add(new JScrollPane(table));
        
        setEnabled(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    /**
     * Устанавливает TableModel, который предоставляет данные, для таблицы.
     * @param model TableModel
     */
    public void setModel(RequestsTableModel model) {
        this.table.setModel(model);
        this.table.getColumnModel().getColumn(0).setMaxWidth(50);
    }
    
    /**
     * Возвращает индекс выделенной строки.
     * @return 
     */
    public int getSelectedRow() {
        return this.table.getSelectedRow();
    }
    
    public ListSelectionModel getSelectionModel() {
        return this.table.getSelectionModel();
    }
    
    /**
     * Удаляет все компоненты, находящиеся на окне, закрывает само окно и
     * делает видимым родительское окно.
     */
    public void close() {
        this.removeAll();
        this.dispose();
    }
    
}
