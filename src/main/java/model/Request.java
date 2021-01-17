package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Requests")
public class Request {
    
    /** Идендификатор заявления. */
    @DatabaseField(generatedId = true)
    private long id;
    
    /** ФИО студента. */
    @DatabaseField
    private String name;
    
    /** Номер телефона студента. */
    @DatabaseField
    private String phoneNumber;
    
    /** Институт студента. */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Institute institute;
    
    /** Группа студента. */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Group group;
    
    /** Серия паспорта студента. */
    @DatabaseField(unique = true)
    private int passportSeries;
    
    /** Номер паспорта студента. */
    @DatabaseField(unique = true)
    private int passportNumber;
    
    /** Кем выдан паспорт студента. */
    @DatabaseField
    private String passportIssued;
    
    /** Дата выдачи паспорта студента. */
    @DatabaseField
    private String passportDate;
    
    /** Причина заявления. */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Reason reason;
    
    public Request() {
    }
    
    public Request(String name,
            String phoneNumber,
            Institute institute,
            Group group,
            int passpoerSeries,
            int passportNumber,
            String passportIssued,
            String passportIssuedDate,
            Reason reason) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.institute = institute;
        this.group = group;
        this.passportSeries = passpoerSeries;
        this.passportNumber = passportNumber;
        this.passportIssued = passportIssued;
        this.passportDate = passportIssuedDate;
        this.reason = reason;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssued() {
        return passportIssued;
    }

    public void setPassportIssued(String passportIssued) {
        this.passportIssued = passportIssued;
    }

    public String getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(String passportDate) {
        this.passportDate = passportDate;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
    
}
