package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class StringParser {

    private StringBuffer textBuffer;
    private String textBegin;

    public Node find(NodeReader reader, String input, int position, boolean balance_quotes){
        return new StringNode(textBuffer,textBegin,reader.getParser().shouldDecodeNodes());
    }
}
