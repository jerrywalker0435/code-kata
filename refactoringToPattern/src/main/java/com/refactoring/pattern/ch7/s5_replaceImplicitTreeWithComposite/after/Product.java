package com.refactoring.pattern.ch7.s5_replaceImplicitTreeWithComposite.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class Product {
    public String getId() {
        return null;
    }

    public ProductSize getSize() {
        return ProductSize.NOT_APPLICABLE;
    }

    public String getName() {
        return null;
    }

    public double getPrice() {
        return 0;
    }
}
