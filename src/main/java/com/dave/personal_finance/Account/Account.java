package com.dave.personal_finance.Account;

import java.util.Set;

import javax.persistence.*;

import com.dave.personal_finance.AccountType.AccountType;
import com.dave.personal_finance.Wallet.Wallet;

@Entity
@Table(name = "account")
public class Account {
    
    @Id
    @SequenceGenerator(
        name = "account_sequence",
        sequenceName = "account_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "account_sequence"
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy="account")
    private Set<Wallet> wallet;
    @ManyToOne
    @JoinColumn(
        name="account_type_id", 
        nullable=false
    )
    private AccountType accountType;

    
    public Account(){}

    public Account(String name){
        this.name = name; 
    }

    public Account(Long id, String name){
        this.id = id;
        this.name = name; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
