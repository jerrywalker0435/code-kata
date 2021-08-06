package com.refactoring.pattern.ch6.s3_encapsulateWithFactory.original;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Encapsulate With Factory : 3.用Factory封装类
 * 	概要
 * 		直接实例化处存在同一包结构中，实现同一接口的多个类
 * 		把类的告知函数声明为非公共的，并通过Factory来创建它们的实例
 * 	动机
 * 		只有客户端需要确切知道一些类的存在，直接实例化才有意义。如果客户端不需要知道同一个包结构中都实现同一接口，且不太会发生改变的类。可以通过Factory把这些类与包外的客户端隔离开来，Factory返回超类即可
 * 	优点
 * 		通过意图导向的Creation Method简化了不同种类实例的创建
 * 		通过隐藏不需要公开的类减少了包结构的”概念重量“
 * 		帮助严格执行”面向接口编程，而不是面向实现“
 * 	缺点
 * 		当需要创建新种类的实例时，必须新建/更新Creation Method
 * 		当客户只能获得Factory的二进制代码而无法获得源码时，对Factory的定制会受到限制
 * 	做法
 * 		1.找到调用类的构造函数来创建实例的一段客户代码。对构造函数调用应用Extract Method,生成一个公共的、静态的方法。这个新方法就是Creation Method。然后搬移函数，将Creation Method搬移到所选构造函数的类的超类中
 * 		2.找出调用所选构造函数来创建相同实例的所有代码，将它们更新为调用Creation Method
 * 		3.对可能使用类的构造函数创建所有类型的实例重复(1)-(2)
 * 		4.把构造函数声明为非公共的
 * 		5.对所有需要封装的类重复步骤(1)-(4)
 */
public class Main {

    protected List<AttributeDescriptor> createAttributeDescriptor(){
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(new DefaultDescriptor("remoteId",getClass(),Integer.TYPE));
        result.add(new DefaultDescriptor("createdDate",getClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate",getClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy",getClass(), User.class));
        result.add(new ReferenceDescriptor("lastChangedBy",getClass(), User.class));
        result.add(new DefaultDescriptor("optimisticLockVersion",getClass(), Integer.TYPE));
        return result;
    }
}
