package com.refactoring.pattern.ch8.s2_ExtractComposite.original;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import jdk.internal.org.objectweb.asm.tree.LookupSwitchInsnNode;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class LinkTag extends Tag{
    private static final String TAGNAME = "TAGNAME";
    private Vector nodeVector;
    private Parser parsed;


    @Override
    public String toPlainTextString(){
        StringBuffer sb = new StringBuffer();
        Node node;
        for(Enumeration e = linkData(); e.hasMoreElements();){
            node=(Node) e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }
    public String toHTML(){
        StringBuffer sb = new StringBuffer();
        putLinkStartTagInto(sb);
        Node node;
        for(Enumeration e= linkData();e.hasMoreElements();){
            node = (Node) e.nextElement();
            sb.append(node.toHTML());
        }
        sb.append("</A>");
        return sb.toString();
    }

    private void putLinkStartTagInto(StringBuffer sb) {
        sb.append("<A");
        String key,value;
        int i=0;
        for(Enumeration e= parsed.keys();e.hasMoreElements();){
            key = (String) e.nextElement();
            i++;
            if(key!= TAGNAME){
                value = getParameter(key);
                sb.append(key+"=\""+value+"\"");
                if(i<parsed.size()-1){
                    sb.append(" ");
                }
            }
        }
        sb.append(">");
    }

    private String getParameter(String key) {
        return null;
    }

    private Enumeration linkData() {
        return (Enumeration) nodeVector;
    }
}
