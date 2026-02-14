package org.mrstm.strategy.payment;

import org.mrstm.enums.PaymentType;
import org.mrstm.models.Ticket;

public class Card implements PaymentStrategy{
    @Override
    public void pay(Ticket ticket) {
        System.out.println("Paying for ticket: ID = " + ticket.getId()
                + ", Price = " + ticket.getPrice() + " through Card");
    }
}
