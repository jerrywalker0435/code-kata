package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.original;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class UITestResult extends TestResult {
    private TestRunner fRunner;

    public UITestResult(TestRunner fRunner) {
        this.fRunner = fRunner;
    }

    public synchronized void addFailure(Test test,Throwable t){
        super.addFailure(this,test,t);
    }
}
