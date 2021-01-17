package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Reasons")
public class Reason {
    
    @DatabaseField(generatedId = true)
    private long id;
    
    @DatabaseField
    private String name;
    
    public Reason(){
    }
    
    public Reason(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public boolean equals(Reason r) {
        return this.name.equals(r.getName());
    }
}
