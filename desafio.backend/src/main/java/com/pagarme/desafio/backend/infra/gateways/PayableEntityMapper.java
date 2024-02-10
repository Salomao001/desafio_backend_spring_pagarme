package com.pagarme.desafio.backend.infra.gateways;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.Transaction;
import com.pagarme.desafio.backend.infra.entities.PayableEntity;
import com.pagarme.desafio.backend.infra.entities.TransactionEntity;

import java.util.UUID;

public class PayableEntityMapper {
    public PayableEntity mapToEntity(Payable payable) {
        return new PayableEntity(payable);
    }
}
