package org.mrstm.strategy.payment;

import org.mrstm.enums.PaymentType;

public class PaymentProcessor {
    public static PaymentStrategy getPaymentMethod(PaymentType paymentType){
        switch (paymentType){
            case UPI -> {return new UPI();}
            case CARD -> {return new Card();}
            case NET_BANKING -> {return new NetBanking();}
        }
        return null;
    }
}
