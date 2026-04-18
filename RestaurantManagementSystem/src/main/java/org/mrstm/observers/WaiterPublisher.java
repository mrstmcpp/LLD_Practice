package org.mrstm.observers;

import org.mrstm.models.Order;

import java.util.ArrayList;
import java.util.List;

public class WaiterPublisher implements Publisher{
    private static final List<Subscriber> waiterSubscriberList = new ArrayList<>();

    private Order order;

    @Override
    public void addSubscriber(Subscriber subscriber) {
        waiterSubscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        waiterSubscriberList.remove(subscriber);
    }

    @Override
    public void publish() {
        for(Subscriber sub : waiterSubscriberList){
            sub.update(order);
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        publish();
    }
}
