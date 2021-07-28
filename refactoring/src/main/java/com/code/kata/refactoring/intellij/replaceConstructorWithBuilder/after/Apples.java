package com.code.kata.refactoring.intellij.replaceConstructorWithBuilder.after;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Apples {
    public static void main(String[] args) {
        Variety varietyObject = new VarietyBuilder().setName("Red Delicious").createVariety();
        varietyObject.saying();
    }
}



