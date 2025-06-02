package com.codewithflash.restapi.DTO;

import java.math.BigDecimal;

public class TransferRequest {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

    public long getReceiverAccountId() {
        return receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getSenderAccountId() {
        return senderAccountId;
    }
}
