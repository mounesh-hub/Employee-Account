package com.mounesh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mounesh.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mounesh.model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountDao {

	@Autowired
	 private JdbcTemplate jdbcTemplateObject;

	private class AccountRowMapper implements RowMapper<BankAccount>
	 {

		@Override
		public BankAccount mapRow(ResultSet resultSet, int arg1) throws SQLException {
			BankAccount account = new BankAccount();
			account.setId(resultSet.getLong(1));
			account.setBankAddress(resultSet.getString(2));
			account.setBankName(resultSet.getString(3));
			return account;
		}
		 
	 }
	 
	 public AccountService()
	 {
	 }

	@Override
	public BankAccount getAccount(int ownerId, long accountId) {
		String query = "select * from employee_account where employee_id = ? and accountnumber=?";
		return jdbcTemplateObject.queryForObject(query, new Object[]{ownerId,accountId}, new AccountRowMapper());
	}

	@Override
	public List<BankAccount> getAccounts(int ownerId) {
		String query = "select * from employee_account where employee_id = ?";
		return jdbcTemplateObject.query(query, new Object[]{ownerId}, new AccountRowMapper());
	}

	@Override
	public BankAccount deleteAccount(int ownerId, long accountId) {
		BankAccount account = getAccount(ownerId, accountId);
		String query = "delete from employee_account where employee_id = ? and accountnumber=?";
		jdbcTemplateObject.update(query, ownerId, accountId);
		return account;
	}

	@Override
	public BankAccount addAccount(BankAccount account, int OwnerId) {
		String query = "insert into employee_account values(?,?,?,?)";
		jdbcTemplateObject.update(query, account.getId(),account.getBankAddress(), account.getBankName(), OwnerId);
		return account;
	}

	@Override
	public BankAccount updateAccount(BankAccount account, int OwnerId) {
		String query = "update employee_account set accountnumber=?, bankaddress=?, bankname=? where employee_id=?";
		jdbcTemplateObject.update(query, account.getId(),account.getBankAddress(), account.getBankName(), OwnerId);
		return account;
	}
	
}
