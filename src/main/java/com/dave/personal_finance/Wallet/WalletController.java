package com.dave.personal_finance.Wallet;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="wallet")
public class WalletController {
    
    private WalletService walletService;


    /**
     * Return detail wallet by id
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "{accountId}")
    public List<Wallet> getWallet(@PathParam("accountId") Long id){
        return walletService.getWalletByAccount(id);
    }

    /**
     * Register a new wallet
     * 
     * @param wallet
     * @return
     */
    @PostMapping(path = "insert")
    public Wallet insertWallet(@RequestBody Wallet wallet){
        return walletService.insertWallet(wallet);
    }

    /**
     * Update wallet
     * 
     * @param id
     * @param name
     * @param accountId
     * @return
     */
    @PutMapping(path = "{walletId}")
    public Wallet updateWallet(
        @PathParam("walletId") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long accountId
    ){
        return walletService.updateWallet(id, accountId, name);
    }

    /**
     * Delete wallet
     * 
     * @param id
     */
    @DeleteMapping(path = "{walletId}")
    public void deleteWallet(@PathParam("walletId") Long id){
        walletService.deleteWallet(id);
    }
}
