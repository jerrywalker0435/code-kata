package com.refactoring.pattern.ch7.s4_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requester;
    private SystemAdmin admin;
    private boolean isGranted;
    private boolean isUnixPermissionGranted;
    private PermissionState state;


    public SystemPermission(SystemUser requester, SystemProfile profile) {
        this.setProfile(profile);
        this.requester = requester;
        setState(PermissionState.REQUESTED);
        setGranted(false);
        notifyAdminsPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        if(!getState().equals(PermissionState.REQUESTED)&&!getState().equals(PermissionState.UNIX_REQUESTED)){
            return;
        }
        willBeHandledBy(admin);
        if(getState().equals(PermissionState.REQUESTED)){
           setState(PermissionState.CLAIMED);
        }else if(getState().equals(PermissionState.UNIX_REQUESTED)){
            setState(PermissionState.UNIX_CLAIMED);
        }

    }

    public void deniedBy(SystemAdmin admin) {
        if(!getState().equals(PermissionState.CLAIMED)&&!getState().equals(PermissionState.UNIX_CLAIMED)){
            return;
        }
        if(!getAdmin().equals(admin)){
            return;
        }
        setGranted(false);
        setUnixPermissionGranted(false);
        setState(PermissionState.DENIED);
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if (!getState().equals(PermissionState.CLAIMED) && !getState().equals(PermissionState.UNIX_CLAIMED)) {
            return;
        }
        if (!getAdmin().equals(admin)) {
            return;
        }
        if (getProfile().isUnixPermissionRequired() && getState().equals(PermissionState.UNIX_CLAIMED)) {
            setUnixPermissionGranted(true);
        } else if (getProfile().isUnixPermissionRequired() && !isUnixPermissionGranted()) {
            setState(PermissionState.UNIX_REQUESTED);
            notifyAdminsPermissionRequest();
            return;
        }
        setState(PermissionState.GRANTED);
        setGranted(true);
        notifyUserOfPermissionRequestResult();
    }


    boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public PermissionState getState() {
        return state;
    }

    protected void notifyUserOfPermissionRequestResult() {
    }

    void willBeHandledBy(SystemAdmin admin) {
    }

    void notifyAdminsPermissionRequest() {

    }


    public void setState(PermissionState permission) {
        this.state = permission;
    }

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    public void setGranted(boolean granted) {
        isGranted = granted;
    }

    public void setUnixPermissionGranted(boolean unixPermissionGranted) {
        isUnixPermissionGranted = unixPermissionGranted;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void setProfile(SystemProfile profile) {
        this.profile = profile;
    }
}
