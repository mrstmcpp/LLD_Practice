package org.mrstm.strategies;

import org.mrstm.models.Bill;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Bill bill) {
        System.out.println("Paying bill for order: " + bill.getOrder().getOrderId() + " of amount: " + bill.getTotalPrice() + " through UPI. " + "Please Wait....");
        try{
            Thread.sleep(2000);
        } catch (Exception _){

        }
        System.out.println("Bill paid.");
    }
}
