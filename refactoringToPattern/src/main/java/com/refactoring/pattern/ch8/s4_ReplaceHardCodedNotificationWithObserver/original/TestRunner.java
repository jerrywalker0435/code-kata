package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.original;

import java.awt.*;

/**
 * Replace Hard Coded Notification With Observer : 用Observer替换硬编码通知
 * 	概要
 * 		子类通过硬编码来通知另一个类的实例
 * 		去除这些子类，并使其超类能够通知一个或多个实现了Observer接口的类
 * 	优点
 * 		使主题及其观察者访问松散耦合
 * 		支持一个或多个观察者
 * 	缺点
 * 		当硬编码的通知已经足够的时候，会增加系统复杂度
 * 		当出现串联通知的时候，会增加代码的复杂度
 * 		当观察者没有从它们的主题中被删除的时候，可能会造成内存泄露
 * 	做法
 * 		1.如果一个通知者代表它的接收者执行定制的行为，而不是执行单纯的通知逻辑。应用Move Method把这些行为搬移到通知者的接收者中。这样，通知者就只包含通知方法了。
 * 			对所有通知者重复这一步骤
 * 		2.在接收者上应用Extract Interface，只选择被它的通知者调用的方法，产生观察者接口。如果其他通知者会调用不在观察者接口中的方法，把这些方法添加到观察者接口中，这样它就可以支持所有的接收者了
 * 		3.使每个接收者都实现观察者接口。然后，使每二个通知者都只通过观察者接口与它的接收者交互。现在每个接收者都是一个观察者。
 * 		4.选择一个通知者，在其通知方法上应用Pull Up Method，这包含上移通知者的观察者接口的引用，以及设置引用的代码。现在，通知者的超类就是这个主题了
 * 		5.更新每个通知者的观察者，使它们注册到主题并与其交互，而不是通知者，然后删除通知者。
 * 		6.重构这个主题，使它包含观察者的一个集合，而不仅仅一个观察者。这包含更新观察者注册自己到主题的方法。通常会在主题中创建一个添加观察者的方法。最后更新主题，使其通知方法通知观察者集合中的所有观察者
 */
public class TestRunner extends Frame {
    private TestResult fTestResult;
    private TestSuite testSuite;
    protected TestResult createTestResult(){
        return new UITestResult(this);
    }
    synchronized public void runSuite(){
        fTestResult = createTestResult();
        testSuite.run(fTestResult);
    }
    public void addFailure(TestResult result,Test test,Throwable throwable){


    }
}
