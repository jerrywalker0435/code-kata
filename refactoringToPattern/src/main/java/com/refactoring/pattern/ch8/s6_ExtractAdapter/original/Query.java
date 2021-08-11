package com.refactoring.pattern.ch8.s6_ExtractAdapter.original;

/**
 * Extract Adapter : 提取Adapter
 * 	概要
 * 		一个类适配了多个版本的组件、类库、API或其他实体
 * 		为组件、类库、API或其他实体的每个版本提取一个Adapter
 * 	优点
 * 		隔离了不同版本的组件、类库或API之间的不同之处
 * 		使类只负责适配代码的一个版本
 * 		避免频繁的修改代码
 * 	缺点
 * 		如果某个重要的行为在Adapter中不可用，那么客户端代码将无法执行这一重要行为
 * 	做法
 * 		1.识别负担过重的适配器、即适配了太多的版本
 * 		2.针对负担过重的适配器所支持的多个版本中的一个版本，应用Extract Subclass或Extract Class产生一个新的适配器。把只用于这个版本的实例变量和方法复制或搬移到新的适配器中
 * 		3.重复步骤(2)直到负担过重的适配器中不在包含版本相关的代码为止
 * 		4.应用Push Up Method和Form Template Method去除适配器中的重复代码
 */
public class Query {
    public static final String OPEN_FOR_QUERY = "OPEN_FOR_QUERY";
    private SDLogin sdLogin;
    private SDSession sdSession;
    private SDLoginSession sdLoginSession;
    private boolean sd52;//SD 5.2版本需要
    private SDQuery sdQuery;

    public void login(String server, String user, String password) throws QueryException {
        sd52 = false;
        try {
            sdSession = sdLogin.loginSession(server, user, password);
        } catch (SDLoginFailedException e) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Longin failure\n", e);
        }
    }

    public void login(String server, String user, String password, String sdConfigFileName) throws QueryException {
        sd52 = true;
        sdLoginSession = new SDLoginSession(sdConfigFileName, false);

        try {
            sdLoginSession.loginSession(server, user, password);
        } catch (SDLoginFailedException e) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Longin failure\n", e);
        }
    }

    public void doQuery() throws QueryException{
        if(sdQuery!=null){
            sdQuery.clearResult();
        }
        if(sd52){
            sdQuery = sdLoginSession.createQuery(OPEN_FOR_QUERY);
        }else {
            sdQuery = sdSession.createQuery(OPEN_FOR_QUERY);
        }
        executeQuery();
    }

    private void executeQuery() {

    }
}
