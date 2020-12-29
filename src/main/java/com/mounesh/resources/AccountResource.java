package com.mounesh.resources;

import com.mounesh.dao.AccountDao;
import com.mounesh.model.BankAccount;
import com.mounesh.model.BankAccountWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/{employeeId}/accounts")
public class AccountResource {

    @Autowired
    private AccountDao service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping()
    public BankAccountWrapper getAccounts(@PathVariable("employeeId") int ownerId) {
        System.out.println("owner id = " + ownerId);
        System.out.println("Server port ="+serverPort);
        return new BankAccountWrapper(service.getAccounts(ownerId));
    }

    @GetMapping("/{accountId}")
    public BankAccount getAccount(@PathVariable("employeeId") int ownerId, @PathVariable("accountId") long accountId) {
        System.out.println("Server port ="+serverPort);
        return service.getAccount(ownerId, accountId);
    }

    @PostMapping
    public BankAccount addAccount(@PathVariable("employeeId") int employeeId, @RequestBody BankAccount account) {
        return service.addAccount(account, employeeId);
    }

    @PutMapping
    public BankAccount updateAccount(@PathVariable("employeeId") int employeeId, @RequestBody BankAccount account) {
        return service.updateAccount(account, employeeId);
    }

    @DeleteMapping("/{accountId}")
    public BankAccount deleteAccount(@PathVariable("employeeId") int employeeId, @PathVariable("accountId") int accountId) {
        System.out.println("employee id in AccountResource#deleteAccount :" + employeeId + "and " + accountId);
        return service.deleteAccount(employeeId, accountId);
    }
}
