package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;


/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public class EndTag extends AbstractNode {
    public String getText() {
        return null;
    }

    public String getName() {
        return null;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitEndTag(this);
    }
}
