package org.mrstm.observers;

import org.mrstm.models.Order;

public interface Subscriber {
    void update(Order order);
}
