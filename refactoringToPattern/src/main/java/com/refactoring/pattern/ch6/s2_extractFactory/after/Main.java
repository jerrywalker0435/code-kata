package com.refactoring.pattern.ch6.s2_extractFactory.after;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class Main {
    public static void main(String[] args) {
        NodeFactory decodeNodes = new NodeFactory();
        decodeNodes.setShouldDecodeNodes(true);
        Parser parser = new Parser();
        parser.setNodeFactory(decodeNodes);
    }
}
