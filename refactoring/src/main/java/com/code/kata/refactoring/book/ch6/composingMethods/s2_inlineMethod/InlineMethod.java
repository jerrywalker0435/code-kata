package com.code.kata.refactoring.book.ch6.composingMethods.s2_inlineMethod;

/**
 * @author zhangyu201
 * @date 2021/7/23
 */
public class InlineMethod {
    /**
     * A method's body is just as clear as its name.
     * Put the method's body into the body of its callers and remove the method.
     *
     * Motivation
     * A theme of this book is to use short methods named to show their intention, because these methods lead to clearer
     * and easier to read code. But sometimes you do come across a method in which the body is as clear as the name. Or
     * you refactor the body of the code into something that is just as clear as the name. When this happens, you should
     * then get rid of the method. Indirection can be helpful, but needless indirection is irritating.
     *
     * Another time to use Inline Method is when you have a group of methods that seem badly factored. You can inline
     * them all into one big method and reextract the methods. It is often good to do this before using
     * Replace Method With Method Object(以函数对象取代函数 110). You inline the various calls made by the method that have
     * behavior you want to have in the method object. It's easier to move one method than to move the method and its
     * called methods.
     *
     * I commonly use Inline Method when someone is using too much indirection and it seems that every method does simple
     * delegation to another method, and I get lost in all the delegation. In these cases some of the indirection is
     * worthwhile, but not all of it. By trying to inline I can flush out the useful ones and eliminate the rest.
     */
}
