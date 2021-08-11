package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class QuerySD51 extends AbstractQuery {
    private SDLogin sdLogin;
    private SDSession sdSession;

    public QuerySD51(){
        super();
    }

    public void login(String server, String user, String password) throws QueryException {
        try {
            sdSession = sdLogin.loginSession(server, user, password);
        } catch (SDLoginFailedException e) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Longin failure\n", e);
        }
    }


    @Override
    protected SDQuery createQuery() {
        return sdSession.createQuery(OPEN_FOR_QUERY);
    }
}
