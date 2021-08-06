package com.refactoring.pattern.ch6.s2_extractFactory.after;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class Parser {
    private NodeFactory nodeFactory = new NodeFactory();


    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }
}
