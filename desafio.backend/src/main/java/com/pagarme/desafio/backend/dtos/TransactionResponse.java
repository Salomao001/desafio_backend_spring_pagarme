package com.pagarme.desafio.backend.dtos;

import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.core.domain.enums.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class TransactionResponse {
    public TransactionResponse(Transaction transaction) {
        this.transactionPrice = transaction.getTransactionPrice();
        this.description = transaction.getDescription();
        this.paymentMethod = transaction.getPaymentMethod();
        this.cardNumber = transaction.getCardNumber();
        this.cardOwner = transaction.getCardOwner();
        this.expirationDate = transaction.getExpirationDate();
        this.CVV = transaction.getCVV();
    }

    private BigDecimal transactionPrice;
    private String description;
    private PaymentMethod paymentMethod;
    private String cardNumber;
    private String cardOwner;
    private LocalDate expirationDate;
    private short CVV;
}
