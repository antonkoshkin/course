package model;

import java.sql.SQLException;


public class RequestsTableModel extends MyTableModel {
    
    public RequestsTableModel() {
        try {
            this.data = new DBHelper().getAllRequests();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public Request getSelectedItem(int rowIndex) {
        return (Request) this.data.get(rowIndex);
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "ФИО";
            case 2:
                return "Номер телефона";
            case 3:
                return "Институт";
            case 4:
                return "Группа";
            case 5:
                return "Серия паспорта";
            case 6:
                return "Номер паспорта";
            case 7:
                return "Кем выдан паспорт";
            case 8:
                return "Дата выдачи паспорта";
            case 9:
                return "Причина заявления";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Request r = (Request) data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return r.getId();
            case 1:
                return r.getName();
            case 2:
                return r.getPhoneNumber();
            case 3:
                return r.getInstitute();
            case 4:
                return r.getGroup();
            case 5:
                return r.getPassportSeries();
            case 6:
                return r.getPassportNumber();
            case 7:
                return r.getPassportIssued();
            case 8:
                return r.getPassportDate();
            case 9:
                return r.getReason();
        }
        return "";
    }
    
}
