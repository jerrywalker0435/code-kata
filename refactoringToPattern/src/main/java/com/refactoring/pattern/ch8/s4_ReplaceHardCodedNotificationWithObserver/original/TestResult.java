package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.original;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TestResult {
    protected void addFailure(TestResult testResult, Test test, Throwable t) {

    }
    protected void addFailure(Test test, Throwable t) {

    }

    protected void addError(Test test, Throwable throwable) {

    }
}
