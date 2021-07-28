package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractDelegate.after;

public class Info {
    String b;

    public Info() {
    }

    public String getInfo() {
        return ("(" + b + ")");
    }
}