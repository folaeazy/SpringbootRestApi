package com.codewithflash.restapi;

import com.codewithflash.restapi.exceptions.AccountNotFoundException;
import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.repository.AccountRepository;
import com.codewithflash.restapi.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import  static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {
    @Mock
    private AccountRepository accountRepository; // creating a fake object of the dependency
    //-----------inject the mock object to the transferService
    @InjectMocks
    private TransferService transferService;

    @Test
    @DisplayName("Test the amount transfer from one account to another if no exceptions")
    public void moneyTransferHappyFlow() {

//        //create an instance of the test class to access the transfer method
//        TransferService transferService = new TransferService(accountRepository);
        // created the account instances and added neccessary data assuming its db//
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        //Testing the find by ID using given()-----------//
        given(accountRepository.findAccountById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findAccountById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(1,2, new BigDecimal(100));

        verify(accountRepository).setNewAmount(sender.getId(), new BigDecimal(900));
        verify(accountRepository).setNewAmount(destination.getId(), new BigDecimal(1100));
    }

    @Test
    @DisplayName("Test the amount transfer from one account to another with exceptions")
    public void moneyTransferExceptionFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        //modifying destination account to return empty to test for exception flow
        ///  Exception flow test------------//
        given(accountRepository.findAccountById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findAccountById(2L)).willReturn(Optional.empty());
        //Using assertThrow with the test method to test for exception.
        assertThrows(AccountNotFoundException.class,
                () -> transferService.transferMoney(1,2, new BigDecimal(100)));

        //We verify that the setNewAmount method is not called once an exception is thrown
        verify(accountRepository,never()).setNewAmount(anyLong(),any());

    }


}
