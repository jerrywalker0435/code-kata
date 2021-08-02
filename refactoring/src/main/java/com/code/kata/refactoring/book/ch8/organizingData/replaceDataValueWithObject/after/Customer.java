package com.code.kata.refactoring.book.ch8.organizingData.replaceDataValueWithObject.after;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}