package org.mrstm.strategies;

import org.mrstm.models.Bill;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(){
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(Bill bill){
        paymentStrategy.pay(bill);
    }
}
