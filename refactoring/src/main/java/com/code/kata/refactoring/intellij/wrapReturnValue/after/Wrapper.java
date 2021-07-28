package com.code.kata.refactoring.intellij.wrapReturnValue.after;

public class Wrapper {
    private final String value;

    public Wrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
