package com.refactoring.pattern.ch8.s5_UnifyInterfaceWithAdapter.after;

public class ElementAdapter implements XMLNode{
    private final Element element;
    private final Document document;

    public ElementAdapter(Element element, Document document) {
        this.element = element;
        this.document = document;
    }


    public Element getElement() {
        return element;
    }


    @Override
    public void add(XMLNode currentNode) {
        ElementAdapter childNode = (ElementAdapter)currentNode;
        getElement().appendChild(childNode.getElement());

    }

    public void addAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    public void addValue(String value) {
        getElement().appendChild(document.createTextNode(value));
    }
}
