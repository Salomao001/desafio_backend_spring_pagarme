package com.pagarme.desafio.backend.core.domain.useCases.transactionsUseCases;

import com.pagarme.desafio.backend.core.domain.Transaction;

import java.util.Collection;

public interface GetAllTransactionsUseCase {

    Collection<Transaction> getAll();
}
