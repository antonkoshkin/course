package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DBHelper {
    private final String url = "jdbc:sqlite:course.db";
    
    private ConnectionSource connection;
    
    private Dao<Request, Integer> requestDao;
    
    private Dao<Institute, Integer> instituteDao;
    
    private Dao<Group, Integer> groupDao;
    
    private Dao<Reason, Integer> reasonDao;
    
    private Dao<User, Integer> userDao;

    public DBHelper() throws SQLException {
        connection = new JdbcConnectionSource(url);
        setupDatabase(connection);
    }
    
    private void setupDatabase(ConnectionSource connection) throws SQLException {
        requestDao = DaoManager.createDao(connection, Request.class);
        instituteDao = DaoManager.createDao(connection, Institute.class);
        groupDao = DaoManager.createDao(connection, Group.class);
        reasonDao = DaoManager.createDao(connection, Reason.class);
        userDao = DaoManager.createDao(connection, User.class);
        // создание таблиц, если их нет
        TableUtils.createTableIfNotExists(connection, Request.class);
        TableUtils.createTableIfNotExists(connection, Institute.class);
        TableUtils.createTableIfNotExists(connection, Group.class);
        TableUtils.createTableIfNotExists(connection, Reason.class);
        TableUtils.createTableIfNotExists(connection, User.class);
    }
    
    public void addRequest(Request r) throws SQLException {
        requestDao.create(r);
    }
    
    public List<Request> getAllRequests() throws SQLException {
        return requestDao.queryForAll();
    }
    
    public void updateRequest(Request r) throws SQLException {
        requestDao.update(r);
    }
    
    public void deleteRequest(Request r) throws SQLException {
        requestDao.delete(r);
    }
    
    public void addInstitute(Institute institute) throws SQLException {
        instituteDao.create(institute);
    }
    
    public Institute getInstituteByName(String name) throws SQLException {
        return instituteDao.queryForEq("name", name).get(0);
    }

    public List<Institute> getAllInstitutes() throws SQLException {
        return instituteDao.queryForAll();
    }
    
    public void updateInstitute(Institute institute) throws SQLException {
        instituteDao.update(institute);
    }
    
    public void deleteInstitute(Institute institute) throws SQLException {
        instituteDao.delete(institute);
    }
    
    public void addGroup(Group group) throws SQLException {
        groupDao.create(group);
    }
    
    public List<Group> getGroupsByInstituteId(long instituteId) throws SQLException {
        return groupDao.queryForEq("institute_id", instituteId);
    }

    public List<Group> getAllGroups() throws SQLException {
        return groupDao.queryForAll();
    }
    
    public void updateGroup(Group group) throws SQLException {
        groupDao.update(group);
    }
    
    public void deleteGroup(Group group) throws SQLException {
        groupDao.delete(group);
    }
    
    public void addReason(Reason reason) throws SQLException {
        reasonDao.create(reason);
    }

    public List<Reason> getAllReasons() throws SQLException {
        return reasonDao.queryForAll();
    }
    
    public void updateReason(Reason reason) throws SQLException {
        reasonDao.update(reason);
    }
    
    public void deleteReason(Reason reason) throws SQLException {
        reasonDao.delete(reason);
    }
    
    public void addUser(User user) throws SQLException {
        userDao.create(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.queryForAll();
    }
    
    public User getMatchingUser(User user) throws SQLException {
        List<User> users = userDao.queryForMatching(user);
        if (users.isEmpty()){
            return null;
        }
        return users.get(0);
    }
    
    public void updateUser(User user) throws SQLException {
        userDao.update(user);
    }
    
    public void deleteUser(User user) throws SQLException {
        userDao.delete(user);
    }
    
}
