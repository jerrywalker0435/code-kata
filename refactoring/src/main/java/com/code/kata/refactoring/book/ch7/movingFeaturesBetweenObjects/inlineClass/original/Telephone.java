package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.inlineClass.original;

public class Telephone {
    private String officeAreaCode;
    private String officeNumber;

    public Telephone() {
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}