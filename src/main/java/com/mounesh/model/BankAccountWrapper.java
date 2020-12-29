package com.mounesh.model;

import java.util.List;

public class BankAccountWrapper {
    List<BankAccount> accountList;

    public BankAccountWrapper(){

    }

    public BankAccountWrapper(List<BankAccount> accounts){
        this.accountList = accounts;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }
}
