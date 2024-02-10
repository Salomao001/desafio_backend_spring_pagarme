package com.pagarme.desafio.backend.core.domain.useCases.transactionsUseCases;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.repositories.TransactionRepositoryService;
import com.pagarme.desafio.backend.core.domain.Transaction;

public class CreateTransactionAndPayableUseCaseImpl implements CreateTransactionAndPayableUseCase {

    private final TransactionRepositoryService transactionRepositoryService;

    public CreateTransactionAndPayableUseCaseImpl(TransactionRepositoryService transactionRepositoryService) {
        this.transactionRepositoryService = transactionRepositoryService;
    }

    @Override
    public void createTransactionAndPayable(Transaction transaction, Payable payable) {
        transactionRepositoryService.save(transaction, payable);
    }
}
