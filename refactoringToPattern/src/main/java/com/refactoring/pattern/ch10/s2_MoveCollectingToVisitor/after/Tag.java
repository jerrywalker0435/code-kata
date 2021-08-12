package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;

/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public class Tag extends AbstractNode {
    public String getLinkText() {
        return null;
    }

    public String getLink() {
        return null;
    }

    public String getName() {
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitTag(this);
    }
}
