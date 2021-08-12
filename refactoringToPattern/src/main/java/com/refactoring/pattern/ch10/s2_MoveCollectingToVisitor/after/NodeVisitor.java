package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;

/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public interface NodeVisitor {
    void visitTag(Tag tag);

    void visitEndTag(EndTag endTag);

    void visitLink(LinkTag link);

    void visitStringNode(StringNode stringNode);
}
