package com.refactoring.pattern.ch6.s5_encapsulateCompositeWithBuilder.original;

import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class TagNode {
    private TagNode parent;
    private String name;
    public TagNode(String rootTagName) {
        this.name = rootTagName;
    }

    public void add(TagNode childNode) {
        childNode.setParent(this);
        children().add(childNode);
    }

    private <E> List children() {
        return null;
    }

    private void setParent(TagNode parent) {
        this.parent = parent;
    }

    public TagNode getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}
