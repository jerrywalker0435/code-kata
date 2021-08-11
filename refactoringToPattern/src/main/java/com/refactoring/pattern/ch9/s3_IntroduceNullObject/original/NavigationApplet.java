package com.refactoring.pattern.ch9.s3_IntroduceNullObject.original;

import java.applet.Applet;
import java.awt.*;

/**
 * Introduce Null Object : 引入Null Object
 * 	概要
 * 		代码中到处都是处理null字段或变量的重复逻辑
 * 		将null逻辑替换为一个Null Object，一个提供正确null行为的对象
 * 	优点
 * 		不需要重复的null逻辑就可以避免null的错误
 * 		通过最小化null检查简化了代码
 * 	缺点
 * 		当系统不太需要null检查的时候，会增加设计复杂度
 * 		如果程序员不知道Null Object的存在，就会产生多余的null检查
 * 		使维护变得复杂，拥有超类的Null Object必须重写所有的新继承到的公共方法
 * 	做法
 * 		1.在源类上应用Extract Subclass或使新类实现源类的接口来创建一个null对象。如果决定令null对象实现一个接口，但接口不存在，就在源类上应用Extract Interface创建这个接口。
 * 	    2.寻找null检查。在null对象中重写被调用的方法，使它实现特定的行为
 *  	3.对与源类相关联的其他null检查重复步骤(2)
 *  	4.找出一次或多次出现null检查的类，并用null对象的实例初始化null检查中引用的字段或本地变量。在类实例的最早时刻执行这一初始操作
 *  	5.在步骤(4)中选中的类中，删除所有的null检查
 *  	6.对每个含有一次或多次null检查的类重复步骤(4)(5)
 */
public class NavigationApplet extends Applet {

    private MouseEventHandler mouseEventHandler;
    private String graphicsContext;
    public boolean mouseMove(Event event,int x,int y){
        if(mouseEventHandler==null){
            return mouseEventHandler.mouseMove(graphicsContext,event,x,y);
        }
        return true;
    }
    public boolean mouseDown(Event event,int x,int y){
        if(mouseEventHandler==null){
            return mouseEventHandler.mouseDown(graphicsContext,event,x,y);
        }
        return true;
    }
    public boolean mouseUp(Event event,int x,int y){
        if(mouseEventHandler==null){
            return mouseEventHandler.mouseUp(graphicsContext,event,x,y);
        }
        return true;
    }
    public boolean mouseExit(Event event, int x, int y){
        if(mouseEventHandler==null){
            return mouseEventHandler.mouseExit(graphicsContext,event,x,y);
        }
        return true;
    }
}
