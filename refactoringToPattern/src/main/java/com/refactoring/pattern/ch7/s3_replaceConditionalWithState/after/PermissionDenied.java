package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class PermissionDenied extends PermissionState{
    public PermissionDenied(String name) {
        super(name);
    }
}
