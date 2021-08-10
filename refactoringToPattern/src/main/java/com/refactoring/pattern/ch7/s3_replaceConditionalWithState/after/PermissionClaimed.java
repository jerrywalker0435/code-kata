package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class PermissionClaimed extends PermissionState{
    public PermissionClaimed(String name) {
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
        if (systemPermission.getProfile().isUnixPermissionRequired() && !systemPermission.isUnixPermissionGranted()) {
            systemPermission.setState(UNIX_REQUESTED);
            systemPermission.notifyAdminsPermissionRequest();
            return;
        }
        systemPermission.setState(GRANTED);
        systemPermission.setGranted(true);
        systemPermission.notifyUserOfPermissionRequestResult();
    }
}
