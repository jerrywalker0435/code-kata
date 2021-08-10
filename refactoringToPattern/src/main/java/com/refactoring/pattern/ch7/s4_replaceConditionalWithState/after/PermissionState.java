package com.refactoring.pattern.ch7.s4_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class PermissionState {


    private final String name;

    public final static PermissionState REQUESTED = new PermissionRequested("REQUESTED");
    public final static PermissionState CLAIMED = new PermissionClaimed("CLAIMED");
    public final static PermissionState GRANTED = new PermissionGranted("GRANTED");
    public final static PermissionState DENIED = new PermissionDenied("DENIED");
    public final static PermissionState UNIX_REQUESTED = new UnixPermissionRequested("UNIX_REQUESTED");
    public final static PermissionState UNIX_CLAIMED = new UnixPermissionClaimed("UNIX_CLAIMED");

    public PermissionState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {}

    void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
    }

    void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {
    }
}
