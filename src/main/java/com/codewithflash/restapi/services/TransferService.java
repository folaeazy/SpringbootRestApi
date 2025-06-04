package com.codewithflash.restapi.services;

import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codewithflash.restapi.exceptions.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private  final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    //-&&&&&&&&&&&&&-----------THE JDBC TEMPLATE DATA SOURCE METHODS--&&&&&&&&&&&&&&&---------//
//    @Transactional
//    public void transferMoney(long senderId , long receiverId , BigDecimal amount) {
//        // Find sender and reciever account status by their ID
//        Account sender = accountRepository.findAccountById(senderId);
//        Account receiver = accountRepository.findAccountById(receiverId);
//
//        //Get account amount and add for reciever , deduct for sender
//        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
//        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
//
//        //Set the new amount in both accounts
//
//        accountRepository.setNewAmount(senderId, senderNewAmount);
//        accountRepository.setNewAmount(receiverId, receiverNewAmount);
//
//        throw new RuntimeException("Oh no! Something went wrong!"); //To test if the transaction works
//    }
//
//    public List<Account> getAllAccounts() {
//        return accountRepository.findAllAccounts();
//    }
    //-----------------------------END*****************************??//

    //*****************SPRING DATA METHOD---------------*****************//

    @Transactional
    public void transferMoney(long senderId, long receiverId , BigDecimal amount) {
        Account sender = accountRepository.findAccountById(senderId)
                .orElseThrow(() -> new AccountNotFoundException(senderId));
        Account receiver = accountRepository.findAccountById(receiverId)
                .orElseThrow(() ->  new AccountNotFoundException(receiverId));

        // Get their amount and update the balance .
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        //Set new amount
        accountRepository.setNewAmount(senderId, senderNewAmount);
        accountRepository.setNewAmount(receiverId, receiverNewAmount);
        //throw new RuntimeException("Oh no! Something went wrong!"); //To test if the transaction works
    }

    public Iterable<Account> getAllAccounts() {
        return  accountRepository.findAll();
    }


    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }

    //&&&&&&&&&&&&&&&&&&&&(((END)))***********************&&&&&&&&&&&&&&&//
}
