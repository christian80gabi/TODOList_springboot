package com.projects.TODOList_springboot.steps;

import com.projects.TODOList_springboot.shared.AuditableBase;
import com.projects.TODOList_springboot.tasks.TODOTask;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
public class TODOStep extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private TODOTask task;
    private String value;
    private boolean isDone;
    private Date deletedDate;

    /* CONSTRUCTORS */

    public TODOStep() {
        this.deletedDate = null;
    }

    public TODOStep(TODOTask task, String value, boolean isDone) {
        this.task = task;
        this.value = value;
        this.isDone = isDone;
        this.deletedDate = null;
    }

    public TODOStep(long id, TODOTask task, String value, boolean isDone, Date deletedDate) {
        this.id = id;
        this.task = task;
        this.value = value;
        this.isDone = isDone;
        this.deletedDate = deletedDate;
    }

    /* GETTERS AND SETTERS */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TODOTask getTask() {
        return task;
    }

    public void setTask(TODOTask task) {
        this.task = task;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public String toString() {
        return "TODOStep{" +
                "id=" + id +
                ", task=" + task +
                ", value='" + value + '\'' +
                ", isDone=" + isDone +
                ", deletedDate=" + deletedDate +
                '}';
    }
}
