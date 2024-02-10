package com.pagarme.desafio.backend.core.domain.useCases.transactionsUseCases;

import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.core.repositories.TransactionRepositoryService;
import com.pagarme.desafio.backend.infra.repositories.TransactionRepository;

import java.util.Collection;

public class GetAllTransactionsUseCaseImpl implements GetAllTransactionsUseCase {

    private final TransactionRepositoryService transactionRepositoryService;
    public GetAllTransactionsUseCaseImpl(TransactionRepositoryService transactionRepositoryService) {
        this.transactionRepositoryService = transactionRepositoryService;
    }
    @Override
    public Collection<Transaction> getAll() {
        return transactionRepositoryService.findAll();
    }
}
