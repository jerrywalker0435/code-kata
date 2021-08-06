package com.refactoring.pattern.ch6.s1_creationMethod.after;

import java.util.Date;

/**
 * Creation Method
 * 概要：
 * 类中有多个构造函数，很难决定在开发期间调用哪个
 * 用能够说明意图的返回对象实例的Creation Method替换构造函数
 * 动机：
 * 构造函数无法有效的和高效的表达意图。拥有的构造函数越多，程序员越容易选择错误的构造函数
 * 优点：
 * 比构造函数更好的表达所创建的实例的种类
 * 避免了构造函数的局限性，比如两个构造函数的参数数目与类型不能相同
 * 更容易发现无用的创建代码
 * 缺点：
 * 创建方式是非标准的：有些类用new实例化，有些用Creation Method实例化
 * 步骤：
 * 1.找出全包含构造函数(功能完整的构造函数），其他构造函数可以向它委托任务。如果没有全包含构造函数，则通过链构造函数重构创建一个
 * 2.找出通过调用类的构造函数来创建实例的那个客户代码。对构造函数调用Extract Method重构，生成一个公共的，静态的函数。这个函数就是一个Creation Method.然后用Move Method 将Creation Method搬移到包含所选构造函数的类中
 * 3.找出调用所选构造函数来创建实例（与Creation Method实例化的相同）的所有代码，将它们更新为调用Creation Method
 * 4.如果所选的构造函数链接到另一个构造函数，让Creation Method调用被链接的构造函数，而不是所选构造函数。这可以通过Inline Constructor Method实现。
 * 5.对类中每个要转为Creation Method的构造函数重复步骤1-3
 * 6.如果类中的某个构造函数在类外无调用，将它改为私有的
 *
 * 变体
 * 1.Parameterized Creation Method
 *   不必为每个对象配置一个Creation Method,为最常用的对象配置，再留些公共构造函数来处理其他配置，使用参数减少Creation Method也可以。
 * 2.提取Factory
 *   如果类中存在Creation Method,且Creation Method分散了类的主要职责，可以重构为一个Factory
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
    private CapitalStrategy capitalStrategy;

    public Loan(double commitment, int riskRating, Date maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        if (capitalStrategy == null) {
            if (expiry == null) {
                //定期贷款
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if (maturity == null) {
                //循环贷款
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                //循环信用定期贷款 revolving credit term loan
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        }
    }


    static Loan createTermLoan(double commitment, int riskRating, Date maturity) {
        return new Loan(commitment, riskRating, maturity);
    }

    static Loan createTermLoan(double commitment, double outstanding, int riskRating, Date maturity, CapitalStrategy riskAdjustedCapitalStrategy) {
        return new Loan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity, null);
    }

    static Loan createRevolverLoan(double commitment, double outstanding, int riskRating, Date expiry) {
        return new Loan(null, commitment, outstanding, riskRating, null, expiry);
    }

    static Loan createRevolverLoan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date expiry) {
        return new Loan(capitalStrategy, commitment, outstanding, riskRating, null, expiry);
    }

    static Loan createRCTL(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    static Loan createRCTL(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(capitalStrategy, commitment, outstanding, riskRating, maturity, expiry);
    }
}
