package com.projects.TODOList_springboot.lists;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class List {

      /* ATTRIBUTES */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;
    private boolean status;

    
    @Lob  //BLOB (Binary data)
    private Date create_date;
    private Date update_date;
    private Date delete_date; 

     /* CONSTRUCTORS */
    
    public List() {
        this.create_date = null;
        this.update_date = null;
        this.delete_date = null;
    }
    
    public List(long id, String value, boolean status, Date create_date, Date update_date, Date delete_date) {
        this.id = id;
        this.value = value;
        this.status = status;
        this.create_date = create_date;
        this.update_date = update_date;
        this.delete_date = delete_date;
    }

    public List(String value) {
        this.value = value;
    }

    /* GETTERS AND SETTERS */

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public Date getDelete_date() {
        return delete_date;
    }

    @Override
    public String toString() {
        return "List [create_date=" + create_date + ", delete_date=" + delete_date + ", id=" + id + ", status=" + status
                + ", update_date=" + update_date + ", value=" + value + "]";
    }

  
}
