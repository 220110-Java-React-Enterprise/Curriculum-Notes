package com.revature.ToDoSpring.beans.models;

import javax.persistence.*;

@Entity
public class ActionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private boolean completed;
    @Transient
    private Integer transientVariable;
    private Integer maybeTransientVariable;


    public ActionItem() {
    }

    public ActionItem(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getTransientVariable() {
        return transientVariable;
    }

    public void setTransientVariable(Integer transientVariable) {
        this.transientVariable = transientVariable;
    }

    public Integer getMaybeTransientVariable() {
        return maybeTransientVariable;
    }

    public void setMaybeTransientVariable(Integer maybeTransientVariable) {
        this.maybeTransientVariable = maybeTransientVariable;
    }
}
