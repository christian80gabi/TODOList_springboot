package com.projects.TODOList_springboot.groups;

import com.projects.TODOList_springboot.lists.TODOList;
import com.projects.TODOList_springboot.shared.AuditableBase;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class TODOGroup extends AuditableBase {
    /* ATTRIBUTES */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @Lob  //BLOB (Binary data)
    private Byte[] icon;
    private Date deletedDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "todo_group_id")
    private Set<TODOList> lists = new LinkedHashSet<>();

    /* CONSTRUCTORS */

    public TODOGroup() {
        this.deletedDate = null;
    }

    public TODOGroup(String value, Byte[] icon) {
        this.value = value;
        this.icon = icon;
        this.deletedDate = null;
    }

    public TODOGroup(Long id, String value, Byte[] icon, Date deletedDate, Set<TODOList> lists) {
        this.id = id;
        this.value = value;
        this.icon = icon;
        this.deletedDate = deletedDate;
        this.lists = lists;
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

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Set<TODOList> getLists() {
        return lists;
    }

    public void setLists(Set<TODOList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "TODOGroup{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", icon=" + Arrays.toString(icon) +
                ", deletedDate=" + deletedDate +
                ", lists=" + lists +
                '}';
    }
}
