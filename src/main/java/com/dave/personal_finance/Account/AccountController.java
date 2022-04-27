package com.dave.personal_finance.Account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/account")
public class AccountController {
    
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    /**
     * Return all accounts
     * 
     * @return
     */
    @GetMapping(path = "get-all")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    /**
     * Register a new account
     * 
     * @param account
     * @return
     */
    @PostMapping(path = "insert")
    public ResponseEntity<Account> insertAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.insertAccount(account));
    }

    /**
     * Update account by id
     * 
     * @param id
     * @param name
     * @param account_type_id
     * @return
     */
    @PutMapping(path = "{accountId}")
    public ResponseEntity<Account> updateAccount(
        @PathVariable("accountId") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long account_type_id
    ){
        return ResponseEntity.ok(accountService.updateAccount(id,name,account_type_id));
    }

    /**
     * Delete account
     * 
     * @param id
     */
    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long id){
        accountService.deleteAccount(id);
    }
}
