package org.mrstm;

import org.mrstm.models.*;
import org.mrstm.strategies.CreditCardPaymentStrategy;
import org.mrstm.strategies.PaymentProcessor;
import org.mrstm.strategies.UpiPaymentStrategy;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int numberOfTables = 5;
        int numberOfWaiters = 5;
        Restaurant restaurant = new Restaurant(numberOfTables, numberOfWaiters , new Menu());
        PaymentProcessor paymentProcessor = new PaymentProcessor();

//        restaurant.getMenu().printMenu();

        // assign table
        Table table1 = restaurant.assignTableAndWaiter();
        Table table2 = restaurant.assignTableAndWaiter();
        Table table3 = restaurant.assignTableAndWaiter();

        List<String> orderingMenu1 = List.of("Tea", "Pasta");
        List<String> orderingMenu2 = List.of("Tea", "Pasta" , "Veg Biryani" , "Dal Makhani");
        List<String> orderingMenu3 = List.of("Momos", "Pasta" , "Coffee" , "Milkshake" , "Ice Cream");
        Order order1 = restaurant.takeOrder(table1, orderingMenu1);
        Order order2 = restaurant.takeOrder(table2, orderingMenu2);
        Order order3 = restaurant.takeOrder(table3, orderingMenu3);

        restaurant.serveOrder(order2);

        System.out.println("Preparing your food... Please wait...");
        restaurant.serveOrder(order1);
        Bill bill1 = restaurant.completeOrderAndGenerateBill(order1);


        restaurant.serveOrder(order3);
        Bill bill2 = restaurant.completeOrderAndGenerateBill(order2);
        //say upi payment
        paymentProcessor.setPaymentStrategy(new UpiPaymentStrategy());
        paymentProcessor.makePayment(bill2);
        Bill bill3 = restaurant.completeOrderAndGenerateBill(order3);
        paymentProcessor.makePayment(bill1);
        paymentProcessor.makePayment(bill3);
    }
}