package org.mrstm.states;

import org.mrstm.enums.OrderStatus;

public class PlacedOrderState implements OrderState{
    public PlacedOrderState() {
        System.out.println("Order is begin placed.");
    }

    @Override
    public OrderStatus getCurrentState() {
        return OrderStatus.PLACED;
    }

    @Override
    public void nextState(OrderStateContext orderStateContext) {
        orderStateContext.setOrderState(new PreparingOrderState());
    }
}
