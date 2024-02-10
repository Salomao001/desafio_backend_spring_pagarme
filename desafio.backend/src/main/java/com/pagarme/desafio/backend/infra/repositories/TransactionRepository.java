package com.pagarme.desafio.backend.infra.repositories;

import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.infra.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}
