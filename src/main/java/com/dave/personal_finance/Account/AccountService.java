package com.dave.personal_finance.Account;

import java.util.List;

import com.dave.personal_finance.AccountType.AccountType;
import com.dave.personal_finance.AccountType.AccountTypeRepository;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    private AccountRepository accountRepository;
    private AccountTypeRepository accountTypeRepository;

    public AccountService(AccountRepository accountRepository, AccountTypeRepository accountTypeRepository){
        this.accountRepository = accountRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account insertAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, String name, Long account_type_id){
        AccountType accountType = accountTypeRepository.findById(account_type_id)
        .orElseThrow(() -> new IllegalStateException("Account Type not found"));
        Account account = accountRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Account not found"));
        if(name != null)
            account.setName(name);
        if(accountType != null)
            account.setAccountType(accountType);
        return account;
    }

    public void deleteAccount(Long id){
        accountRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Account not found"));
        accountRepository.deleteById(id);
    }
}
