package com.pagarme.desafio.backend.core.domain;

import com.pagarme.desafio.backend.core.domain.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private BigDecimal transactionPrice;

    private String description;

    private PaymentMethod paymentMethod;

    private String cardNumber;

    private String cardOwner;

    private LocalDateTime expirationDate;

    private short CVV;

    public String ConvertCardNumber() {
        return this.cardNumber.subSequence(this.cardNumber.length() - 4, this.cardNumber.length()).toString();
    }

    public boolean isCreditCard() {
        return this.paymentMethod == PaymentMethod.CREDIT_CARD;
    }
}
