package com.code.kata.refactoring.book.ch6.composingMethods.s3_inlineTemp;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class InlineTemp {
    /**
     *
     * You have a temp that is assigned to once with simple expression, and the temp is getting in the way of other
     * refactorings.
     * Replace all references to that temp with expression.
     *
     * Motivation
     * Most of the time Inline Temp is used of as part of Replace Temp With Query, so the real motivation is there.
     * The only time Inline Temp is used on its own is when you find a temp that is assigned the value of method call.
     * Often this temp isn't doing any harm and you can safely leave it there. If the temp is getting in the way of other
     * refactorings, such as Extract Method, it's time to inline it.
     *
     */
}
