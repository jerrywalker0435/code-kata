package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class DecodingNode implements Node  {

    private Node delegate;


    public DecodingNode(StringNode delegate) {
        this.delegate = delegate;
    }


    @Override
    public String toHtml() {
        return delegate.toHtml();
    }
    @Override
    public String toPlainTextString() {
        return Translate.decode(delegate.toPlainTextString());
    }
}
