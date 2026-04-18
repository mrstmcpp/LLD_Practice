package org.mrstm.states;

import org.mrstm.enums.OrderStatus;
import org.mrstm.models.Order;

public class OrderStateContext {
    private OrderState orderState;

    public OrderStateContext(){
        orderState = new PlacedOrderState();
    }

    public void setOrderState(OrderState orderState){
        this.orderState = orderState;
    }

    public OrderStatus getCurrentState(){
        return orderState.getCurrentState();
    }

    public void nextState(){
        OrderStatus old = this.orderState.getCurrentState();
        orderState.nextState(this);
        System.out.println("OrderStatus updated from : " + old + " to " + this.orderState.getCurrentState());
    }

}
