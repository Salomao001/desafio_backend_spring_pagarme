package com.pagarme.desafio.backend.infra.gateways;

import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.infra.entities.TransactionEntity;

public class TransactionEntityMapper {
    public TransactionEntity mapToEntity(Transaction transaction) {
        return new TransactionEntity(transaction);
    }
}