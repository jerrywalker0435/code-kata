package com.code.kata.refactoring.book.ch7.movingFeaturesBetweenObjects.moveMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class AccountType {
    public boolean isPremium() {
        return true;
    }

    double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        }
        return daysOverdrawn * 1.75;
    }
}
