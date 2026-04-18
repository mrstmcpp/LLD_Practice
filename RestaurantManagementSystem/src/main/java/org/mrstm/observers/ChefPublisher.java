package org.mrstm.observers;

import org.mrstm.models.Order;

import java.util.ArrayList;
import java.util.List;

public class ChefPublisher implements Publisher{
    public static List<Subscriber> chefSubscriberList = new ArrayList<>();
    private Order order;


    @Override
    public void addSubscriber(Subscriber subscriber) {
        chefSubscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        chefSubscriberList.remove(subscriber);
    }

    @Override
    public void publish() {
        for(Subscriber sub : chefSubscriberList){
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

    public static List<Subscriber> getChefSubscriberList() {
        return chefSubscriberList;
    }

    public static void setChefSubscriberList(List<Subscriber> chefSubscriberList) {
        ChefPublisher.chefSubscriberList = chefSubscriberList;
    }
}
