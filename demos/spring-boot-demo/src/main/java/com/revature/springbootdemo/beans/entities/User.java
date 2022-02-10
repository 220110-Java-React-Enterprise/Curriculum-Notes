package com.revature.springbootdemo.beans.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userModelId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @OneToMany
    private List<Account> accounts = new LinkedList<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getUserModelId() {
        return userModelId;
    }

    public void setUserModelId(Integer userModelId) {
        this.userModelId = userModelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
