package com.projects.TODOList_springboot.notes;

import com.projects.TODOList_springboot.shared.AuditableBase;
import com.projects.TODOList_springboot.shared.ObjectType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class TODONote extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long objectId;
    private ObjectType objectType;
    private String value;
    private Date deletedDate;

    /* CONSTRUCTORS */

    public TODONote() {
        this.deletedDate = null;
    }

    public TODONote(Long objectId, ObjectType objectType, String value) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
        this.deletedDate = null;
    }

    public TODONote(Long id, Long objectId, ObjectType objectType, String value, Date deletedDate) {
        this.id = id;
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
        this.deletedDate = deletedDate;
    }

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public String toString() {
        return "TODONote{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", objectType=" + objectType +
                ", value='" + value + '\'' +
                ", deletedDate=" + deletedDate +
                '}';
    }
}
