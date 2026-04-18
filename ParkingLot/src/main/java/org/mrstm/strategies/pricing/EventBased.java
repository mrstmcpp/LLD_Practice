package org.mrstm.strategies.pricing;

import org.mrstm.models.Ticket;

public class EventBased implements PricingStrategy{
    @Override
    public int calculate(Ticket ticket) {
        return 300;
    }
}
