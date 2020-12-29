package com.mounesh.dao;

import java.util.List;

import com.mounesh.model.BankAccount;

public interface AccountDao {
	
	BankAccount getAccount(int oenerId, long accountId);
	List<BankAccount> getAccounts(int ownerId);
	BankAccount deleteAccount(int ownerId, long accountId);
	BankAccount addAccount(BankAccount account, int OwnerId);
	BankAccount updateAccount(BankAccount account, int OwnerId);

}
