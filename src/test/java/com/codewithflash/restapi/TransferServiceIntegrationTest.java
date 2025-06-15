package com.codewithflash.restapi;

import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.repository.AccountRepository;
import com.codewithflash.restapi.services.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TransferServiceIntegrationTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTest() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        when(accountRepository.findAccountById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findAccountById(2L)).thenReturn(Optional.of(destination));

        transferService.transferMoney(1,2, new BigDecimal(100));
        verify(accountRepository).setNewAmount(1, new BigDecimal(900));
        verify(accountRepository).setNewAmount(2, new BigDecimal(1100));
    }
}
