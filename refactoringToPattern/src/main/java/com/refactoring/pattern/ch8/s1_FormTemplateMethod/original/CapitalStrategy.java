package com.refactoring.pattern.ch8.s1_FormTemplateMethod.original;

/**
 * Form Template Method : 形成Template
 * 	概要
 * 		子类中的两个方法以相同的顺序执行相似的步骤，但是步骤并不相同
 * 		通过把这些步骤提取成相同签名的方法来泛化这两个方法，然后上移这些泛化方法，形成Template Method
 * 	优点
 * 		通过把不变的行为搬移到超类，去除子类中重复的代码
 * 		简化并有效的表达了一个通用算法的步骤
 * 		允许子类很容易的定制一个算法
 * 	缺点
 * 		当为了生成算法、子类必须实现很多方法的时候，会增加设计的复杂度
 * 	做法
 * 		1.在一个类层次中，找到一个相似方法(similar method,子类中的一个方法，它与另一个子类中的方法以相似的顺序执行相似的步骤)。在相似的方法上应用Composed Method重构，提取出同一方法(每个子类中具有相同的签名和方法体的方法)和唯一方法（每个子类中具有不同签名和方法体的方法)
 * 			在考虑是否把代码提取为唯一方法或同一方法时，需要做出如下考虑：如果代码提取为唯一方法，最后需要在超类中产生这个唯一方法的抽象的或具体的版本。对子类来说，继承或重写这个唯一方法有意义吗？如果不是，请把方法提取为同一方法。
 * 		2.应用Pull Up Method，把同一方法移到超类中
 * 		3.为了为相似方法的每个版本产生相同的方法体，在每个唯一方法上应用Rename Method,直到每个子类中的相似方法相同为止。
 * 		4.如果相似方法在每个子类中还没有一个相同的签名，应用Change Method Signatrue
 * 		5.在相似方法上应用Pull Up Method,在超类中为每一个唯一方法定义抽象方法。现在，被移上来的相似方法就是一个Template Method
 */
public abstract class CapitalStrategy {
    public abstract double capital(Loan loan);
}
