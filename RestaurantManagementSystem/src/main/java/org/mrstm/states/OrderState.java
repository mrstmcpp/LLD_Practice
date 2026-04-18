package org.mrstm.states;

import org.mrstm.enums.OrderStatus;

public interface OrderState {
    OrderStatus getCurrentState();
    void nextState(OrderStateContext orderStateContext);
}
