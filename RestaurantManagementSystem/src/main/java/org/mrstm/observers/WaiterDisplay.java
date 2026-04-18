package org.mrstm.observers;

import org.mrstm.models.Order;

public class WaiterDisplay implements Subscriber {
    @Override
    public void update(Order order) {
        order.getOrderStateContext().nextState();
    }
}
