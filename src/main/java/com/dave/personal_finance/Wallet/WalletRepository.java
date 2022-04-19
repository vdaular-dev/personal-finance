package com.dave.personal_finance.Wallet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository 
    extends JpaRepository<Wallet,Long>{
    
    @Query("SELECT w FROM Wallet w WHERE w.account.id = ?1")
    List<Wallet> findByAccountId(Long account_id); 
}
