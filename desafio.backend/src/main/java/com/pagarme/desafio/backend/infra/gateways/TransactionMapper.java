package com.pagarme.desafio.backend.infra.gateways;

import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.dtos.TransactionDTO;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction mapToTransaction(TransactionDTO transactionDTO) {
        return new Transaction(transactionDTO.transactionPrice(),
                transactionDTO.description(),
                transactionDTO.paymentMethod(),
                transactionDTO.cardNumber(),
                transactionDTO.cardOwner(),
                transactionDTO.expirationDate(),
                transactionDTO.CVV());
    }
}
