package org.mrstm.strategies;

import org.mrstm.models.Bill;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Bill bill) {
        System.out.println("Paying bill for order: " + bill.getOrder().getOrderId() + " of amount: " + bill.getTotalPrice() + " through Credit Card. " + "Please Wait....");
        try{
            Thread.sleep(2000);
        } catch (Exception _){

        }
        System.out.println("Bill paid.");
    }
}
