package com.refactoring.pattern.ch7.s4_replaceConditionalWithState.original;

/**
 * Replace Conditional With State: 用State替换状态改变条件语句
 * 	概要
 * 		控制一个对象状态转换的条件表达式过于复杂
 * 		用处理特殊状态的和状态转换的State类替换条件表达式
 * 	优点
 * 		减少或去除状态改变的条件逻辑
 * 		简化了复杂的状态改变的逻辑
 * 		提供了观察状态改变逻辑的很好的鸟瞰图
 * 	缺点
 * 		当状态转换逻辑易于理解时，会增加设计的复杂度
 * 	做法
 * 		1.上下文类是包含原始状态字段的类，在转换过程中，原始状态字段会被一系列常量赋值或与之比较。在原始字段上应用用类替换类型代码重构，这样它的类型就变成了一个类，称为状态超类
 * 		2.状态超类中的每个常量现在都应用这一个状态超类的一个实例。应用Extract Subclass,为每个常量产生一个子类，然后更新状态超类中的常量，使他们引用相应的子类实例。最后把超类实例声明为抽象类
 * 		3.在上下文类中找出根据状态转换逻辑来修改原始字段的方法。把这个方法复制到状态超类中，在修改最少的前提下使这个方法可以运行（一个常用的方式是把上下文类传入这个方法，以便新方法中的代码调用上下文类）。最后把上下文类的方法体替换为这个新方法的委托调用。
 * 			对上下文类中每个根据状态转换逻辑来修改原始状态的字段的方法都重复这一步骤。
 * 		4.选择上下文类能够进入的状态，然后识别出状态超类中的那些方法会使这个状态转换到其他状态。把这些识别出来的方法复制到被选择的状态相关的子类中，并去除无关的逻辑
 * 			无关的逻辑往往包含对当前状态的验证或转换到无关状态的逻辑
 * 		5.删除每个步骤(3)中被复制到状态超类中的方法体，为每个方法体留一个空实现。
 */
public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requester;
    private SystemAdmin admin;
    private boolean isGranted;

    private boolean isUnixPermissionGranted;


    private String state;

    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    private static final String UNIX_REQUESTED = "UNIX_REQUESTED";
    private static final String UNIX_CLAIMED = "UNIX_CLAIMED";


    public SystemPermission(SystemUser requester, SystemProfile profile) {
        this.profile = profile;
        this.requester = requester;
        state = REQUESTED;
        isGranted = false;
        notifyAdminsPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin){
        if(!state.equals(REQUESTED)&&!state.equals(UNIX_REQUESTED)){
            return;
        }
        willBeHandledBy(admin);
        if(state.equals(REQUESTED)){
           state = CLAIMED;
        }else if(state.equals(UNIX_REQUESTED)){
            state = UNIX_CLAIMED;
        }

    }

    public void deniedBy(SystemAdmin admin){
        if(!state.equals(CLAIMED)&&!state.equals(UNIX_CLAIMED)){
            return;
        }
        if(!this.admin.equals(admin)){
            return;
        }
        isGranted = false;
        isUnixPermissionGranted = false;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin){
        if(!state.equals(CLAIMED)&&!state.equals(UNIX_CLAIMED)){
            return;
        }
        if(!this.admin.equals(admin)){
            return;
        }
        if(profile.isUnixPermissionRequired()&&state.equals(UNIX_CLAIMED)){
            isUnixPermissionGranted = true;
        }else if(profile.isUnixPermissionRequired() && !isUnixPermissionGranted()){
            state = UNIX_REQUESTED;
            notifyAdminsPermissionRequest();
            return;
        }
        state = GRANTED;
        isGranted = true;
        notifyUserOfPermissionRequestResult();
    }

    private boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public String getState() {
        return state;
    }

    private void notifyUserOfPermissionRequestResult() {
    }

    private void willBeHandledBy(SystemAdmin admin) {
    }

    private void notifyAdminsPermissionRequest() {

    }
}
