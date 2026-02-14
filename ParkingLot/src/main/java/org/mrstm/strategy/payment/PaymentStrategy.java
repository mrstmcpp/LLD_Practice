package org.mrstm.strategy.payment;

import org.mrstm.enums.PaymentType;
import org.mrstm.models.Ticket;

public interface PaymentStrategy {
    void pay(Ticket ticket);
}
