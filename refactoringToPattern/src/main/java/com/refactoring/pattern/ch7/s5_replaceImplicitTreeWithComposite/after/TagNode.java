package com.refactoring.pattern.ch7.s5_replaceImplicitTreeWithComposite.after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class TagNode {
    private String name = "";
    private String value = "";
    private StringBuffer attributes;
    private List<TagNode> children;

    public TagNode(String name) {
        this.name = name;
        attributes = new StringBuffer("");
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    public void addValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String result = "<" + name + attributes + ">";
        Iterator it = children().iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            result += node.toString();
        }
        result += value;
        result += "</" + name + ">";
        return result;
    }

    private List<TagNode> children() {
        if (children==null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void add(TagNode child) {
        children().add(child);
    }
}
