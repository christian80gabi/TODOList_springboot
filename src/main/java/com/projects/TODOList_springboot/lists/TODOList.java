package com.projects.TODOList_springboot.lists;

import com.projects.TODOList_springboot.groups.TODOGroup;
import com.projects.TODOList_springboot.shared.AuditableBase;
import com.projects.TODOList_springboot.tasks.TODOTask;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class TODOList extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(nullable=true)
    private TODOGroup group;
    private String value;
    private Date deletedDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "todo_list_id")
    private Set<TODOTask> tasks = new LinkedHashSet<>();

    /* CONSTRUCTORS */

    public TODOList() {
        this.deletedDate = null;
    }

    public TODOList(TODOGroup group, String value) {
        this.group = group;
        this.value = value;
        this.deletedDate = null;
    }

    public TODOList(long id, TODOGroup group, String value, Date deletedDate, Set<TODOTask> tasks) {
        this.id = id;
        this.group = group;
        this.value = value;
        this.deletedDate = deletedDate;
        this.tasks = tasks;
    }


    /* GETTERS AND SETTERS */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TODOGroup getGroup() {
        return group;
    }

    public void setGroup(TODOGroup group) {
        this.group = group;
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

    public Set<TODOTask> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TODOTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TODOList{" +
                "id=" + id +
                ", group=" + group +
                ", value='" + value + '\'' +
                ", deletedDate=" + deletedDate +
                ", tasks=" + tasks +
                '}';
    }
}
