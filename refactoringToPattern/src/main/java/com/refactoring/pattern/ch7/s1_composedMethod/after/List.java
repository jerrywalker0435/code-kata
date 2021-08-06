package com.refactoring.pattern.ch7.s1_composedMethod.after;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class List {
    public static final int GROWTH_INCREMENT = 10;
    private boolean readOnly;
    private int size;
    private Object[] elements;

    public void add(Object element){
        if (readOnly) {
            return;
        }
        if(atCapacity()){
            grow();
        }
        addElement(element);
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length+ GROWTH_INCREMENT];
        for (int i = 0; i < size; i++) {
            newElements[i]= elements[i];
        }
        elements = newElements;
    }

    private boolean atCapacity() {
        return size+1 >elements.length;
    }
}
