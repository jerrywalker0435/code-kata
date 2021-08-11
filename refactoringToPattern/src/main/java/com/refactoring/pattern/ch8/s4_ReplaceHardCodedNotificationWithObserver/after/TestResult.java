package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TestResult {
    protected TestListener fRunner;
    private List<TestListener> observers = new ArrayList<>();
    public TestResult() {

    }
//    public TestResult(TestRunner fRunner) {
//        this.fRunner = fRunner;
//    }

    protected void addFailure(TestResult testResult, Test test, Throwable throwable) {
//        fRunner.addFailure(testResult, test, t);
        for (TestListener listener : observers) {
            listener.addFailure(this,test,throwable);
        }
    }

    protected void addError(Test test, Throwable throwable) {
//        fRunner.addError(this, test, throwable);

        for (TestListener listener : observers) {
            listener.addError(this,test,throwable);
        }
    }

    protected void endTest(Test test) {
        for (TestListener listener : observers) {
            listener.endTest(this,test);
        }
    }
    public void addObserver(TestListener testListener){
        observers.add(testListener);
    }


}
