package org.mrstm.models;

public class Bill {
    private Order order;
    private int totalPrice;

    public Bill(Order order){
        this.order = order;
        this.totalPrice = generateBill();
    }

    private int generateBill(){
        int totalPrice = 0;
        var menuList = order.getMenuItemList();

        for(Menu.MenuItem item : menuList){
            System.out.println(item.item + " " + item.price);
            totalPrice += item.price;
        }
        System.out.println("Total value for order : " + order.getOrderId() + " is: " + totalPrice);
        return totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
