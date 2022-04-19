package com.dave.personal_finance.AccountType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "account-type")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @Autowired
    public AccountTypeController(AccountTypeService accountTypeService){
        this.accountTypeService = accountTypeService;
    }

    /**
     * Return detail account type by id
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "get/{accountTypeId}")
    public AccountType getAccountType(
        @PathVariable("accountTypeId") Long id
    ){
        return accountTypeService.getAccountType(id);
    }
    
    /**
     * Return all account types
     * 
     * @return
     */
    @GetMapping(path = "get-all")
    public List<AccountType> getAccountsType(){
        return accountTypeService.getAccountsType();
    }

    @PostMapping(path = "insert")
    public AccountType insertAccount(@RequestBody AccountType account){
        return accountTypeService.insertAccountType(account);
    }

    /**
     * Update  account type
     * 
     * @param id
     * @param name
     * @return
     */
    @PutMapping(path = "{accountTypeId}")
    public AccountType updateAccountType(
        @PathVariable("accountTypeId") Long id,
        @RequestParam(required = false) String name
    ){
        return accountTypeService.updateAccountType(id,name);
    }

    /**
     * Delete account type
     * 
     * @param id
     */
    @DeleteMapping(path = "{accountTypeId}")
    public void deleteAccount(@PathVariable("accountTypeId") Long id){
        accountTypeService.deleteAccountType(id);
    }
}
