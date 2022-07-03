package com.projects.TODOList_springboot.tasks;

import com.projects.TODOList_springboot.lists.TODOList;
import com.projects.TODOList_springboot.shared.AuditableBase;
import com.projects.TODOList_springboot.steps.TODOStep;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Table
@Entity
public class TODOTask extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn()
    private TODOList list;
    private String value;
    private boolean isDone;
    private Date deletedDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "todo_task_id")
    private Set<TODOStep> steps = new LinkedHashSet<>();

    /* CONSTRUCTORS */

    public TODOTask() {
        this.deletedDate = null;
    }

    public TODOTask(TODOList list, String value, boolean isDone) {
        this.list = list;
        this.value = value;
        this.isDone = isDone;
        this.deletedDate = null;
    }

    public TODOTask(long id, TODOList list, String value, boolean isDone, Date deletedDate, Set<TODOStep> steps) {
        this.id = id;
        this.list = list;
        this.value = value;
        this.isDone = isDone;
        this.deletedDate = deletedDate;
        this.steps = steps;
    }

    /* GETTERS AND SETTERS */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TODOList getList() {
        return list;
    }

    public void setList(TODOList list) {
        this.list = list;
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

    public Set<TODOStep> getSteps() {
        return steps;
    }

    public void setSteps(Set<TODOStep> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "TODOTask{" +
                "id=" + id +
                ", list=" + list +
                ", value='" + value + '\'' +
                ", isDone=" + isDone +
                ", deletedDate=" + deletedDate +
                ", steps=" + steps +
                '}';
    }
}
