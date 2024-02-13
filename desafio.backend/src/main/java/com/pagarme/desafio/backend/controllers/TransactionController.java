package com.pagarme.desafio.backend.controllers;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.dtos.TransactionDTO;
import com.pagarme.desafio.backend.dtos.TransactionResponse;
import com.pagarme.desafio.backend.infra.gateways.PayableEntityMapper;
import com.pagarme.desafio.backend.infra.gateways.TransactionEntityMapper;
import com.pagarme.desafio.backend.infra.gateways.TransactionMapper;
import com.pagarme.desafio.backend.infra.repositories.TransactionRepositoryServiceImpl;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepositoryServiceImpl transactionRepositoryService;
    private final TransactionMapper transactionMapper;
    public TransactionController(TransactionMapper transactionMapper, TransactionRepositoryServiceImpl transactionRepositoryService)
    {
        this.transactionMapper = transactionMapper;
        this.transactionRepositoryService = transactionRepositoryService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        var transaction = transactionMapper.mapToTransaction(transactionDTO);
        var payable = new Payable(transaction);
        transactionRepositoryService.save(transaction, payable);
        var transactionResponse = new TransactionResponse(transaction);
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAll() {
        var transactions = transactionRepositoryService.findAll().stream().map(TransactionResponse::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }
}


