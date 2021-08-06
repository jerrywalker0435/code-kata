package com.refactoring.pattern.ch6.s2_extractFactory.original;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class Parser {
    private boolean shouldDecodeNodes = false;

    public boolean shouldDecodeNodes() {
        return shouldDecodeNodes;
    }

    public void setShouldDecodeNodes(boolean shouldDecodeNodes) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }
}
