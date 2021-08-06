package com.refactoring.pattern.ch7.s1_composedMethod.original;

/**
 * Composed Method:组合方法
 * 	概要
 * 		你无法迅速理解一个方法的逻辑
 * 		把方法的逻辑转换成几个同一细节层面上的、能够说明意图的步骤
 * 	优点
 * 		清晰的描述了一个方法所实现的功能及如何实现
 * 		把方法分解成命名良好的、处在细节的同一层次上的行为模块，以此来简化方法
 * 	缺点
 * 		可能会产生很多小方法
 * 		可能会使调试变的困难因为逻辑分散在许多小方法中
 * 	做法
 * 		1.Composed Method都很小，很少超过10行，一般5行
 * 		2.删除重复代码和死代码
 * 		3.表达意图。清晰的命名变量、方法和参数
 * 		4.使细节处在同一层次。
 */
public class List {
    private boolean readOnly;
    private int size;
    private Object[] elements;

    public void add(Object element){
        if(!readOnly){
            int newSize = size+1;
            if(newSize>elements.length){
                Object[] newElements = new Object[elements.length+10];
                for (int i = 0; i < size; i++) {
                    newElements[i]= elements[i];
                }
                elements = newElements;
            }
            elements[size++] = element;
        }
    }
}
