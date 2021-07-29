package com.code.kata.refactoring.book.ch8.organizingData.changeReferenceToValue.after;

import java.util.Objects;

/**
 * Change Value To Reference
 * You have a reference object that is small,immutable,and awkward to manage.
 * Turn it into a value object.
 * Motivation
 *   As with Change Value to Reference,the decision between a reference and a value object is not always clear.It is a
 * decision that often needs reversing.
 *   The trigger for going from a reference to a value is that working with the reference object becomes awkward.Reference
 * objects have to be controlled in some way.You always need to ask the controller for the appropriate object.The memory
 * links also can be awkward.Value objects are particularly useful distributed and concurrent systems.
 *   An important property of value objects is that they are should be immutable.Any time you invoke a query on one,you
 * should get the same result.If this is true,there is no problem having many objects represent the same thing.If the value
 * is mutable,you have to ensure that changing any object also updates all the objects that represent the same thing. That's
 * so much of pain that the easiest thing to do is to make it a reference object.
 *   It's important to be clear on what immutable means.If you have a money class with a currency and a value,that's usually
 * an immutable value object.That does not mean your salary can't change.It means that to change you salary,you need to replace
 * the existing money object with a new money object rather than changing the amount on an exiting money object.Your relationship
 * can change,but money object itself doesn't.
 */
public class Currency {

    private String code;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
