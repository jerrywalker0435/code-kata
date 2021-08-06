package com.refactoring.pattern.ch6.s2_extractFactory.original;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class StringNode implements Node{
    public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {

    }

    public static Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode){
        if (shouldDecode) {
            return new DecodingStringNode(new StringNode(textBuffer,textBegin,textEnd));
        }else {
            return new StringNode(textBuffer,textBegin,textEnd);
        }
    }
}
