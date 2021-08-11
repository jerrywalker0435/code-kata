package com.refactoring.pattern.ch8.s6_ExtractAdapter.after;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class QueryException extends Exception {
    public static final Object LOGIN_FAILED = "LOGIN_FAILED";

    public QueryException(Object loginFailed, String s, SDLoginFailedException e) {

    }
}
