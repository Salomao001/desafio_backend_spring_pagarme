package com.pagarme.desafio.backend.infra.repositories;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.infra.entities.PayableEntity;
import com.pagarme.desafio.backend.infra.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayableRepository extends JpaRepository<PayableEntity, UUID> {

}
