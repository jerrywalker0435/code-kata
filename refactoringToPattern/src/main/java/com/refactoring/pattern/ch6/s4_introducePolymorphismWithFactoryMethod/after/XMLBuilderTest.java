package com.refactoring.pattern.ch6.s4_introducePolymorphismWithFactoryMethod.after;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class XMLBuilderTest extends AbstractBuilderTest {

    @Override
    protected OutputBuilder createBuilder(String rootName) {
        return new XMLBuilder(rootName);
    }
}
