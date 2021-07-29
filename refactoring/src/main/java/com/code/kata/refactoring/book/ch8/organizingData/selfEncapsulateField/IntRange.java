package com.code.kata.refactoring.book.ch8.organizingData.selfEncapsulateField;

/**
 * Self Encapsulate Field
 * You are accessing a field directly, but the coupling to the field is becoming awkward.
 * Create getting and setting methods for the field and use only those to access the field.
 * Motivation
 *   When it comes to accessing fields, there are two schools of thought. One is within the class where the variable is
 * defined, you should access the variable directly. The other school is that even within the class,you should always use
 * accessors.
 *   Essentially the advantages of indirect variable access are that it allows a subclass to override how to get that
 * information with a method and that it supports more flexibility in managing the data,such as lazy initialization, which
 * initializes the value only when you need to use it.
 *   The advantage of direct variable access is that the code is easier to read.You don't need to stop and say,"This is just
 * a getting method."
 *   I am always of two minds with this choice. I'm usually happy to do what the rest of the team wants to do.Left to myself,
 * though, I like to use direct variable access as a first resort, until it gets in the way.Once things start becoming
 * awkward,I switch to indirect variable access.Refactoring gives you the freedom to change your mind.
 *   The most important time to use Self Encapsulate Field is when you are accessing a field in a superclass but you want
 * to override this variable access with a computed value in the subclass. Self-encapsulating the field is the first step.
 * After that you can override the getting and setting methods as you need to.
 *
 */
public class IntRange {
}
