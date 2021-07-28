package com.code.kata.refactoring.intellij.replaceConstructorWithBuilder.after;

public class VarietyBuilder {
    private String name;

    public VarietyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Variety createVariety() {
        return new Variety(name);
    }
}