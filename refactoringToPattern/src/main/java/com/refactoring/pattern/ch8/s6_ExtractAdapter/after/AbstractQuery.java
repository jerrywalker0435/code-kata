package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public abstract class AbstractQuery implements Query {
    public static final String OPEN_FOR_QUERY = "OPEN_FOR_QUERY";
    protected SDQuery sdQuery;


    public void doQuery() throws QueryException {
        if (sdQuery != null) {
            sdQuery.clearResultSet();
        }
        sdQuery = createQuery();
        executeQuery();
    }

    protected void executeQuery() {

    }

    protected abstract SDQuery createQuery();
}
