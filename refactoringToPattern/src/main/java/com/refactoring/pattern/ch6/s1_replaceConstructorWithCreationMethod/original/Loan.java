package com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.original;

import com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategy;
import com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategyRCTL;
import com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategyRevolver;
import com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategyTermLoan;

import java.util.Date;

/**
 * Creation Method
 * 类中有多个构造函数，很难决定在开发期间调用哪个
 * 用能够说明意图的返回对象实例的Creation Method替换构造函数
 * 步骤
 * 1.找出全包含构造函数(功能完整的构造函数），其他构造函数可以向它委托任务。如果没有全包含构造函数，则通过链构造函数重构创建一个
 * 2.找出通过调用类的构造函数来创建实例的那个客户代码。对构造函数调用Extract Method重构，生成一个公共的，静态的函数。这个函数就是一个Creation Method.然后用Move Method 将Creation Method搬移到包含所选构造函数的类中
 * 3.找出调用所选构造函数来创建实例（与Creation Method实例化的相同）的所有代码，将它们更新为调用Creation Method
 * 4.如果所选的构造函数链接到另一个构造函数，让Creation Method调用被链接的构造函数，而不是所选构造函数。这可以通过Inline Constructor Method实现。
 * 5.对类中每个要转为Creation Method的构造函数重复步骤1-3
 * 6.如果类中的某个构造函数在类外无调用，将它改为私有的
 */
public class Loan {
    /**
     * 支持7种贷款
     * 为什么不将Loan设计成抽象类，用子类表示各种贷款
     * 1.区分不同种类的贷款不是由它的字段决定的，而是由资金(capital)、收益(income)和期限(duration)等值决定的
     * 2.Loan实例需要再不同的种类的贷款中间进行转换
     */
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategy capitalStrategy;

    public Loan(double commitment,  int riskRating, Date maturity) {
        this(commitment,0.00,riskRating,maturity,null);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null,commitment,outstanding,riskRating,maturity,expiry);
    }
    public Loan( double commitment,int riskRating, Date maturity, Date expiry) {
        this(commitment,0.00,riskRating,maturity,expiry);
    }
    public Loan(com.refactoring.pattern.ch6.s1_replaceConstructorWithCreationMethod.after.CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy,commitment,0.00,riskRating,maturity,expiry);
    }
    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        if(capitalStrategy==null){
            if(expiry==null){
                //定期贷款
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if(maturity==null){
                //循环贷款
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                //循环信用定期贷款 revolving credit term loan
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        }
    }


}
