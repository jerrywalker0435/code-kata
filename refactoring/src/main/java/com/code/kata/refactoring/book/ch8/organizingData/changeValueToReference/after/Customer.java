package com.code.kata.refactoring.book.ch8.organizingData.changeValueToReference.after;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;

    private static Map<String,Customer> store = new HashMap();

    static void loadCustomers(){
        new Customer("Lemon Car Hire").store();
        new Customer("Associated Coffee Machines").store();
        new Customer("Bilston Gasworks").store();
    }
    private void store(){
        store.put(this.getName(),this);
    }
    private Customer(String name) {
        this.name = name;
    }
    // Replace Constructor with Factory Method
    public static Customer createCustomer(String name) {
        return store.get(name);
    }

    public String getName() {
        return name;
    }
}