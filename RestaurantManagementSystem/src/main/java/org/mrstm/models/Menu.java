package org.mrstm.models;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static final List<MenuItem> menuItemList = new ArrayList<>();

    public Menu() {
        System.out.println("Preparing generic menu...");
        menuItemList.addAll(List.of(
                new MenuItem("Tea", 20),

                // Starters
                new MenuItem("French Fries", 90),
                new MenuItem("Garlic Bread", 110),
                new MenuItem("Paneer Tikka", 220),
                new MenuItem("Chicken Wings", 250),

                // Main Course
                new MenuItem("Veg Biryani", 160),
                new MenuItem("Chicken Biryani", 240),
                new MenuItem("Butter Chicken", 280),
                new MenuItem("Dal Makhani", 190),
                new MenuItem("Paneer Butter Masala", 230),
                new MenuItem("Naan", 40),
                new MenuItem("Roti", 20),

                // Fast Food
                new MenuItem("Sandwich", 80),
                new MenuItem("Pasta", 150),
                new MenuItem("Momos", 120),
                new MenuItem("Hot Dog", 100),

                // Beverages
                new MenuItem("Coffee", 60),
                new MenuItem("Cold Coffee", 120),
                new MenuItem("Lemonade", 50),
                new MenuItem("Soft Drink", 40),
                new MenuItem("Milkshake", 140),

                // Desserts
                new MenuItem("Ice Cream", 90),
                new MenuItem("Brownie", 130),
                new MenuItem("Gulab Jamun", 70),
                new MenuItem("Rasgulla", 60)
        ));

    }

    public void printMenu() {
        for (MenuItem it : menuItemList) {
            if (it.available) {
                System.out.println(it.item + " -> " + it.price);
            }
        }
    }

    public void addItem(MenuItem menuItem) {
        if (menuItem.price <= 0) {
            throw new InvalidParameterException("Price cannot be zero or negative for an item.");
        }
        menuItemList.add(menuItem);
    }

    public void markUnavailable(String item) {
        System.out.println("Marking " + item + " unavailable...");
        for (MenuItem it : menuItemList) {
            if (it.item.equalsIgnoreCase(item)) {
                it.available = false;
            }
        }
    }

    public static class MenuItem {
        public String item;
        public int price;
        public boolean available = true;

        public MenuItem(String item, int price) {
            this.item = item;
            this.price = price;
        }
    }

}
