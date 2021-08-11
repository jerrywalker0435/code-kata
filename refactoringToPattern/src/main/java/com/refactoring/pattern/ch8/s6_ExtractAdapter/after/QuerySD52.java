package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class QuerySD52 extends AbstractQuery {
    private SDLoginSession sdLoginSession;
    private final String sdConfigFileName;

    public QuerySD52(String sdConfigFileName){
        super();
        this.sdConfigFileName = sdConfigFileName;
    }



    public void login(String server, String user, String password) throws QueryException {
        sdLoginSession = new SDLoginSession(this.sdConfigFileName, false);

        try {
            sdLoginSession.loginSession(server, user, password);
        } catch (SDLoginFailedException e) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Longin failure\n", e);
        }
    }

    @Override
    protected SDQuery createQuery() {
        return sdLoginSession.createQuery(OPEN_FOR_QUERY);
    }
}
