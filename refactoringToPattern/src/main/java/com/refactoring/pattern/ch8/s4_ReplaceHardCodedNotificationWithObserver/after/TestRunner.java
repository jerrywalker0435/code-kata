package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.after;

import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TestRunner extends Frame implements TestListener {
    private TestResult fTestResult;
    private TestSuite testSuite;
    protected TestResult createTestResult(){
        TestResult testResult = new TestResult();
        testResult.addObserver(this);
        return testResult;
    }
    synchronized public void runSuite(){
        fTestResult = createTestResult();
        testSuite.run(fTestResult);
    }

    @Override
    public void addError(TestResult result,Test test,Throwable throwable) {
        System.out.println("E");
    }

    @Override
    public void addFailure(TestResult result,Test test,Throwable throwable) {
        System.out.println("F");
    }

    @Override
    public void endTest(TestResult testResult, Test test) {

    }
}
