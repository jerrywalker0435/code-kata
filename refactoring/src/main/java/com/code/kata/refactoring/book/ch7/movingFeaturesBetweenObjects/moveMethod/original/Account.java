package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.moveMethod.original;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class Account {
    /**
     * Move Method
     * A method is, or will be, using or used by more features of another class than on witch it is defined.
     * Create a new method with similar body in the class it uses most.Either turn the old method into a simple delegation,
     * or remove it altogether.
     * Motivation
     * Moving methods is the bread and butter of refactoring. I move methods when classes have too much behavior or when
     * classes are collaborating too much and too highly coupled. By moving method around, I can make the classes simpler
     * and they end up being a more crisp implementation of a set of responsibilities.
     * I usually look through the methods on a class to find a method that seems to reference another object more than
     * the object it lives in. A good time to do this after I have moved some fields. Once I see a likely method to move,
     * I take a look at the methods that call it . the methods it calls and any redefining methods in the hierarchy. I
     * access whether to go ahead on the basis of the object with witch the method seems to have more interaction.
     * It's not always an easy decision to make. If I am not sure whether to move a method, I go on to look at other
     * methods. Moving other methods often make the decision easier. Sometimes the decision still is hard to make. Actually
     * it is then no big deal. If it is difficult to make the decision, it probably does not matter that much. Then I choose
     * according to instinct; after all, I can always change it again later.
     */


    AccountType type;
    private int daysOverdrawn;

    double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        }
        return daysOverdrawn * 1.75;
    }
    double bankCharge(){
        double result = 4.5;
        if (daysOverdrawn>0) {
            result += overdraftCharge();
        }
        return result;
    }
}
