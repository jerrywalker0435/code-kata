package com.refactoring.pattern.ch7.s2_replaceConditionalWithStrategy.original;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 2.用Strategy替换条件逻辑
 * 	概要
 * 		方法中条件逻辑控制应该执行计算的那个变体
 * 		为每个变体创建一个Strategy并使方法计算委托到Strategy的实例
 * 	优点
 * 		通过减少或去除条件逻辑使算法变得清晰易懂
 * 		通过把算法的变体搬移到类层次中简化了类
 * 		运行在运行时用一种算法替换另一种算法
 * 	缺点
 * 		当应用基于继承的解决方案或”简化条件表达式“[F]中的重构更简时，会增加设计的复杂度
 * 		增加了算法如何获取或接收上下文类的数据的复杂度
 * 	做法
 * 		1.创建一个策略(Strategy),根据计算方法的行为命名，可以在类名添加后缀Strategy
 * 		2.应用Move Method把计算方法搬移到策略类中。执行这一步时，在上下文类中保留一个这样的计算方法，把它委托给策略类中的计算法方法。实现这一委托会涉及定义和实例化一个策略实例
 * 			策略类中使用相关数据的做法
 * 				a.把上下文作为参数传入策略类的构造方法或计算方法。缺点：破坏信息隐藏。优点：上下文中的新增公共方法和变量可以不用改动即可感知。
 * 				b.通过计算方法的参数把需要的数据从上下文传递到策略类。优点：最小耦合上下文类。缺点：参数过多，感知新增要修改代码
 * 		3.通过在实例化具体策略类并把赋值给委托的上下文代码上应用Extract Parameter,使客户用具体的策略类实例装配上下文类。
 * 		4.在策略类的计算方法上应用Replace Conditional With Polymorphism，为了应用这一重构，首先要使用Replace Type Code With Subclass或 Replace Type Code With State/Strategy。每次只产生一个子类，如果可能的话，把策略类声明为抽象类。
 */
public class Loan {
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private List<Payment> payments;
    public double capital(){
        if (expiry==null && maturity!=null){
            return commitment * duration()* riskFactor();
        }
        if(expiry!=null&& maturity==null){
            if(getUnusedPercentage()!=1.0){
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            }else {
                return (outstandingRiskAmount()* duration() * riskFactor()) + (unusedRiskAmount()*duration()*unusedRiskFactor());
            }
        }
        return 0.0;
    }

    private double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }

    private double unusedRiskAmount() {
        return commitment - outstanding;
    }

    private double outstandingRiskAmount() {
        return outstanding;
    }

    private double getUnusedPercentage() {
        return 0;
    }

    private double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    private double duration() {
        if(expiry == null && maturity!=null){
            return weightedAveragedDuration();
        }else if(expiry !=null && maturity == null){
            return yearsTo(expiry);
        }
        return 0.0;
    }

    private double yearsTo(Date expiry) {
        return 0;
    }

    private double weightedAveragedDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator<Payment> loanPayments = payments.iterator();
        while (loanPayments.hasNext()){
            Payment payment = loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date())*payment.amount();
        }
        if(commitment!=0.0){
            duration = weightedAverage /sumOfPayments;
        }
        return duration;
    }
}
