package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Users")
public class User {
    
    /** Идендификатор пользователя. */
    @DatabaseField(generatedId = true)
    private long id;
    
    /** Имя пользователя. */
    @DatabaseField(unique = true)
    private String username;
    
    /** Пароль пользователя. */
    @DatabaseField
    private String password;
    
    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return this.username;
    }
    
}
