package com.refactoring.pattern.ch6.s4_introducePolymorphismWithFactoryMethod.after;


/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class DOMBuilderTest extends AbstractBuilderTest {

    @Override
    protected OutputBuilder createBuilder(String rootName) {
        return new DOMBuilder(rootName);
    }
}
