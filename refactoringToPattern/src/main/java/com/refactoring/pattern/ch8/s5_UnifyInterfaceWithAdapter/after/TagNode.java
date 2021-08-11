package com.refactoring.pattern.ch8.s5_UnifyInterfaceWithAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TagNode implements XMLNode {
    public TagNode(String tagName) {

    }

    @Override
    public void add(XMLNode currentNode) {

    }

    public TagNode getParent() {
        return null;
    }

    @Override
    public void addAttribute(String name, String value) {

    }

    @Override
    public void addValue(String value) {

    }
}
