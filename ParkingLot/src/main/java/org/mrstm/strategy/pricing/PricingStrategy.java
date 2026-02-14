package org.mrstm.strategy.pricing;

import org.mrstm.models.Ticket;

public interface PricingStrategy {
    int calculate(Ticket ticket);
}
