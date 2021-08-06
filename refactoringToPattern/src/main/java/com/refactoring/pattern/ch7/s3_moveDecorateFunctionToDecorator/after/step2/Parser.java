package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class Parser {
    private boolean shouldDecodeNodes = false;
    public static Parser createParser(String stringToParser) {
        return null;
    }

    public NodeIterator elements() {
        return null;
    }

    public void setNodeDecoding(boolean shouldDecodeNodes) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }

    public boolean shouldDecodeNodes() {
        return shouldDecodeNodes;
    }
}
