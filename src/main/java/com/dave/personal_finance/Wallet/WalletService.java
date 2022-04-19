package com.dave.personal_finance.Wallet;



import java.util.List;

import com.dave.personal_finance.Account.Account;
import com.dave.personal_finance.Account.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<Wallet> getWalletByAccount(Long id){
        return walletRepository.findByAccountId(id);
    }

    public Wallet insertWallet(Wallet wallet){
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Long Id, Long accountId, String name){
        Wallet wallet = walletRepository.findById(Id)
        .orElseThrow(() -> new IllegalStateException("Wallet not found"));
        if(accountId != null){
            Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalStateException("Account not found"));
            wallet.setAccount(account);
        }
        if(name != null)
            wallet.setName(name);
        return wallet;
    }

    public void deleteWallet(Long Id){
        walletRepository.findById(Id)
        .orElseThrow(() -> new IllegalStateException("Wallet not found"));
        walletRepository.deleteById(Id);
    }
}
