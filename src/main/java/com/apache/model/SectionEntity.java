package com.apache.model;

import javax.persistence.*;

/**
 * Created by shy on 2016/12/17.
 */
@Entity
@Table(name = "section", schema = "", catalog = "leaving")
public class SectionEntity {
    private String sectionId;
    private String sectionName;
    private String sectionManagerId;
    private String sectionManagerName;

    @Id
    @Column(name = "Section_Id", nullable = false, insertable = true, updatable = true, length = 1)
    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "Section_Name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Basic
    @Column(name = "Section_Manager_Id", nullable = false, insertable = true, updatable = true, length = 6)
    public String getSectionManagerId() {
        return sectionManagerId;
    }

    public void setSectionManagerId(String sectionManagerId) {
        this.sectionManagerId = sectionManagerId;
    }

    @Basic
    @Column(name = "Section_Manager_Name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getSectionManagerName() {
        return sectionManagerName;
    }

    public void setSectionManagerName(String sectionManagerName) {
        this.sectionManagerName = sectionManagerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionEntity that = (SectionEntity) o;

        if (sectionId != null ? !sectionId.equals(that.sectionId) : that.sectionId != null) return false;
        if (sectionManagerId != null ? !sectionManagerId.equals(that.sectionManagerId) : that.sectionManagerId != null)
            return false;
        if (sectionManagerName != null ? !sectionManagerName.equals(that.sectionManagerName) : that.sectionManagerName != null)
            return false;
        if (sectionName != null ? !sectionName.equals(that.sectionName) : that.sectionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sectionId != null ? sectionId.hashCode() : 0;
        result = 31 * result + (sectionName != null ? sectionName.hashCode() : 0);
        result = 31 * result + (sectionManagerId != null ? sectionManagerId.hashCode() : 0);
        result = 31 * result + (sectionManagerName != null ? sectionManagerName.hashCode() : 0);
        return result;
    }
}
