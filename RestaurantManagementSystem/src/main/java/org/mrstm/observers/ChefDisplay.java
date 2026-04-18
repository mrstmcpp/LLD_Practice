package org.mrstm.observers;

import org.mrstm.models.Order;

public class ChefDisplay implements Subscriber{
    @Override
    public void update(Order order) {
        order.getOrderStateContext().nextState();
    }
}
