package com.pagarme.desafio.backend.core.repositories;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepositoryService {
    void save(Transaction transaction, Payable payable);

    List<Transaction> findAll();

    Transaction findById(UUID id);
}
