package com.refactoring.pattern.ch6.s2_extractFactory.original;

/**
 * Extract Factory:将创建知识搬移到Factory
 * 概要：
 * 用来实例化一个类的数据和代码在多个类中到处都是
 * 将有关创建的知识搬移到一个Factory类中
 * 动机：
 * 创建蔓延:创建代码远离客户端代码，使用蛮力创建，客户端代码将配置选项传递给一个对象，后者将选项再传递给另一个对象，后者继续传递直至创建代码通过更多对象获得配置该对象所需的信息。创建代码和数据散步各处创建代码远离客户端代码，使用蛮力创建，客户端代码将配置选项传递给一个对象，后者将选项再传递给另一个对象，后者继续传递直至创建代码通过更多对象获得配置该对象所需的信息。创建代码和数据散步各处
 * 优点：
 * 合并创建逻辑和实例化/配置选项
 * 将客户代码与创建代码逻辑解耦
 * 缺点：
 * 如果可以直接实例化，会使设计变得复杂
 * 步骤：
 * 1.实例化类就是一个与其他类合作实例化产品（某个类的实例）的类。如果实例化类没有使用Creation Mehtod实例化产品，就需要修改，而且如果必要，还应该修改产品的类
 * 2.创建一个将成为工厂的新类，根据工厂所创建的产品给它命名（如NodeFactory，LoanFactory）
 * 3.应用Move Method将Creation Method搬移到工厂类中。如果Creation Method是静态，可以在搬移到工厂类之后改为非静态的。
 * 4.将实例化类更新为新的工厂对象，并调用工厂对象获取实例，对任何第（3）步中的修改而不再能够编译的实例化类重复这一步骤。
 * 5.在实例化中仍然使用其他类的数据和方法。将可用的任何东西搬移到工厂类中，这样就能够尽可能多的处理创建工作。这可能需要搬移实例化工厂的位置和实例化类。
 */
public class StringParser {
    public Node find(){
        StringBuffer textBuffer = new StringBuffer();
        int textBegin = 1;
        int textEnd = 10;
        Parser parser =new Parser();
        return StringNode.createStringNode(textBuffer,textBegin,textEnd,parser.shouldDecodeNodes());
    }

    private boolean shouldDecodeNode() {
    return true;
    }
}
