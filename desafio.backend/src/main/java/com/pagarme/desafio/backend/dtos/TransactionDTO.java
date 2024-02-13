package com.pagarme.desafio.backend.dtos;

import com.pagarme.desafio.backend.core.domain.enums.PaymentMethod;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionDTO(
        BigDecimal transactionPrice,
        String description,
        PaymentMethod paymentMethod,
        String cardNumber,
        String cardOwner,
        LocalDate expirationDate,
        short CVV
) {
}
