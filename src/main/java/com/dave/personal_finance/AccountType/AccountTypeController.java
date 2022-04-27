package com.dave.personal_finance.AccountType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "account-type")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    public AccountTypeController(AccountTypeService accountTypeService){
        this.accountTypeService = accountTypeService;
    }

    /**
     * Return all account types
     *
     * @return
     */
    @GetMapping(path = "get-all")
    public ResponseEntity<List<AccountType>> getAccountsType(){
        return ResponseEntity.ok(accountTypeService.getAccountsType());
    }

    /**
     * Return detail account type by id
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "get/{accountTypeId}")
    public ResponseEntity<AccountType> getAccountType(
        @PathVariable("accountTypeId") Long id
    ){
        return ResponseEntity.ok(accountTypeService.getAccountType(id));
    }

    @PostMapping(path = "insert")
    public ResponseEntity<AccountType> insertAccount(@RequestBody AccountType account){
        return ResponseEntity.ok(accountTypeService.insertAccountType(account));
    }

    /**
     * Update  account type
     * 
     * @param id
     * @param name
     * @return
     */
    @PutMapping(path = "{accountTypeId}")
    public ResponseEntity<AccountType> updateAccountType(
        @PathVariable("accountTypeId") Long id,
        @RequestParam(required = false) String name
    ){
        return ResponseEntity.ok(accountTypeService.updateAccountType(id,name));
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
