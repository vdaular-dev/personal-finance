package com.dave.personal_finance.AccountType;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.dave.personal_finance.Account.Account;


@Entity
@Table(name = "account_type")
public class AccountType {

    @Id
    @SequenceGenerator(
        name = "account_type_sequence",
        sequenceName = "account_type_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "account_type_sequence"
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy="accountType")
    private Set<Account> account;


    public AccountType() {}

    public AccountType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
