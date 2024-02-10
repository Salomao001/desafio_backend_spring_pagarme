package com.pagarme.desafio.backend.core.domain.useCases.transactionsUseCases;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;

public interface CreateTransactionAndPayableUseCase {
    void createTransactionAndPayable(Transaction transaction, Payable payable);
}
