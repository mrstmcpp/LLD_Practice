package org.mrstm.strategies.payment;

import org.mrstm.models.Ticket;

public class NetBanking implements PaymentStrategy{
    @Override
    public void pay(Ticket ticket) {
        System.out.println("Paying for ticket: ID = " + ticket.getId()
                + ", Price = " + ticket.getPrice() + " through Net Banking");
    }
}
