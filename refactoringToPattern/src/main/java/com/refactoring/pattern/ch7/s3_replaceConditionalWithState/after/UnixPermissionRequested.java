package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class UnixPermissionRequested extends PermissionState{
    public UnixPermissionRequested(String name) {
        super(name);
    }

    @Override
    void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
        systemPermission.willBeHandledBy(admin);
        systemPermission.setState(UNIX_CLAIMED);
    }
}
