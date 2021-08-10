package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class PermissionGranted extends PermissionState{
    public PermissionGranted(String name) {
        super(name);
    }
}
