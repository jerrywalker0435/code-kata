package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;

import java.util.Iterator;

/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public class NodeIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
