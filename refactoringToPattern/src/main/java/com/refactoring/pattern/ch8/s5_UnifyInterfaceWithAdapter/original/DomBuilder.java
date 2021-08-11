package com.refactoring.pattern.ch8.s5_UnifyInterfaceWithAdapter.original;


import java.util.Stack;

/**
 * Unify Interface With Adapter : 通过Adapter统一接口
 * 	概要
 * 		客户代码与两个类交互，其中一个类具有首选接口
 * 		用Adapter统一接口
 * 			条件
 * 				两个类所做的事情相同或相似，但是具有不同的接口
 * 				如果类共享同一个接口，客户代码会更简单、更直接、更紧凑
 * 				无法轻易改变其中一个类的接口，因为它是第三方类库的一部分，或者它是一个已经被其他代码广泛使用的框架的一部分。或者无法获得源代码
 * 	优点
 * 		使客户代码可以通过相同的接口与不同的类进行交互，从而减少重复代码
 * 		使客户代码可以通过公共接口与多个对象交互，从而简化客户代码
 * 		统一了客户代码与不同的类的交互方式
 * 	缺点
 * 		当类的接口可以改变的时候，会增加设计的复杂度
 * 	做法
 * 		1.客户代码更愿意使用一个接口，而不是另一个，而且，客户代码希望可以通过一个公共的接口与两个类交互。在具有客户代码首选接口的类上应用Extract Interface生成一个公共接口。更新这个类中所有的接收自身类型为参数的方法，使其参数类型变为公共接口
 * 		2.在使用被适配者的客户类中，应用Extract Class产生一个适配器(adapter，包含一个类型为被适配者的字段，该字段的获取方法，以及设置方法或可以设置其值的构造函数)
 * 		3.把客户类中所有类型为适配者的字段、本地变量或参数类型都更新为适配器。这包括更新适配者的客户代码先从适配器获得被适配者的引用，然后再调用被适配者的方法
 * 		4.对任何客户代码（通过适配器的访问方法）调用相同被适配者方法的的地方，应用Extract Method以便产生一个被适配者调用方法。用一个被适配者参数化这个被适配者调用方法，并使该方法使用这个参数调用被适配者的方法。
 * 		5.在被适配者调用方法上应用Move Method把它从客户代码搬移到适配器中。客户代码中每处对这个适配者方法的调用现在都应该通过这个适配器
 * 		6.更新适配器，使其正式的”实现“这个公共接口，把适配器中所有接收适配类型的参数的方法修改为接收公共接口类型
 * 		7.更新客户代码，把所有类型为适配类型的字段、本地变量和参数都改为使用公共接口类型
 * 			现在客户代码就可以使用公共的接口与两个类交互了。如果想进一步去除客户代码中的重复，可以应用Form Template Method和Factory Method引入多态创建
 */
public class DomBuilder extends AbstractBuilder {
    public static final String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";
    private Document document;
    private Element root;
    private Element parent;
    private Element current;
    private Stack history;

    public void addAttribute(String name,String value){
        current.setAttribute(name,value);
    }
    public void addBelow(String child){
        Element childNode = document.createElement(child);
        current.appendChild(childNode);
        parent = current;
        current = childNode;
        history.push(current);
    }
    public void addBeside(String sibling){
        if(current==root){
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        }
        Element siblingNode = document.createElement(sibling);
        parent.appendChild(siblingNode);
        current = siblingNode;
        history.pop();
        history.push(current);
    }
    public void addValue(String value){
        current.appendChild(document.createTextNode(value));
    }

}
