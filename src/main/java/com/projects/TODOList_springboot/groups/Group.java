package com.projects.TODOList_springboot.groups;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table
public class Group {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @Lob  //BLOB (Binary data)
    private Byte[] icon;
    private Date create_date;
    private Date update_date;
    private Date delete_date;

    /* CONSTRUCTORS */

    public Group() {
        this.create_date = null;
        this.update_date = null;
        this.delete_date = null;
    }

    public Group(String value, Byte[] icon) {
        this.value = value;
        this.icon = icon;
        this.create_date = null;
        this.update_date = null;
        this.delete_date = null;
    }

    public Group(Long id, String value, Byte[] icon, Date create_date, Date update_date, Date delete_date) {
        this.id = id;
        this.value = value;
        this.icon = icon;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Byte[] getIcon() {
        return icon;
    }

    public void setIcon(Byte[] icon) {
        this.icon = icon;
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
        return "Group{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", icon=" + Arrays.toString(icon) +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", delete_date=" + delete_date +
                '}';
    }
}
