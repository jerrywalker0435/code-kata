package com.refactoring.pattern.ch8.s2_ExtractComposite.original;

import com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2.Parser;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class FormTag extends Tag{
    protected Vector allNodesVector;
    private String formName;
    private String formURL;
    private String formMethod;
    private List children;

    public String toPlainTextString() {
        StringBuffer stringRepresentation = new StringBuffer();
        Node node;
        for (Enumeration e = getAllNodesVector().elements(); e.hasMoreElements();){
            node = (Node) e.nextElement();
            stringRepresentation.append(node.toPlainTextString());
        }
        return stringRepresentation.toString();
    }
    public String toHTML(){
//        StringBuffer rawBuffer = new StringBuffer();
//        Node node,prevNode=null;
//        rawBuffer.append("<FORM METHOD=\""+formMethod+"\" ACTION=\""+formURL+"\"");
//        if(formName!=null&& formName.length()>0){
//            rawBuffer.append(" NAME=\""+formName+"\"");
//        }
//        Enumeration e = children.;
//
//        sb.append("</A>");
//        return rawBuffer.toString();
        return null;
    }

    private Vector<Object> getAllNodesVector() {
        return allNodesVector;
    }
}
