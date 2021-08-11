package com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.original;

import com.refactoring.pattern.ch8.s4_ReplaceHardCodedNotificationWithObserver.after.TestRunner;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class TextTestResult extends TestResult{
    private TestRunner fRunner;

    public TextTestResult(TestRunner fRunner) {
        this.fRunner = fRunner;
    }
    public synchronized void addError(Test test,Throwable throwable){
        super.addError(test,throwable);
        System.out.println("E");
    }
    public synchronized void addFailure(Test test,Throwable throwable){
        super.addFailure(test,throwable);
        System.out.println("F");
    }
}
