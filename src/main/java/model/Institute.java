package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Institutes")
public class Institute {
    
    /** Идендификатор институты. */
    @DatabaseField(generatedId = true)
    private long id;
    
    /** Название института. */
    @DatabaseField(unique = true)
    private String name;
    
    public Institute() {
    }
    
    public Institute(String name) {
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
    
    public boolean equals(Institute i) {
        return this.name.equals(i.getName());
    }
    
}
