package com.projects.TODOList_springboot.notes;

import com.projects.TODOList_springboot.shared.ObjectType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Note {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int objectId;
    private ObjectType objectType;
    private String value;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_date;
    private Date deleted_date;

    /* CONSTRUCTORS */

    public Note() {
    }

    public Note(int objectId, ObjectType objectType, String value) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
    }

    public Note(Long id, int objectId, ObjectType objectType, String value, Date created_date, Date updated_date, Date deleted_date) {
        this.id = id;
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.deleted_date = deleted_date;
    }

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date create_date) {
        this.created_date = create_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date update_date) {
        this.updated_date = update_date;
    }

    public Date getDeleted_date() {
        return deleted_date;
    }

    public void setDeleted_date(Date delete_date) {
        this.deleted_date = delete_date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", objectType=" + objectType +
                ", value='" + value + '\'' +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", deleted_date=" + deleted_date +
                '}';
    }
}
