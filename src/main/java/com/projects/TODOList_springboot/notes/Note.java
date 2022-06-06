package com.projects.TODOList_springboot.notes;

import com.projects.TODOList_springboot.shared.ObjectType;

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
    private Date create_date;
    private Date update_date;
    private Date delete_date;

    /* CONSTRUCTORS */

    public Note() {
    }

    public Note(int objectId, ObjectType objectType, String value) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
    }

    public Note(Long id, int objectId, ObjectType objectType, String value, Date create_date, Date update_date, Date delete_date) {
        this.id = id;
        this.objectId = objectId;
        this.objectType = objectType;
        this.value = value;
        this.create_date = create_date;
        this.update_date = update_date;
        this.delete_date = delete_date;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", objectType=" + objectType +
                ", value='" + value + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", delete_date=" + delete_date +
                '}';
    }
}
