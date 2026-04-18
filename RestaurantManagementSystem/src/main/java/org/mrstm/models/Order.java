package org.mrstm.models;

import org.mrstm.enums.OrderStatus;
import org.mrstm.states.OrderStateContext;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private Table table;
    private List<Menu.MenuItem> menuItemList = new ArrayList<>();
    private OrderStateContext orderStateContext;

    public Order(Table table, List<Menu.MenuItem> menuItemList){
        this.orderId = (int) (Math.round(Math.random() * 100));
        this.table = table;
        this.menuItemList = menuItemList;
        this.orderStateContext = new OrderStateContext();
    }

    private void updateStatus(){
        orderStateContext.nextState();
    }

    private OrderStatus getOrderStatus(){
        return orderStateContext.getCurrentState();
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Menu.MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<Menu.MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public OrderStateContext getOrderStateContext() {
        return orderStateContext;
    }

    public void setOrderStateContext(OrderStateContext orderStateContext) {
        this.orderStateContext = orderStateContext;
    }

    public double getOrderId() {
        return orderId;
    }

}
