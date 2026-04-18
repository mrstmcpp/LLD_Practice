package org.mrstm.states;

import org.mrstm.enums.OrderStatus;

public class CompletedOrderState implements OrderState{

    public CompletedOrderState() {
        System.out.println("Order completed.");

    }

    @Override
    public OrderStatus getCurrentState() {
        return OrderStatus.COMPLETED;
    }

    @Override
    public void nextState(OrderStateContext orderStateContext) {
        throw new IllegalStateException("This order is completed.");
    }
}
