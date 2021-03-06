package com.apache.model;

import javax.persistence.*;

/**
 * Created by shy on 2016/12/17.
 */
@Entity
@Table(name = "employee", schema = "", catalog = "leaving")
public class EmployeeEntity {
    private int id;
    private String employId;
    private String password;
    private String name;
    private String phone;
    private String sectionId;
    private String level;
    private int quota;
    private int used;

    @Id
    @Column(name = "Id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Employ_Id", nullable = false, insertable = true, updatable = true, length = 6)
    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    @Basic
    @Column(name = "Password", nullable = false, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Phone", nullable = false, insertable = true, updatable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Section_Id", nullable = false, insertable = true, updatable = true, length = 1)
    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "Level", nullable = false, insertable = true, updatable = true, length = 1)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "Quota", nullable = false, insertable = true, updatable = true)
    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    @Basic
    @Column(name = "Used", nullable = false, insertable = true, updatable = true)
    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (quota != that.quota) return false;
        if (used != that.used) return false;
        if (employId != null ? !employId.equals(that.employId) : that.employId != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (sectionId != null ? !sectionId.equals(that.sectionId) : that.sectionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employId != null ? employId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sectionId != null ? sectionId.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + quota;
        result = 31 * result + used;
        return result;
    }
}
