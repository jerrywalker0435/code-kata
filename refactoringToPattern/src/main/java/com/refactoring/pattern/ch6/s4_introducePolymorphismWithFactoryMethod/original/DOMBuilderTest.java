package com.refactoring.pattern.ch6.s4_introducePolymorphismWithFactoryMethod.original;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

/**
 * Introduce Polymorphism With Factory Method:用Factory Method引入多态
 * 	概要
 * 		一个层次中的类都相似的实现一个方法，只是对象创建的步骤不同
 * 		创建调用Factory Method来处理实例化的方法的唯一超类版本
 * 	动机
 * 		1.当兄弟子类实现了除对象创建步骤外都很相似的方法时
 * 		2.当超类和子类实现了除对象创建步骤外都很相似的方法时。
 * 	优点
 * 		减少因创建自定义对象而产生的重复代码
 * 		有效的表达了对象创建的位置，以及如何重写对象的创建
 * 		强制Factory Method使用类的必须实现统一的类型
 * 	缺点
 * 		可能会向Factory Method的一些实现者传递不必要的参数
 * 	做法
 * 		1.在包含相似方法的子类中修改这一方法，以便通过调用实例化方法来完成自定义对象的创建。通常情况下，在创建代码上应用Extract Method或把创建代码改为对已经存在的实例化方法的调用可以完成这一步。给实例化方法起个通用的名字，如CreateBuilder、newProduct.确保返回类型为通用类型
 * 		2.对所有兄弟子类中重复步骤(1),且保持签名一致
 * 		3.接着修改兄弟类的超类。如果不能或不想修改，应用Extract Superclass生成一个新超类
 * 	    4.在相似方法上应用Form Template Method
 * 	    5.如果兄弟子类中存在其他的相似的、能够从调用之前产生的工厂方法中获益的相似方法，重复步骤(1)-(4)
 * 	    6.如果大多数Concrete中的工厂方法都包含相同的实例化代码，上移这些代码，把超类声明成抽象的方法改成具体的方法，并使它执行默认的实例化行为
 * @author zhangyu201
 * @date 2021/8/5
 */
public class DOMBuilderTest {
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

    private OutputBuilder createBuilder(String rootName) {
        return new XMLBuilder(rootName);
    }
}
