package com.refactoring.pattern.ch6.s2_extractFactory.after;

public class NodeFactory {
    boolean shouldDecodeNodes = false;

    public NodeFactory() {
    }

    public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd){
        if (shouldDecodeNodes) {
            return new DecodingStringNode(new StringNode(textBuffer,textBegin,textEnd));
        }else {
            return new StringNode(textBuffer,textBegin,textEnd);
        }
    }

    public boolean shouldDecodeNodes() {
        return shouldDecodeNodes;
    }

    public void setShouldDecodeNodes(boolean shouldDecodeNodes) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }
}