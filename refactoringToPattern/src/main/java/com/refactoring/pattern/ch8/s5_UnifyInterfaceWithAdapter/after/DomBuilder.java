package com.refactoring.pattern.ch8.s5_UnifyInterfaceWithAdapter.after;



import java.util.Stack;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class DomBuilder extends AbstractBuilder {
    public static final String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";
    private Document document;
    private XMLNode rootNode;
    private XMLNode parentNode;

    private XMLNode currentNode;
    private Stack history;

    public void addAttribute(String name,String value){
        currentNode.addAttribute(name, value);
    }

    public void addChild(String child){
        XMLNode childNode = new ElementAdapter(document.createElement(child), document);
        currentNode.add(childNode);
        parentNode = currentNode;
        currentNode = childNode;
        history.push(currentNode);
    }

    public void addSibling(String sibling){
        if(currentNode == rootNode){
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        }
        XMLNode siblingNode = new ElementAdapter(document.createElement(sibling), document);
        parentNode.add(siblingNode);
        currentNode = siblingNode;
        history.pop();
        history.push(currentNode);
    }
    public void addValue(String value){
        currentNode.addValue(value);
    }

}
