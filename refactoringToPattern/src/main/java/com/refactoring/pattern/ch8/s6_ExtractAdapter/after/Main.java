package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class Main {
    private Query query;
    public void loginToDatabase(String db,String user,String password){
        try {
            if(usingSDVersion52()){
                query = new QuerySD52(getSD52ConfigFileName());
            }else {
                query = new QuerySD51();
            }
            query.login(db,user,password);

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
