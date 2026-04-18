package org.mrstm.states;

import org.mrstm.enums.OrderStatus;

public class ServedOrderState implements OrderState{


    public ServedOrderState() {
        System.out.println("Order is being served.");
    }

    @Override
    public OrderStatus getCurrentState() {
        return OrderStatus.SERVED;
    }

    @Override
    public void nextState(OrderStateContext orderStateContext) {
        orderStateContext.setOrderState(new CompletedOrderState());
    }
}
