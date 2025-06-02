package com.codewithflash.restapi.controllers;

import com.codewithflash.restapi.DTO.TransferRequest;
import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    public List<Account> GetAllAccount() {
        return transferService.GetAllAccounts();
    }
}
