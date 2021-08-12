package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;

/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public class LinkTag extends AbstractNode  {
    public String getLinkText() {
        return null;
    }

    public String getLink() {
        return null;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitLink(this);
    }
}
