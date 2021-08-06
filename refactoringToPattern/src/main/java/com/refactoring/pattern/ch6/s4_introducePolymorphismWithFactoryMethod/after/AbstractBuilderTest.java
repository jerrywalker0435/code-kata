package com.refactoring.pattern.ch6.s4_introducePolymorphismWithFactoryMethod.after;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public abstract class AbstractBuilderTest {
    private OutputBuilder builder;

    public void testAddAboveRoot(){
        String invalidResult = "<orders>" +
                "<order>" +
                "</order>" +
                "</orders>" +
                "<customer>" +
                "</customer>";
        builder = createBuilder("orders");
        builder.addBelow("order");
        try{
            builder.addAbove("customer");
            fail("expecting java.lang.RuntimeException");
        }catch (RuntimeException ignore){

        }
    }

    protected abstract OutputBuilder createBuilder(String rootName);
}
