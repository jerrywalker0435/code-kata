package com.refactoring.pattern.ch10.s1_CollectingParameter.original;

import java.util.Iterator;
import java.util.List;

/**
 * Collecting Parameter : 将聚集操作搬移到Collecting Parameter
 * 	概要
 * 		有一个很大的方法将信息聚集到一个局部变量
 * 		把结果聚集到一个Collecting Parameter中，将它传入被提炼出的方法
 * 	优点
 * 		帮助我们把很大的方法转换成更小的、更简单的多个方法
 * 		使结果代码运行的更快
 * 	做法
 * 		1.识别聚集方法，即把信息聚集成结果的方法。这个结果通常是一个本地变量，将会变成一个Collecting Parameter。如果结果类型不允许在方法间收集结果，就改变它的类型。如String改为StringBuffer
 * 		2.在聚集方法中，找到信息聚集的步骤，并应用Extract Method提炼到一个私有方法中，确保返回类型是void，并把结果作为参数传入方法。再提炼出的方法中，把信息写入结果
 * 		3。对信息的每一步重复步骤(2),直到原来的代码被替换为对提炼出的、接收并写入结果的方法调用为止。现在，聚集方法应该包含三行代码
 * 			实例化结果
 * 			把结果传入多个方法的第一个方法中
 * 			获得结果中收集的信息
 */
public class TagNode {

    private String tagName;
    private String attribute;
    private List children;
    private String value;

    public String toString(){
        String result = new String();
        result +="<" +tagName + " " + attribute+">";
        Iterator it =  children.iterator();
        while (it.hasNext()){
            TagNode node = (TagNode) it.next();
            result += node.toString();
        }
        if(!value.equals("")){
            result += value;
        }
        result +="</" +tagName+ ">";
        return result;
    }
}
