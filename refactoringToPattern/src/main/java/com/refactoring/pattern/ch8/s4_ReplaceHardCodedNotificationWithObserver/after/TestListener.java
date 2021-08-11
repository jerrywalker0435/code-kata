package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public interface TestListener {
    void addError(TestResult testResult, Test test,Throwable throwable);

    void addFailure(TestResult testResult, Test test,Throwable throwable);

    void endTest(TestResult testResult, Test test);
}
