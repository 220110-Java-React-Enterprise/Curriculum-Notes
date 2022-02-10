package com.revature.springbootdemo.beans.entities;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column
    private Double balance;

    @Column
    private String accountType;

    public Account() {
    }

    public Account(Double balance, String accountType) {
        this.balance = balance;
        this.accountType = accountType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountModelId) {
        this.accountId = accountModelId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
