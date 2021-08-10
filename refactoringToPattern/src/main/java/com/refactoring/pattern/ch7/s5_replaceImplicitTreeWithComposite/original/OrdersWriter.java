package com.refactoring.pattern.ch7.s5_replaceImplicitTreeWithComposite.original;

/**
 * Replace Implicit Tree With Composite : 用Composite替换隐含树
 * 	概要
 * 		用原生表示法(如String)隐含的形成了树形结构
 * 		用Composite替换这个原生表示法
 * 	优点
 * 		封装重复的指令，如格式化、添加或删除节点
 * 		提供了处理相似逻辑增长的一般性方法
 * 		简化了客户端代码的构造职责
 * 	缺点
 * 		当构造隐式树更简单时，会增加设计的复杂度
 * 	做法
 * 		1.识别隐式叶子，即隐式树中可以被建模为新类的部分。这个新类就是叶子节点。应用Extract Class或类似重构创建这个叶子节点类。
 * 			如果叶子节点中包含属性，在叶子节点中也创建相同的属性。这样整个叶子节点的表示，包括它的属性就和隐式叶子节点吻合了。
 * 		2.用叶子节点的实例替换隐式叶子的每一次使用，这样隐式树就不再依赖隐式叶子而依赖叶子节点了
 * 		3.对隐式树中其他可以表示隐式叶子的部分重复(1)(2).确保创建的所有叶子节点都共享一个统一的接口。可以应用Extract Superclass或Extract Interface来生成这个接口
 * 		4.识别隐式双亲，即隐式树中作为隐式叶子双亲的部分。隐式双亲将要变成双亲节点类。
 * 			客户代码必须能够为双亲节点添加叶子节点，要么通过构造函数，要么通过add(..)方法。双亲节点必须统一的对待所有子节点。
 * 		5.用双亲节点的实例替换隐式双亲的每一次使用，并用正确的叶子节点实例进行配置。
 * 		6.对其他隐式双亲重复步骤(4)(5)。当且仅当隐式双亲支持的情况下，才允许为双亲节点添加双亲节点
 */
public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }


    private void writeOrderTo(StringBuffer xml) {
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<oder");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml,order);
            xml.append("</order>");
        }
        xml.append("</orders>");
    }

    private void writeProductsTo(StringBuffer xml, Order order) {
        for (int i = 0; i < order.getProductCount(); i++) {
            Product product = order.getProduct(i);
            xml.append("<product");
            xml.append(" id='");
            xml.append(product.getId());
            xml.append("'");
            xml.append(" color='");
            xml.append(colorFor(product));
            xml.append("'");
            if(product.getSize()!=ProductSize.NOT_APPLICABLE){
                xml.append(" size='");
                xml.append(sizeFor(product));
                xml.append("'");
            }
            xml.append(">");
            writePriceTo(xml,product);
            xml.append(product.getName());
            xml.append("</product>");

        }
    }

    private void writePriceTo(StringBuffer xml, Product product) {
        xml.append("<price");
        xml.append(" currency='");
        xml.append(currencyFor(product));
        xml.append("'>");
        xml.append(product.getPrice());
        xml.append("</price>");
    }

    private String currencyFor(Product product) {
        return null;
    }

    private String sizeFor(Product product) {
        return null;
    }

    private String colorFor(Product product) {
        return null;
    }
}
