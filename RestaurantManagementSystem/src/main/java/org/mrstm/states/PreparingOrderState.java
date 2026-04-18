package org.mrstm.states;

import org.mrstm.enums.OrderStatus;

public class PreparingOrderState implements OrderState{
    public PreparingOrderState() {
        System.out.println("Order is being prepared.");
    }

    @Override
    public OrderStatus getCurrentState() {
        return OrderStatus.PREPARING;
    }

    @Override
    public void nextState(OrderStateContext orderStateContext) {
        orderStateContext.setOrderState(new ServedOrderState());
    }
}
