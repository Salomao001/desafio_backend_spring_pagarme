package com.pagarme.desafio.backend.core.domain;

import com.pagarme.desafio.backend.core.domain.enums.PayableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Payable {

    public Payable(Transaction transaction) {
        this.status = getStatus(transaction);
        this.paymentDate = getPaymentDate(transaction);
        this.fee = getFee(transaction);
        this.partialValue = transaction.getTransactionPrice();
        this.totalValue = calculateTotalValue();
        this.transaction = transaction;
    }

    private PayableStatus status;

    private LocalDateTime paymentDate;

    private BigDecimal fee;

    private BigDecimal partialValue;

    private BigDecimal totalValue;

    private Transaction transaction;

    public BigDecimal getFee(Transaction transaction) {
        if (transaction.isCreditCard())
            return BigDecimal.valueOf(5);
        return BigDecimal.valueOf(3);
    }

    public LocalDateTime getPaymentDate(Transaction transaction) {
        if (transaction.isCreditCard())
            return LocalDateTime.now().plusDays(30);
        return LocalDateTime.now();
    }

    public PayableStatus getStatus(Transaction transaction) {
        if (transaction.isCreditCard())
            return PayableStatus.WAITING_FUNDS;
        return PayableStatus.PAID;
    }

    public BigDecimal calculateTotalValue() {
        var value = this.fee.divide(BigDecimal.valueOf(100)).multiply(this.partialValue);
        return this.partialValue.subtract(value);
    }
}
