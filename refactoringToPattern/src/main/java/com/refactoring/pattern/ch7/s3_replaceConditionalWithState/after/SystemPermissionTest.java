package com.refactoring.pattern.ch7.s3_replaceConditionalWithState.after;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class SystemPermissionTest {
   public void testGrantedBy(){
       SystemUser user = new SystemUser();
       SystemProfile profile= new SystemProfile();
       SystemPermission permission = new SystemPermission(user,profile);
       SystemAdmin admin = new SystemAdmin();
       permission.grantedBy(admin);
//       assertEquals("requested",permission.REQUESTED,permission.getState());
       assertEquals("not granted",false,permission.isGranted());
       permission.claimedBy(admin);
       permission.grantedBy(admin);
//       assertEquals("granted",permission.GRANTED,permission.getState());
       assertEquals("granted",true,permission.isGranted());

   }

    private void assertEquals(String requested, String requested1, String state) {

    }

    private void assertEquals(String requested, boolean requested1, boolean state) {

    }
}
