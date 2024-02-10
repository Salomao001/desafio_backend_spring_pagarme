package com.pagarme.desafio.backend.infra.repositories;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.core.repositories.TransactionRepositoryService;
import com.pagarme.desafio.backend.infra.gateways.PayableEntityMapper;
import com.pagarme.desafio.backend.infra.gateways.TransactionEntityMapper;

import java.util.List;
import java.util.UUID;

public class TransactionRepositoryServiceImpl implements TransactionRepositoryService {

    private final PayableEntityMapper payableEntityMapper;
    private final PayableRepository payableRepository;
    private final  TransactionEntityMapper transactionEntityMapper;
    private final TransactionRepository transactionRepository;
    public TransactionRepositoryServiceImpl(TransactionEntityMapper transactionEntityMapper, TransactionRepository transactionRepository,
                                            PayableRepository payableRepository,
                                            PayableEntityMapper payableEntityMapper) {
        this.transactionEntityMapper = transactionEntityMapper;
        this.transactionRepository = transactionRepository;
        this.payableRepository = payableRepository;
        this.payableEntityMapper = payableEntityMapper;
    }

    @Override
    public void save(Transaction transaction, Payable payable) {
        var transactionEnitity = transactionEntityMapper.mapToEntity(transaction);
        transactionRepository.save(transactionEnitity);
        var payableEntity = payableEntityMapper.mapToEntity(payable);
        payableEntity.setTransaction(transactionEnitity);
        payableRepository.save(payableEntity);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll().stream().map(transaction -> new Transaction(transaction.getTransactionPrice(),
                transaction.getDescription(),
                transaction.getPaymentMethod(),
                transaction.getCardNumber(),
                transaction.getCardOwner(),
                transaction.getExpirationDate(),
                transaction.getCVV())).toList();
    }

    @Override
    public Transaction findById(UUID id) {
        return transactionRepository.findById(id).map(x -> new Transaction(x.getTransactionPrice(),
                x.getDescription(),
                x.getPaymentMethod(),
                x.getCardNumber(),
                x.getCardOwner(),
                x.getExpirationDate(),
                x.getCVV())).orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }
}
