package com.refactoring.pattern.ch8.s5_UnifyInterfaceWithAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public interface XMLNode {
    void add(XMLNode currentNode);

    void addAttribute(String name, String value);

    void addValue(String value);
}
