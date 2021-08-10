package com.refactoring.pattern.ch7.s4_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class PermissionRequested extends PermissionState {
    public PermissionRequested(String name) {
        super(name);
    }

    @Override
    void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
        systemPermission.willBeHandledBy(admin);
        systemPermission.setState(CLAIMED);
    }
}
