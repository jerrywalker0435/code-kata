package com.refactoring.pattern.ch8.s6_ExtractAdapter.original;



/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class Main {
    private Query query;
    public void loginToDatabase(String db,String user,String password){
        query = new Query();
        try {
            if(usingSDVersion52()){
                query.login(db,user,password,getSD52ConfigFileName());
            }else {
                query.login(db,user,password);
            }
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }

    private boolean usingSDVersion52() {
        return false;
    }

    private String getSD52ConfigFileName() {
        return null;
    }
}
