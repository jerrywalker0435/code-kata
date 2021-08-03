package com.code.kata.refactoring.book.ch8.organizingData.s3_changeValueToReference.original;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}