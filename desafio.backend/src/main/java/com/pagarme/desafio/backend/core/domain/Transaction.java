package com.pagarme.desafio.backend.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pagarme.desafio.backend.core.domain.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Transaction {

    public Transaction(BigDecimal transactionPrice, String description, PaymentMethod paymentMethod, String cardNumber, String cardOwner, LocalDate expirationDate, short CVV) {
        this.transactionPrice = transactionPrice;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.cardNumber = this.convertCardNumber(cardNumber);
        this.cardOwner = cardOwner;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
    }

    private BigDecimal transactionPrice;

    private String description;

    private PaymentMethod paymentMethod;

    private String cardNumber;

    private String cardOwner;

    private LocalDate expirationDate;

    private short CVV;

    public String convertCardNumber(String cardNumber) {
        return cardNumber.subSequence(cardNumber.length() - 4, cardNumber.length()).toString();
    }
    public boolean isCreditCard() {
        return this.paymentMethod == PaymentMethod.CREDIT_CARD;
    }
}
