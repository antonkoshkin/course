package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Groups")
public class Group {
    
    /** Идендификатор института. */
    @DatabaseField(generatedId = true)
    private long id;
    
    /** Название группы. */
    @DatabaseField(unique = true)
    private String name;
    
    /** Институт группы. */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Institute institute;
    
    public Group() {
    }
    
    public Group(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
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

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public boolean equals(Group g) {
        return this.name.equals(g.getName()) &
                this.institute.equals(g.getInstitute());
    }
    
}
