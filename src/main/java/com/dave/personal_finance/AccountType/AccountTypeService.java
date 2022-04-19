package com.dave.personal_finance.AccountType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {
    
    @Autowired
    private AccountTypeRepository accountTypeRepository;


    public AccountType getAccountType(Long id){
        return accountTypeRepository.findById(id)
         .orElseThrow(() -> new IllegalStateException("Account Type not found"));
    }

    public List<AccountType> getAccountsType(){
        return accountTypeRepository.findAll();
    }

    public AccountType insertAccountType(AccountType account){
        return accountTypeRepository.save(account);
    }

    public AccountType updateAccountType(Long id, String name){
        AccountType accountType = accountTypeRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Account Type not found"));
        if(name != null)
            accountType.setName(name);
        return accountType;
    }

    public void deleteAccountType(Long id){
        accountTypeRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Account Type not found"));
        accountTypeRepository.deleteById(id);
    }

}
