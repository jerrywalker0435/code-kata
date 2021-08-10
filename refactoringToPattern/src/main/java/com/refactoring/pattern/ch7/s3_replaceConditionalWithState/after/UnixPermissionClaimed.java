package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class UnixPermissionClaimed extends PermissionState{
    public UnixPermissionClaimed(String name) {
        super(name);
    }

    @Override
    void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
        if(!systemPermission.getAdmin().equals(admin)){
            return;
        }
        systemPermission.setGranted(false);
        systemPermission.setUnixPermissionGranted(false);
        systemPermission.setState(DENIED);
        systemPermission.notifyUserOfPermissionRequestResult();
    }

    @Override
    void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {

        if (!systemPermission.getAdmin().equals(admin)) {
            return;
        }
        systemPermission.setUnixPermissionGranted(true);
        systemPermission.setState(GRANTED);
        systemPermission.setGranted(true);
        systemPermission.notifyUserOfPermissionRequestResult();
    }
}
