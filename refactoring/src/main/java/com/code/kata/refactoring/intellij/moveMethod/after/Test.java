package com.code.kata.refactoring.intellij.moveMethod.after;

/**
 * @author zhangyu201
 * @date 2021/7/29
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Car c= new Car();
        System.out.println(new Test().getName(c));
    }

    String getName(Car car){
        System.out.print(toString());
        return car.getName();
    }
}
