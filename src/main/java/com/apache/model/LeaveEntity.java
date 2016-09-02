package com.apache.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by shy on 2016/9/2.
 */
@Entity
@Table(name = "leave", schema = "", catalog = "leaving")
public class LeaveEntity {
    private int id;
    private int employId;
    private String name;
    private Date startDate;
    private int offDay;
    private int type;
    private String reason;
    private int state;
    private String approver;
    private Date endDate;

    @Id
    @Column(name = "Id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Employ_Id", nullable = false, insertable = true, updatable = true)
    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
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
    @Column(name = "StartDate", nullable = false, insertable = true, updatable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "OffDay", nullable = false, insertable = true, updatable = true)
    public int getOffDay() {
        return offDay;
    }

    public void setOffDay(int offDay) {
        this.offDay = offDay;
    }

    @Basic
    @Column(name = "Type", nullable = false, insertable = true, updatable = true)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Reason", nullable = false, insertable = true, updatable = true, length = 255)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "State", nullable = false, insertable = true, updatable = true)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Approver", nullable = false, insertable = true, updatable = true, length = 255)
    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    @Basic
    @Column(name = "EndDate", nullable = false, insertable = true, updatable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveEntity that = (LeaveEntity) o;

        if (employId != that.employId) return false;
        if (id != that.id) return false;
        if (offDay != that.offDay) return false;
        if (state != that.state) return false;
        if (type != that.type) return false;
        if (approver != null ? !approver.equals(that.approver) : that.approver != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + employId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + offDay;
        result = 31 * result + type;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (approver != null ? approver.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
