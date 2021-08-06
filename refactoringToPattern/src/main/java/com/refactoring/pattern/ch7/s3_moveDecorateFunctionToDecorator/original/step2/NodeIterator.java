package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.original.step2;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class NodeIterator<T> implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
