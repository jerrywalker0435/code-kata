package com.refactoring.pattern.ch10.s1_CollectingParameter.after;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TagNode {

    private String tagName;
    private String attribute;
    private List children;
    private String value;

    public String toString() {
        StringBuffer result = new StringBuffer();
        appendContentsTo(result);
        return result.toString();
    }

    private void appendContentsTo(StringBuffer result) {
        writeOpenTagTo(result);
        writeChildrenTo(result);
        writeEndTagTo(result);
    }

    private void
    writeEndTagTo(StringBuffer result) {
        result.append("</");
        result.append(tagName);
        result.append(">");
    }

    private void writeChildrenTo(StringBuffer result) {
        Iterator it = children.iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            node.appendContentsTo(result);
        }
        writeValueTo(result);
    }

    private void writeValueTo(StringBuffer result) {
        if (!value.equals("")) {
            result.append(value);
        }
    }

    private void writeOpenTagTo(StringBuffer result) {
        result.append("<");
        result.append(tagName);
        result.append(attribute);
        result.append(">");
    }
}
