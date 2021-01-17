package main;

import model.DBHelper;
import model.Institute;
import model.Group;
import model.Reason;
import java.sql.SQLException;
import model.User;
import view.MainMenuFrame;
import view.RequestsTable;

public class Main {
    
    public static void main(String[] args) {
        new MainMenuFrame();
    }
    
    private static void mock(DBHelper dbHelper) throws SQLException {
        Institute i = new Institute("Институт информационных технологий и анализа данных");
        dbHelper.addInstitute(i);
        Group g = new Group("ИСТб-18-2", i);
        dbHelper.addGroup(g);
        g = new Group("ЭВМб-17-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт высоких технологий");
        dbHelper.addInstitute(i);
        g = new Group("ХТТбп-18-1", i);
        dbHelper.addGroup(g);
        g = new Group("ФХм-20-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт недропользования");
        dbHelper.addInstitute(i);
        g = new Group("ТХб-20-3", i);
        dbHelper.addGroup(g);
        g = new Group("ГМ-16-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт экономики, управления и права");
        dbHelper.addInstitute(i);
        g = new Group("ЮРУб-20-2", i);
        dbHelper.addGroup(g);
        g = new Group("ЭПОб-18-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт архитектуры, строительства и дизайна");
        dbHelper.addInstitute(i);
        g = new Group("ЭУНб-19-1", i);
        dbHelper.addGroup(g);
        g = new Group("АДб-17-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт авиамашиностроения и транспорта");
        dbHelper.addInstitute(i);
        g = new Group("СМ-18-1", i);
        dbHelper.addGroup(g);
        g = new Group("СДМ-16-1", i);
        dbHelper.addGroup(g);
        i = new Institute("Институт энергетики");
        dbHelper.addInstitute(i);
        g = new Group("ЭСТб-18-1", i);
        dbHelper.addGroup(g);
        g = new Group("ЭСб-19-2", i);
        dbHelper.addGroup(g);
        
        Reason r = new Reason("Тяжелое материальное положение");
        dbHelper.addReason(r);
        r = new Reason("Дорогостоящее лечение");
        dbHelper.addReason(r);
        r = new Reason("Рождение ребенка");
        dbHelper.addReason(r);
        r = new Reason("Заключение брака");
        dbHelper.addReason(r);
        r = new Reason("Экстренная ситуация");
        dbHelper.addReason(r);
        r = new Reason("Смерть близкого родственника");
        dbHelper.addReason(r);
        
        User u = new User("admin", "admin");
        dbHelper.addUser(u);
    }
    
}