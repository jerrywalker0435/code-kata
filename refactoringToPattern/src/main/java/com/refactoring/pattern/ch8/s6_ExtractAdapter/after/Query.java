package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public interface Query {
    void login(String server, String user, String password) throws QueryException;
}
