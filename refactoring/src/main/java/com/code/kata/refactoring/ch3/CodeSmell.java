package com.code.kata.refactoring.ch3;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public class CodeSmell {


    /**
     Duplicated Code
        Number one in the stink parade is duplicated code. If you see the same code structure in more than one place, you can be sure that
     your program will be better if you find a way to unify them.
        The simplest duplicated code problem is when you have the same expression in two methods of the same class. Then all you have to do
     is Extract Method and invoke the code from both place.
        Another common duplication problem is when you have the same expression in two sibling subclass. You can eliminate this duplication
     by using Extract Method in both classes then Pull Up Filed. If the code is similar but not the same, you need to use Extract Method to
     separate the similar bits from the different bits. You may then find you can use Form Template Method. If the methods do the same thing
     with a different algorithm, you can choose the clearer of the two algorithms and use Substitute Algorithm.
        If you have duplicated code int two unrelated classes, consider using Extract Class in one class and then use the new component in the
     other. Another possibility is that the method really belongs only in one of the classes and should be invoked by the other class or that the
     method belongs in a third class that should be referred to by both of the original classes. You have to decide where the method makes sense
     and ensure it is there and nowhere else.

     1. The same expression in two methods of the same class and invoke the code from both place.
     -- Extract Method
     2. The same expression in the sibling subclass
     -- Extract Method -> Pull Up Filed
     3. Code is similar but not the same
     -- Extract Method -> Form Template Method
     4. Do the same thing with a different algorithm,choose the clearer one
     -- Substitute Algorithm
     5. If you have duplicated code int two unrelated classes, consider using Extract Class in one class(or third class)
     and then use the new component in the other
     -- Extract Class

     Long Method
        The object programs that live best and longest are those with short methods. Programmers new to objects often feel that no computation
     ever takes place, that object programs are endless sequences of delegation. When you have lived with such a program for few years, however,
     you learn just how valuable all those little methods are. All of the payoffs of indirection-explanation,sharing,and choosing-are supported by
     little methods.
        Since the early days of programming people have realized that the longer a procedure is, the more difficult it is to understand. Older languages
     carried an overhead in subroutine calls, which deterred people from small methods. Modern OO languages have pretty much eliminated that overhead for
     in-process calls. There is still an overhead to the reader of the code because you have to switch context to see what subprocedure does. Development
     environments that allow you to see two methods at once help to eliminate this step, but the real key to making it easy to understand small methods is
     good naming. If you have a good name for a method you don't need to look at the body.
        The net effect is that you should be much more aggressive about decomposing methods. A heuristic we follow is that whenever we feel the need to comment
     something, we write a method instead. Such a method contains the code that was commented but is named after the intention of the code rather than how does
     it. We may do this on a group of lines or on as little as a single line of code. We do this even if the method call is longer than the code it replaces, provided
     the method name explain the purpose of the code. The key here is not method length but the semantic distance between what the method does and how it does it.
        Ninety-nine percent of the time, all you have to do to shorten a method is Extract Method. Find parts of the method that seem to go nicely together and make
     a new method.
        If you have a method with lots of parameters and temporary variables, these elements get in the way of extracting methods. If you try to use Extract Method,
     you end up passing so many of the parameters and temporary variables as parameters to the extracted method that the result is scarcely more readable than the original.
     You can often use Replace Temp With Query to eliminate the temps. Long lists of parameters can be slimmed down with Introduce Parameter Object and Preserve Whole Object.
        If you've tried that, and you still have too many temps and parameters, it's time to get out the heavy artillery: Replace Method With Method Object.
        How do you identify the clumps of code to extract? A good technique is to look for comments. They often signal this kind of semantic distance. A block of code with
     a comment that tells you what it is doing can be replaced by a method whose name is based on the comment. Even a single line is worth extracting if it needs explanation.
        Conditional and loops also give signs for extractions. Use Decompose Conditional to deal with conditional expression. With loops, extract the loop and the code within
     the loop into its own method.

     1. Shorten a method
     -- Extract Method
     2. Method with lots of parameters and temporary variables
     -- Replace Temp with Query
     -- Introduce Parameter Object
     -- Preserve Whole Object
     -- Replace Method with Method Object
     3.Conditionals and Loops also give signs for extractions.
     -- Decompose Conditional
     -- Extract Method

     Large Class
        When a class is trying to do too much,it often shows up as too many instance variables. When a class has too many instance variables,
     duplicated code cannot be far behind.
        You can Extract Class to bundle a number of the variables. Choose variables to go together in the component that makes sense for each.
     For example, "depositAmount" and "depositCurrency" are likely to belong together in a component. More generally, common prefixes or suffixes
     for some subset of the variables in a class suggest the opportunity for a component. If the component makes sense as a subclass, you'll find
     Extract Subclass often is easier.
        Sometimes a class dose not use all of its instance variables all of the time. If so, you may be able to Extract Class or Extract Subclass
     many times.
        As with a class with too many instance variables, a class with too much code is prime breeding group for duplicated code, chaos, and death.
     The simplest solution is to eliminate redundancy in the class itself. If you have five hundred-line methods with lots of code in common, you
     may be able to turn into five ten-line methods with another ten two-line methods extracted from the original.
        As with a class with a huge wad of variables, the usual solution for a class with too much code is either to Extract Class or Extract Subclass.
     A useful trick is to determine how clients use the class and to use Extract Interface for each of these uses. That my give you ideas on how you
     can further break up the class.
        If your large class is GUI class, you may need to move data and behavior to separate domain object. This may require keeping some duplicated data
     in both places and keeping the data in sync. Duplicate Observed Data suggests how to do this. In this case, especially if you are using older Abstract
     Window Toolkit(AWT) components, you might follow this by removing the GUI class and replacing it with Swing components.

     1. . More generally, common prefixes or suffixes for some subset of the variables in a class suggest the opportunity for a component. If the component
     makes sense as a subclass, you'll find Extract Subclass often is easier. Sometimes a class does not use all of its instance variable all of the time.
     -- Extract Class
     -- Extract SubClass
     2. A useful trick is to determine how clients use class and use Extract Interface for each of these uses.
     -- Extract Interface
     3. You may need to move data and behavior to a separate domain object,this may require some duplicated data in
     both places and keeping the data in sync.
     -- Duplicate Observed Data


     Long Parameter List
        In our early programming days we were taught to pass in as parameters everything needed by a routine. This was understandable
     because the alternative was global data, and global data is evil and usually painful. Objects change this situation because if you
     don't have something you need, you can always ask another object get it for you. Thus with objects you don't pass in everything the
     method needs. Instead you pass enough so that the method can get to everything it needs. A lot of what a method needs is available
     on the method's host class. In object-oriented programs parameter lists tend to be much smaller than in traditional programs.
        This is good because long parameter list are hard to understand, because they become inconsistent and difficult to use, and because
     you are forever changing them as you need more data. Most changes are removed by passing objects because you are much more likely to
     need to make only a couple of requests to get a new piece of data.
        Use Replace Parameter With Method when you can get the data in one parameter by making a request of an object you already know about.
     This object might be a field or it might be another parameter. Use Preserve Whole Object to take a bunch of data gleaned from an object
     and replace it with the object itself. If you have several data items with no logical object, use Introduce Parameter Object.
        There is one important exception to making these changes. This is when you explicitly do not want to create a dependency form the called
     object to the large object. In those cases unpacking data and sending it along as parameters is reasonable, but pay attention to the pain
     involved. If the parameter list is too long or changes too often, you need to rethink your dependency structure.

     1. When you can get the data in one parameter by making request of an object you already know about.This object might
     be a filed or it might be another parameter.
     -- Replace Parameter With Method
     2. Use Preserve Whole Object to take a bunch of data gleaned from an object and replace it with the object itself.
     -- Preserve Whole Object
     3. If you have several data items with no logical object
     -- Introduce Parameter Object

     Divergent Change
        We structure software to make change easier. After all, software is meant to be soft. When we make a change we want to be able to jump to
     a single clear point in the system and make the change. When you can't do this you are smelling one of two closely related pungencies.
        Divergent change occurs when one class is commonly changed in different way for different reasons. If you look at a class and say, "Well, I
     will have to change these three methods every time I get a new database; I have to change these four methods every time there is a new financial
     instrument," you likely have a situation in which two objects are better than one. That way each object is changed only as a result of one kind
     of change. Of course, you often discover this only after you've added a few databases or financial instruments. Any change to handle a variation
     should change a single class, and all the typing in the new class should express the variation. To clean this up you identify everything that changes
     for a particular cause and use Extract Class to put them all together.

     1. Any change to handle a variation should change a single class,and all the typing in the new class should express the variation.
     To clean this up you identity everything that changes for a particular cause and use Extract Class to put them all together.
     -- Extract Class

     Shotgun Surgery
        Shotgun surgery is similar to divergent change but is the opposite.You whiff this when every time you make a kind of change, you have to make
     a lot of little changes to a lot of different classes.When the changes are all over the place, they are hard to find,and it's easy to miss an
     important change.
        In this case you want to use Move Method and Move Field to put all the changes into a single class. If no current class looks like a good candidate,
     create one. Often you can use Inline Class to bring a whole bunch of behavior together. You get a small does of divergent change, but you can easily
     deal with that.
        Divergent change is one class that suffers many kinds of changes, and shotgun surgery is one change that alters many classes. Either way you want to
     arrange things so that, ideally there is one-to-one link between common changes and classes.

     1. Put all change to single class,If no current class looks lie a good candidate,create one.
     -- Move Method
     -- Move Filed
     2. Bring a whole bunch of behavior together.
     -- Inline Class

     Feature Envy
        The whole point of objects is that they are a technique to package data with the processes used on that data. A classic smell
     is a method that seems more interested in a class other than the one it actually is in. The most common focus of the envy is the data.
        The fundamental rule of thumb is to put things together that change together. Data and the behavior that references that data usually
     change together,but there exceptions.When the exceptions occur, we move the behavior to keep changes in one place.
     1. The method clearly wants to be elsewhere,so you use Move Method to get it there.
     -- Move Method
     2. Sometimes only part of the method suffers from envy
     -- Extract Method --> Move Method

     Data Clumps
        Often you'll see the same three or four data items together in lots of places: fields in a couple of classes,parameters in many method signatures.
     Bunches of data that hang around together really ought to be made into their own object.
     1. Look for where the clumps appear as fields.Use Extract Class on the fields to turn the clumps into an object. Then turn your attention
     to method signatures using Introduce Parameter Object or Preserve Whole Object to slim them down.
     -- Extract Class --> Introduce Parameter Object or Preserve Whole Object

     Primitive Obsession
        One of the valuable things about objects is that they blur or break the line between primitive and large classes. You can easily write little classes
     that are indistinguishable from the built-in types of the language. like String,Date
        People new to objects usually are reluctant to use small objects for small tasks,such as money classes that combine number and currency, ranges with
     an upper and a lower, and special strings such as telephone numbers and ZIP code.
     1. Using Replace Data Value With Object on individual data values.
     -- Replace Data Value With Object
     2. Use Replace Type Code With Class if the value does not affect behavior
     -- Replace Type Code With Class
     3. If you have conditionals that depend on the type code,use Replace Type Code With State/Strategy
     -- Replace Type Code With State/Strategy
     4. If you have a group of fields that should go together, use Extract Class
     -- Extract Class
     5. If you see these primitives in parameter lists,try civilizing does of Introduce Parameter Object
     -- Introduce Parameter Object
     6. If you find yourself picking apart an array,use Replace Array With Object
     -- Replace Array With Object

     Switch Statements
        The problem with switch statements is essentially that of duplication. Often you find the same switch statement
     scattered about a program in different places. If you add a new clause to the switch, you have to find all these switch,
     statements and change them. The object oriented notion of polymorphism gives you an elegant way to deal with this problem.
     1. You want the method or class that hosts the type code value. So use Extract Method to extract the switch statement and
     then Move Method to get it onto the class where the polymorphism is needed. At that point you have to decide whether to
     Replace Type Code With Subclasses or Replace Type Code With State/Strategy. When you have set up the inheritance structure,
     you can use Replace Conditional With Polymorphism.
     -- Extract Method --> Move Method --> Replace Type Code With Subclasses or Replace Code With State/Strategy --> Replace Conditional With Polymorphism
     2. If you have a few cases that only affect a single method, and don't expect them to change, then polymorphism is overkill. In this case
     Replace Parameter With Explicit Methods is a good option.
     -- Replace Parameter With Explicit Methods
     3. If one of your conditional cases is a null, try Introduce Null Object
     -- Introduce Null Object

     Parallel Inheritance Hierarchies
        Parallel Inheritance Hierarchies is really special case of Shotgun Surgery. In this case, every time you make a subclass of one class,
     you also have to make a subclass of another.You can recognize this smell because the prefixes of the class names in one hierarchy are the
     same as the prefixes in another hierarchy.
        The general strategy for eliminating the duplication is to make sure that instances of one hierarchy refer to instances of the other.
     If you Move Method and Move Field, the hierarchy on the referring class disappears.
     -- Move Method and Move Field

     Lazy Class
        Each class you create costs money to maintain and understand. A class that isn't doing enough to pay for itself should be eliminated.
     1. If you have subclasses that aren't doing enough, try to use Collapse Hierarchy.
     -- Collapse Hierarchy
     2. Nearly useless components should be subjected to Inline Class
     -- Inline Class

     Speculative Generality
        You get it when people say, "Oh,I think we need the ability to this kind of thing someday" and thus want all sorts of hooks and special
     cases to handle things that aren't required.The result often is harder to understand and maintain.If all this machinery were being used, it
     would be worth it.But if it isn't,it isn't.The machinery just gets in the way,so get rid of it.
     1. If you have abstract classes that aren't doing much,use Collapse Hierarchy.
     -- Collapse Hierarchy
     2. Unnecessary delegation can be removed with Inline Class.
     -- Inline Class
     3. Methods with unused parameters should be subject to Remove Parameter.
     -- Remove Parameter
     4. Methods name with odd abstract names should be brought down to earth with Rename Method.
     -- Rename Method

     Temporary Field
        Sometimes you see an object in which an instance variable is set only in certain circumstances.Such code is difficult to understand,
     because you expect an object to need all of its variables.Trying to understand why a variable is there when it doesn't seem to be used
     can drive you nuts.
     1. Use Extract Class to create a home for the poor orphan variables.Put all the code that concerns the variables into the component.
     -- Extract Class
     2. You may also be able to eliminate conditional code by using Introduce Null Object to create an alternative component for when the variables
     aren't valid.
     -- Introduce Null Object
     3. A common case of temporary field occurs when a complicated algorithm needs several variables.Because the implementer didn't want to
     pass around a huge parameter list,he put them in fields.But the fields are valid only during the algorithm;in other contexts they are just
     pain confusing.In this case you can use Extract Class with these variables and the methods that require them. The new object is a method object.
     -- Extract Class

     Message Chains
        You see message chains when a client asks one object for another, which the client then asks for yet another object, which the client then
     asks another object and so on. You may see these as a long line of getThis methods, or as a sequence of temps. Navigating this way means the
     client is coupled to the structure of the navigation. Any change to the intermediate relationships causes the client to have to change.
     1. You can Hide Delegate at various points in the chain. In principle you can do this to every object in the chain, but doing this often turns
     every intermediate object into a Middle Man.
     -- Hide Delegate
     2. Often a better alternative is to see what the resulting object is used for. See whether you can use Extract Method to take a piece of the code
     that uses it and then Move Method to push it down the chain. If several clients of one of the objects in the chain want to navigate the rest of
     the way, add a method to do that.
     -- Extract Method --> Move Method

     Middle Man
        One of the prime features of objects is encapsulation--hiding internal detail from the rest of the world. Encapsulation often comes with delegation.
     However,this can go too far. You look at a class's interface and find half the method are delegating to this other class.
     1. Use Remove Middle Man and talk to the object that really knows what's going on.
     -- Remove Middle Man
     2. If only a few methods aren't doing much, use Inline Method to inline them to the caller.
     -- Inline Method
     3. If there is additional behavior, you can use Replace Delegation With Inheritance to turn the middle man into a subclass of the real object.
     That allows you to extend behavior without chasing all that delegation.
     -- Replace Delegation With Inheritance

     Inappropriate Intimacy
        Sometimes classes become far too intimate and spend too much time delving in each other's private parts.
     1. Use Move Method and Move Filed to separate the pieces to reduce the intimacy. See whether you can arrange a Change Bidirectional Association to Unidirectional
     -- Move Method and Move Filed
     -- Change Bidirectional Association to Unidirectional
     2. If the classes do have common interests, use Extract Class to put the commonality in a safe place and make honest classes of them.
     Or use Hide Delegate to let another class act as go-between.
     -- Extract Class or Hide Delegate
     3. Inheritance often can lead to over intimacy. Subclass always going to know more about their parents would like them to know. Apply Replace Delegation With Inheritance
     -- Replace Delegation With Inheritance

     Alternative Classes With Different Interfaces
        Use Rename Method on any methods that do the same thing but have different signatures for what they do. In these cases the classes
     aren't yet doing enough. Keep using Move Method to move behavior to the classes until the protocols are the same. If you have to redundantly
     move code to accomplish this, you may be able to use Extract Supper Class to atone.
     -- Rename Method --> Move Method
     -- Extract Supper Class

     Incomplete Library Class
        Reuse is often touted as the purpose of objects. We think reuse is overrated(we just use).
     1. If there are just a couple of methods that you wish the library class had, use Introduce Foreign Method.
     -- Introduce Foreign Method
     2. If there is a whole load of extra behavior, you need Introduce Local Extension
     -- Introduce Local Extension

     Data Class
        These are classes that have fields, getting and setting methods for the fields, and nothing else. Such classes are dumb data holders and
     are almost certainly being manipulated in far too much detail by other classes.
        Data classes are like children. They are okay as a starting point, but to participate as a grownup object, they need to take some responsibility.
     1. If these classes have public fields. You should immediately apply Encapsulate Field before anyone notices.
     -- Encapsulate Field
     2. If you have collection fields, check to see whether they are properly encapsulated and apply Encapsulate Collection if they aren't.
     -- Encapsulate Collection
     3. Use Remove Setting Method on any field that should not be change.
     -- Remove Setting Method
     4. Look for where these getting and setting methods are used by other classes. Try to use Move Method to move behavior into the data class.
     -- Move Method
     5. If you can't move a whole method, use Extract Method to create a method that can be moved. After a while you can start using Hide Method
     on the getters and setters.
     -- Extract Method --> Hide Method


     Refused Bequest
        Subclasses get to inherit the method and data from their parents. But what if they don't want or need what they given? They are given these
     gifts and pick just a few to play with.
     1. The traditional story is that the hierarchy is wrong. You need to create a new sibling class and use Push Down Method and Push Down Field to push all
     the unused methods to the sibling.That way the parent holds only what is common. Often you'll hear advice that all superclasses should be abstract.
        You will guess from our snide use of traditional that we aren't going to advice this, at least not all the time. We do subclassing to reuse a bit of
     behavior all the time, and we find it a perfectly good way to doing business. There is a smell, we can't deny it, but usually it isn't strong smell. So
     we say that if the refused bequest is causing confusion and problems, follow the traditional advice. However, don't feel you have to do it all the time.
     Nine times out of ten this smell is too faint to be worth cleaning.
     -- Push Down Method and Push Down Field
     2. The Smell of refused bequest is much stronger if the subclass is reusing behavior but does not want to support the interface of the superclass. We don't
     mind refusing implementations, but refusing interface gets us on our high horses. In this case, however, don't fiddle with the hierarchy; you want to gut
     it by applying Replace Inheritance With Delegation
     -- Replace Inheritance With Delegation

     Comments
        Don't worry, we aren't saying that people shouldn't write comments. In our olfactory analogy, comments aren't a bad smell; indeed they are sweet smell.
     The reason here is that comments often are used as a deodorant. It's surprising how often you look at thickly commented code and notice that the comments
     are there because the code is bad.
        Comments lead us to bad code that has all the rotten whiffs we've discussed in the rest of this chapter. Our first action is to remove the bad smell by
     refactoring. When we're finished, we often find that the comments are superfluous.
     1. If you need a comment to explain what a block of code does, try Extract Method.
     -- Extract Method
     2. If the method is already extracted but you still need a comment to explain what it does, use Rename Method.
     -- Rename Method
     3. If you need to state some rule about the required state of the system, use Introduce Assertion.
     -- Introduce Assertion
        When you feel the need to write a comment, first try to refactor the code so that any comment becomes superfluous.
        A good time to use a comment is when you don't know what to do. In addition to describing what is going on, comments can indicated areas in which you aren't sure.
     A comment is a good place to say why you did something. This kind of information helps future modifiers, especially forgetful ones.

     */

}
