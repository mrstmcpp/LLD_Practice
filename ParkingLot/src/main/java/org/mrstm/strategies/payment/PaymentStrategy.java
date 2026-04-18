package org.mrstm.strategies.payment;

import org.mrstm.models.Ticket;

public interface PaymentStrategy {
    void pay(Ticket ticket);
}
