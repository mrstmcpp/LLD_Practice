package org.mrstm.strategies.pricing;

import org.mrstm.models.Ticket;

public interface PricingStrategy {
    int calculate(Ticket ticket);
}
