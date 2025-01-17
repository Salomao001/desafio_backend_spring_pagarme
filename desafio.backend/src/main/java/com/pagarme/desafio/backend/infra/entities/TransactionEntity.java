package com.pagarme.desafio.backend.infra.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.core.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    public TransactionEntity(Transaction transaction) {
        this.id = UUID.randomUUID();
        this.transactionPrice = transaction.getTransactionPrice();
        this.description = transaction.getDescription();
        this.paymentMethod = transaction.getPaymentMethod();
        this.cardNumber = transaction.getCardNumber();
        this.cardOwner = transaction.getCardOwner();
        this.expirationDate = transaction.getExpirationDate();
        this.CVV = transaction.getCVV();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "transaction_price", nullable = false)
    private BigDecimal transactionPrice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "card_owner", nullable = false)
    private String cardOwner;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "cvv", nullable = false)
    private short CVV;

    public boolean isCreditCard() {
        return this.paymentMethod == PaymentMethod.CREDIT_CARD;
    }
}
