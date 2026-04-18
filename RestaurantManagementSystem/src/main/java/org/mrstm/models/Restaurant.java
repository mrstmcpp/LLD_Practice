package org.mrstm.models;

import org.mrstm.observers.ChefDisplay;
import org.mrstm.observers.ChefPublisher;
import org.mrstm.observers.WaiterDisplay;
import org.mrstm.observers.WaiterPublisher;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Restaurant {
    private final Menu menu;
    private final List<Waiter> waiterList;
    private final List<Table> tableList;
    private final HashMap<Integer , Order> waiterToOrderMap = new HashMap<>(); // waiterId , serving order
    private final HashMap<Integer , Order> chefToOrderMap = new HashMap<>(); // chefId , serving order
    private final HashSet<Integer> busyTableSet = new HashSet<>(); // table id
    private final HashSet<Integer> busyWaiterSet = new HashSet<>(); // waiter id
    private final HashMap<Integer , Waiter> tableToWaiter = new HashMap<>(); //
    private final HashMap<Integer, Table> activeReservation = new HashMap<>(); // TODO:
    private int tableCount = 1;

    private final ChefPublisher chefPublisher = new ChefPublisher();
    private final WaiterPublisher waiterPublisher = new WaiterPublisher();

    private final ChefDisplay chefDisplay = new ChefDisplay();
    private final WaiterDisplay waiterDisplay = new WaiterDisplay();

    public Restaurant (int numberOfTables, int numberOfWaiters, Menu menu){
        this.menu = menu;
        this.tableList = new ArrayList<>();
        this.waiterList = new ArrayList<>();
        chefPublisher.addSubscriber(chefDisplay);
        waiterPublisher.addSubscriber(waiterDisplay);
        for (int i = 0; i < numberOfTables; i++) {
            tableList.add(new Table(i)); // or i+1
        }

        for (int i = 0; i < numberOfWaiters; i++) {
            waiterList.add(new Waiter("abc" , i)); // or i+1
        }
    }
    //staff addition
    public void addWaiter(String name){
        int waiterId = (int)(Math.random() * 100);
        waiterToOrderMap.put(waiterId , null);
    }

    public void addChef(String name){
        int chefId = (int)(Math.random() * 100);
        chefToOrderMap.put(chefId , null);
    }

    // restaurant actions
    public Bill generateBill(Order order){
        return new Bill(order);
    }

    //staff apis
    public Table addTable(){
        return new Table(tableCount++);
    }

    public void addReservation(Table table){
        int reservationId = (int) (Math.random() * 100);
        activeReservation.put(reservationId , table);
    }

    public void clearReservation(int reservationId){
        activeReservation.remove(reservationId);
    }

    public Table assignTableAndWaiter() throws Exception {
        int table = assignTable();
        Waiter waiter = assignWaiter(tableList.get(table));
        tableToWaiter.put(table, waiter);
        return tableList.get(table);
    }

    private int assignTable() throws Exception {
        for(int i = 0; i < tableList.size(); i++){
            if(!busyTableSet.contains(i)){
                System.out.println("Assigning table : " + i);
                busyTableSet.add(i);
                return i;
            }
        }
        return -1;
//        throw new Exception("No tables are free RN.");
    }

    private Waiter assignWaiter(Table table) throws Exception {
        Waiter assigned = null;

        for (Waiter w : waiterList) {
            if (!busyWaiterSet.contains(w.getStaffId())) {
                System.out.println("Assigning waiter: " + w.getStaffId() +
                        " to table: " + table.getTableNumber());

                busyWaiterSet.add(w.getStaffId());
                assigned = w;
                return assigned;
            }
        }
        return null;
//        throw new Exception("No waiters are free RN.");
    }

    public Order takeOrder(Table table , List<String> orderList){
        List<Menu.MenuItem> menuItemList = prepareMenuList(orderList);
        Order order = new Order(table , menuItemList);
        chefPublisher.setOrder(order);
        System.out.println("Your order id is: " + order.getOrderId());
        return order;
    }

    private List<Menu.MenuItem> prepareMenuList(List<String> orderList){
        List<Menu.MenuItem> menuItemList = new ArrayList<>();

        for(String order : orderList){
            Menu.menuItemList.forEach(
                    m -> {
                        if(m.item.equalsIgnoreCase(order)){
                            menuItemList.add(m);
                        }
                    }
            );
        }
        return menuItemList;
    }

    public void serveOrder(Order order){
        waiterPublisher.setOrder(order);
    }

    public Bill completeOrderAndGenerateBill(Order order){
        order.getOrderStateContext().nextState();
        int waiterId = tableToWaiter.get(order.getTable().getTableNumber()).getStaffId();
        busyWaiterSet.remove(waiterId);
        busyTableSet.remove(order.getTable().getTableNumber());
        return new Bill(order);
    }


    public Menu getMenu() {
        return menu;
    }
}
