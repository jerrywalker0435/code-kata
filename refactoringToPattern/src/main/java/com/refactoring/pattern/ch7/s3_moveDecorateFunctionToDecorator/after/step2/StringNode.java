package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2;

/**
 * Move Decorate Function to Decorator : 将装饰功能搬移到Decorator
 * 	概要
 * 		代码想类的核心职责提供装饰功能
 * 		将装饰功能搬移到Decorator
 * 	优点
 * 		把装饰功能从类中搬移出去，从而简化了类
 * 		有效的把类的核心职责和装饰功能分离开来
 * 		可以去除几个相关类中重复的装饰逻辑
 * 	缺点
 * 		改变了被装饰对象的对象类型
 * 		对于不熟悉设计模式的人来说，代码更难理解
 * 		当Decorator组合产生负面影响时，会增加设计的复杂度
 * 	做法
 * 		1.首先确定被装饰类的公共方法多不多，如果多可以使用Strategy
 * 		2.确定和创建包装类型、接口或类（超类），它声明了客户代码需要被修饰类的公共方法
 * 			包含状态的类不适合作为包装类型
 * 		3.找到为被修饰类添加装饰功能的条件逻辑(switch或if)，并应该Replace Conditional With Polymorphism去除这些逻辑
 * 			通常需要应用Replace Type Code With Subclass 或 Replace Type Code With State/Strategy
 * 		4.步骤(2)产生的一个或多个子类，应用Replace Inheritance With Delegation
 * 			使每个委托类都实现包装类型
 * 			把委托类的委托字段的类型声明为包装类型
 * 			决定装饰代码在委托类指甲钳还是之后执行
 * 		5.现在，为每个委托类都用被修饰类的新建实例对自己的委托字段进行赋值。确保这个赋值逻辑在委托类的构造函数中。然后Extract Parameter
 */
public class StringNode implements Node {
    protected StringBuffer textBuffer;
    public StringNode(){
    }
    public StringNode(StringBuffer textBuffer, String textBegin) {
    }

    public static Node createStringNode(StringBuffer textBuffer, String textBegin, boolean shouldDecodeNodes) {
        if(shouldDecodeNodes){
            return new DecodingNode(new StringNode(textBuffer, textBegin));
        }
        return new StringNode(textBuffer, textBegin);
    }

    @Override
    public String toHtml() {
        return null;
    }

    public String toPlainTextString() {
        return textBuffer.toString();
    }



}
