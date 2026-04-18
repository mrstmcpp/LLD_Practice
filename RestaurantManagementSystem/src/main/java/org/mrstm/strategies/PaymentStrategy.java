package org.mrstm.strategies;

import org.mrstm.models.Bill;

public interface PaymentStrategy {
    void pay(Bill bill);
}
