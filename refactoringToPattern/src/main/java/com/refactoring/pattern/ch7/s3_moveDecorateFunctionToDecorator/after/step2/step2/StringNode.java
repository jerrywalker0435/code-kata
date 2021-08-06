package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2.step2;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class StringNode extends Node {
    private boolean shouldDecode = false;
    private StringBuffer textBuffer;
    public StringNode(StringBuffer textBuffer, String textBegin, boolean shouldDecodeNodes) {
        this.shouldDecode = shouldDecodeNodes;
    }
    public String toPlainTextString() {
      String result = textBuffer.toString();
      if(shouldDecode){
          result = Translate.decode(result);
      }
      return result;
    }
}
