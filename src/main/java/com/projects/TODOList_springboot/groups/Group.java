package com.projects.TODOList_springboot.groups;

import com.projects.TODOList_springboot.shared.AuditableBase;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "list_group")
public class Group extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @Lob  //BLOB (Binary data)
    private Byte[] icon;
    private Date deleted_date;

    /* CONSTRUCTORS */

    public Group() {
    }

    public Group(String value, Byte[] icon) {
        this.value = value;
        this.icon = icon;
    }

    public Group(Long id, String value, Byte[] icon, Date deleted_date) {
        this.id = id;
        this.value = value;
        this.icon = icon;
        this.deleted_date = deleted_date;
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

    public Date getDeleted_date() {
        return deleted_date;
    }

    public void setDeleted_date(Date deleted_date) {
        this.deleted_date = deleted_date;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", icon=" + Arrays.toString(icon) +
                ", deleted_date=" + deleted_date +
                '}';
    }
}
