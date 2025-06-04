package com.codewithflash.restapi.controllers;

import com.codewithflash.restapi.DTO.TransferRequest;
import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney (@RequestBody TransferRequest request) {
         transferService.transferMoney(
                 request.getSenderAccountId(),
                 request.getReceiverAccountId(),
                 request.getAmount()
        ) ;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccount(@RequestParam(required = false) String name) {
        if (name == null) {
            return transferService.getAllAccounts();
        }
        return transferService.findAccountsByName(name);
    }
}
