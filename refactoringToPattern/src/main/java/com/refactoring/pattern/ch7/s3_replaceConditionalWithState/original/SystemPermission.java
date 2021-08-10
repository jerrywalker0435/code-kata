package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.original;

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
