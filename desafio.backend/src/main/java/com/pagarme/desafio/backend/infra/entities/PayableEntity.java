package com.pagarme.desafio.backend.infra.entities;

import com.pagarme.desafio.backend.core.domain.Payable;
import com.pagarme.desafio.backend.core.domain.enums.PayableStatus;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payables")
@NoArgsConstructor
public class PayableEntity {


    public PayableEntity(Payable payable) {
        this.id = UUID.randomUUID();
        this.status = payable.getStatus();
        this.paymentDate = payable.getPaymentDate();
        this.fee = payable.getFee();
        this.partialValue = payable.getPartialValue();
        this.totalValue = payable.getTotalValue();
    }

    @Id
    private UUID id;

    @Column(name = "payable_status", nullable = false)
    private PayableStatus status;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "fee", nullable = false)
    private BigDecimal fee;

    @Column(name = "partial_value", nullable = false)
    private BigDecimal partialValue;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @Setter
    @OneToOne
    @JoinColumn(name = "transaction_id", updatable = false)
    private TransactionEntity transaction;
}
