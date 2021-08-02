package com.code.kata.refactoring.book.ch3;

/**
 * @author zhangyu201
 * @date 2021/7/16
 */
public class CodeSmell {
    /**
     1.Duplicated Code
        Number one in the stink parade is duplicated code. If you see the same code structure in more than one place,
     you can be sure that your program will be better if you find a way to unify them.
        The simplest duplicated code problem is when you have the same expression in two methods of the same class.
     Then all you have to do is Extract Method(提炼函数 89) and invoke the code from both place.
        Another common duplication problem is when you have the same expression in two sibling subclass. You can
     eliminate this duplication by using Extract Method(提炼函数 89) in both classes then Pull Up Method(函数上移 260).
     If the code is similar but not the same, you need to use Extract Method(提炼函数 89) to separate the similar bits
     from the different bits. You may then find you can use Form Template Method(塑造模板方法 280). If the methods do the
     same thing with a different algorithm, you can choose the clearer of the two algorithms and use
     Substitute Algorithm(替换算法 113).
        If you have duplicated code int two unrelated classes, consider using Extract Class(提炼类 122) in one class and
     then use the new component in the other. Another possibility is that the method really belongs only in one of the
     classes and should be invoked by the other class or that the method belongs in a third class that should be
     referred to by both of the original classes. You have to decide where the method makes sense and ensure it is there
     and nowhere else.

     2.Long Method
        The object programs that live best and longest are those with short methods. Programmers new to objects often
     feel that no computation ever takes place, that object programs are endless sequences of delegation. When you have
     lived with such a program for few years, however, you learn just how valuable all those little methods are. All of
     the payoffs of indirection-explanation,sharing,and choosing-are supported by little methods.
        Since the early days of programming people have realized that the longer a procedure is, the more difficult it
     is to understand. Older languages carried an overhead in subroutine calls, which deterred people from small methods.
     Modern OO languages have pretty much eliminated that overhead for in-process calls. There is still an overhead to
     the reader of the code because you have to switch context to see what subprocedure does. Development environments
     that allow you to see two methods at once help to eliminate this step, but the real key to making it easy to
     understand small methods is good naming. If you have a good name for a method you don't need to look at the body.
        The net effect is that you should be much more aggressive about decomposing methods. A heuristic we follow is
     that whenever we feel the need to comment something, we write a method instead. Such a method contains the code
     that was commented but is named after the intention of the code rather than how does it. We may do this on a group
     of lines or on as little as a single line of code. We do this even if the method call is longer than the code it
     replaces, provided the method name explain the purpose of the code. The key here is not method length but the
     semantic distance between what the method does and how it does it. Ninety-nine percent of the time, all you have to
     do to shorten a method is Extract Method(提炼函数 89). Find parts of the method that seem to go nicely together and
     make a new method.
        If you have a method with lots of parameters and temporary variables, these elements get in the way of extracting
     methods. If you try to use Extract Method(提炼函数 89), you end up passing so many of the parameters and temporary
     variables as parameters to the extracted method that the result is scarcely more readable than the original. You
     can often use Replace Temp With Query(以查询取代临时变量 97) to eliminate the temps. Long lists of parameters can be
     slimmed down with Introduce Parameter Object(引入参数对象 238) and Preserve Whole Object(保持对象完整 232).
        If you've tried that, and you still have too many temps and parameters, it's time to get out the heavy artillery:
     Replace Method With Method Object(以函数对象取代函数 110).
        How do you identify the clumps of code to extract? A good technique is to look for comments. They often signal this
     kind of semantic distance. A block of code with a comment that tells you what it is doing can be replaced by a method
     whose name is based on the comment. Even a single line is worth extracting if it needs explanation.
        Conditional and loops also give signs for extractions. Use Decompose Conditional to deal with conditional expression.
     With loops, extract the loop and the code within the loop into its own method.


     3.Large Class
        When a class is trying to do too much,it often shows up as too many instance variables. When a class has too many
     instance variables, duplicated code cannot be far behind.
        You can Extract Class(提炼类 122) to bundle a number of the variables. Choose variables to go together in the
     component that makes sense for each. For example, "depositAmount" and "depositCurrency" are likely to belong
     together in a component. More generally, common prefixes or suffixes for some subset of the variables in a class
     suggest the opportunity for a component. If the component makes sense as a subclass, you'll find
     Extract Subclass(提炼子类 267) often is easier.
        Sometimes a class dose not use all of its instance variables all of the time. If so, you may be able to
     Extract Class(提炼类 122) or Extract Subclass(提炼子类 267) many times.
        As with a class with too many instance variables, a class with too much code is prime breeding group for duplicated
     code, chaos, and death. The simplest solution is to eliminate redundancy in the class itself. If you have five
     hundred-line methods with lots of code in common, you may be able to turn into five ten-line methods with another
     ten two-line methods extracted from the original.
        As with a class with a huge wad of variables, the usual solution for a class with too much code is either to
     Extract Class(提炼类 122) or Extract Subclass(提炼子类 267). A useful trick is to determine how clients use the class
     and to use Extract Interface(提炼接口 277) for each of these uses. That my give you ideas on how you can further
     break up the class.
        If your large class is GUI class, you may need to move data and behavior to separate domain object. This may
     require keeping some duplicated data in both places and keeping the data in sync.
     Duplicate Observed Data(复制"被监视数据" 153) suggests how to do this. In this case, especially if you are using older
     Abstract Window Toolkit(AWT) components, you might follow this by removing the GUI class and replacing it with
     Swing components.


     4.Long Parameter List
        In our early programming days we were taught to pass in as parameters everything needed by a routine. This was
     understandable because the alternative was global data, and global data is evil and usually painful. Objects change
     this situation because if you don't have something you need, you can always ask another object get it for you. Thus
     with objects you don't pass in everything the method needs. Instead you pass enough so that the method can get to
     everything it needs. A lot of what a method needs is available on the method's host class. In object-oriented programs
     parameter lists tend to be much smaller than in traditional programs.
        This is good because long parameter list are hard to understand, because they become inconsistent and difficult
     to use, and because you are forever changing them as you need more data. Most changes are removed by passing objects
     because you are much more likely to need to make only a couple of requests to get a new piece of data.
        Use Replace Parameter With Method when you can get the data in one parameter by making a request of an object you
     already know about.This object might be a field or it might be another parameter. Use
     Preserve Whole Object(保持对象完整 232) to take a bunch of data gleaned from an object and replace it with the object
     itself. If you have several data items with no logical object, use Introduce Parameter Object(引入参数对象 238).
        There is one important exception to making these changes. This is when you explicitly do not want to create a
     dependency form the called object to the large object. In those cases unpacking data and sending it along as parameters
     is reasonable, but pay attention to the pain involved. If the parameter list is too long or changes too often, you
     need to rethink your dependency structure.


     5.Divergent Change
        We structure software to make change easier. After all, software is meant to be soft. When we make a change we
     want to be able to jump to a single clear point in the system and make the change. When you can't do this you are
     smelling one of two closely related pungencies.
        Divergent change occurs when one class is commonly changed in different way for different reasons. If you look
     at a class and say, "Well, I will have to change these three methods every time I get a new database; I have to change
     these four methods every time there is a new financial instrument," you likely have a situation in which two objects
     are better than one. That way each object is changed only as a result of one kind of change. Of course, you often
     discover this only after you've added a few databases or financial instruments. Any change to handle a variation
     should change a single class, and all the typing in the new class should express the variation. To clean this up you
     identify everything that changes for a particular cause and use Extract Class(提炼类 122) to put them all together.



     6.Shotgun Surgery
        Shotgun Surgery is similar to divergent change but is the opposite.You whiff this when every time you make a kind
     of change, you have to make a lot of little changes to a lot of different classes.When the changes are all over the
     place, they are hard to find,and it's easy to miss an important change.
        In this case you want to use Move Method(搬移函数 115) and Move Field(搬移字段 119) to put all the changes into a
     single class. If no current class looks like a good candidate, create one. Often you can use Inline Class(将类内联化 125)
     to bring a whole bunch of behavior together. You get a small does of divergent change, but you can easily deal with
     that.
        Divergent change is one class that suffers many kinds of changes, and shotgun surgery is one change that alters
     many classes. Either way you want to arrange things so that, ideally there is one-to-one link between common changes
     and classes.


     7.Feature Envy
        The whole point of objects is that they are a technique to package data with the processes used on that data. A
     classic smell is a method that seems more interested in a class other than the one it actually is in. The most common
     focus of the envy is the data. We've lost count of the times we've seen a method that invokes half-a-dozen getting
     methods on another object to calculate some value. Fortunately the cure is obvious, the methods clearly wants to be
     elsewhere, so you use Move Method(搬移函数 115) to get it there. Sometimes only part of the method suffers from envy;
     in that case use Extract Method(提炼函数 89) on the jealous bit and Move Method(搬移函数 115) to give it a dream home.
        Of course not all cases are cut-and-dried. Often a method uses features of several classes, so which one should
     it live with? The heuristic we use is to determine which class has most of the data and put the method with that data.
     This step is often made easier if Extract Method(提炼函数 89) is used to break the method into pieces that go into
     different places.
        Of course there are several sophisticated patterns that break this rule. From the Gang of Four Strategy and Visitor
     immediately leap to mind. Kent Beck's Self Delegation is another. You use these to combat the divergent change smell.
     The fundamental rule of thumb is to put things together that change together. Data and the behavior that references
     that data usually change together,but there exceptions.When the exceptions occur, we move the behavior to keep changes
     in one place. Strategy and Visitor allow you to change behavior easily, because they isolate the small amount of
     behavior that needs to be overridden, at the cost of further indirection.

     8.Data Clumps
        Data items tend to be like children; they enjoy hanging around in groups together. Often you'll see the same three
     or four data items together in lots of places: fields in a couple of classes, parameters in many method signatures.
     Bunches of data that hang around together really ought to be made into their own object. The first step is to look
     for where the clumps appear as fields. Use Extract Class(提炼类 122) on the fields to turn the clumps into an object.
     Then turn your attention to method signatures using Introduce Parameter Object(引入参数对象 238) or
     Preserve Whole Object(保持对象完整 232) to slim them down. The immediate benefit is that you can shrink a lot of
     parameter lists and simplify method calling. Don't worry about data clumps that use only some of the fields of the
     new object. As long as you are replacing two or more fields with the new object, you'll come out ahead.
        A good test is to consider deleting one of the data values: if you did this, would the others make any sense? If
     they don't, it's a sure sign that you have an object that's dying to be born.
        Reducing filed lists and parameter lists will certainly remove a few bad smells, but once you have the objects,
     you get the opportunity to make a nice perfume. You can now look for cases of feature envy, which will suggest behavior
     that can be moved into your new classes. Before long these classes will be productive members of society.


     9.Primitive Obsession
        Most programming environments have two kinds of data. Record types allow you to structure data into meaningful
     groups. Primitive types are your building blocks. Records always carry a certain amount of overhead. They may mean
     table in a database, or they may be awkward to create when you want them for only one or two things.
        One of the valuable things about objects is that they blur or break the line between primitive and larger classes.
     You can easily write little classes that are indistinguishable from the built-in types of the language. Java does
     have primitives for numbers, but strings and dates, which are primitives in many other environments, are classes.
        People new to objects usually are reluctant to use small objects for small tasks,such as money classes that combine
     number and currency, ranges with an upper and a lower, and special strings such as telephone numbers and ZIP codes.
     You can move out of the cave into the centrally heated world of objects by using
     Replace Data Value With Object(以对象取代数据值 141) on individual data values. If the data value is a type code, use
     Replace Type Code With Class(以类取代类型码 176) if the value does not affect behavior. If you have conditionals that
     depend on the type code, use Replace Type Code With Subclass(以子类取代类型码 181) or
     Replace Type Code With State/Strategy(以State/Strategy取代类型码 184). If you have a group of fields that should be
     together, use Extract Class(提炼类 122). If you see these primitives in parameter lists, try civilizing dose of
     Introduce Parameter Object(引入参数对象 238). If you find yourself picking apart an array, use
     Replace Array With Object(以对象取代数组 150).



     10.Switch Statements
        One of the most obvious symptoms of object-oriented code is its comparative lack of switch statements.The problem
     with switch statements is essentially that of duplication. Often you find the same switch statement scattered about
     a program in different places. If you add a new clause to the switch, you have to find all these switch, statements
     and change them. The object-oriented notion of polymorphism gives you an elegant way to deal with this problem.
        Most times you see a switch statement you should consider polymorphism. The issue is where the polymorphism should
     occur. Often the switch statement switches on a type code. You want the method or class that hosts the type code value.
     So use Extract Method(提炼函数 89) to extract the switch statement and then Move Method(搬移函数 115) to get it onto
     the class where polymorphism is needed. At that point you have to decide whether to
     Replace Type Code With Subclass(以子类取代类型码 181) or Replace Type Code With State/Strategy(以State/Strategy取代类型码 184).
     When you have set up the inheritance structure, you can use Replace Conditional With Polymorphism(以多态取代条件表达式 205).
        If you only have a few cases that affect a single method, and you don't expect them to change, then polymorphism is
     overkill. In this case Replace Parameter With Explicit Methods(以明确函数取代参数 230) is a good option. If one of your
     conditional cases is a null, try Introduce Null Object(引入Null对象 209).


     11.Parallel Inheritance Hierarchies
        Parallel Inheritance Hierarchies is really special case of Shotgun Surgery. In this case, every time you make a
     subclass of one class, you also have to make a subclass of another.You can recognize this smell because the prefixes
     of the class names in one hierarchy are the same as the prefixes in another hierarchy.
        The general strategy for eliminating the duplication is to make sure that instances of one hierarchy refer to
     instances of the other. If you Move Method(搬移函数 115) and Move Field(搬移字段 119), the hierarchy on the referring
     class disappears.


     12.Lazy Class
        Each class you create costs money to maintain and understand. A class that isn't doing enough to pay for itself
     should be eliminated. Often this might be a class that used to pay its way but has been downsized with refactoring.
     Or it might be a class that was added because of changes that were planned but not made. Either way, you let the
     class die with dignity. If you have subclasses that aren't doing enough, try to use Collapse Hierarchy(折叠继承体系 279).
     Nearly useless components should be subjected to Inline Class(将类内联化 125).


     13.Speculative Generality
        You get it when people say, "Oh,I think we need the ability to this kind of thing someday" and thus want all sorts
     of hooks and special cases to handle things that aren't required.The result often is harder to understand and maintain.
     If all this machinery were being used, it would be worth it.But if it isn't,it isn't.The machinery just gets in the way,
     so get rid of it.
        If you have abstract classes that aren't doing much, use Collapse Hierarchy(折叠继承体系 279). Unnecessary delegation
     can be removed with Inline Class(将类内联化 125). Methods with unused parameters should be subject to
     Remove Parameter(移除参数 223). Methods named with odd abstract names should be brought down to earth with
     Rename Method(函数重命名 221).
        Speculative generality can be spotted when the only users of a method or class are test cases. If you find such a
     method or class , delete it and test case that exercises it. If you have method or class that is a helper for a test
     case that exercise legitimate functionality, you have to leave it in, of course.

     14.Temporary Field
        Sometimes you see an object in which an instance variable is set only in certain circumstances. Such code is difficult
     to understand, because you expect an object to need all of its variables. Trying to understand why a variable is there
     when it doesn't seem to be used can drive you nuts.
        Use Extract Class(提炼类 122) to create a home for the poor orphan variables. Put all the code that concerns the
     variable into the component. You may also be able to eliminate conditional code by using
     Introduce Null Object(引入Null对象 209) to create an alternative component for when the variables aren't valid.
        A common case of temporary field occurs when a complicated algorithm needs several variables. Because the implementer
     didn't want to pass around a huge parameter list, he put them in fields. But the fields are valid only during the algorithm;
     in other contexts they are just plain confusing. In this case you can use Extract Class(提炼类 122) with these
     variables and the methods that require them. The new object is a method object.


     15.Message Chains
        You see message chains when a client asks one object for another, which the client then asks for yet another object,
     which the client then asks another object and so on. You may see these as a long line of getThis methods, or as a sequence
     of temps. Navigating this way means the client is coupled to the structure of the navigation. Any change to the intermediate
     relationships causes the client to have to change.
        The move to use here is Hide Delegate(隐藏"委托关系" 127). You can do this at various points in the chain. In principle
     you can do this to every object in the chain, but doing this often turns every intermediate object into middle man.
     Often a better alternative is to see what the resulting object is used for. See whether you can use Extract Method(提炼函数 89)
     to take a pieces of the code that uses it and the Move Method(搬移函数 115) to push it down the chain. If several
     clients of one of the objects in the chain want to navigate the rest of the way, add a method to do that.
        Some people consider any method chain to be terrible thing. We are known for our calm, reasoned moderation. Well
     at least in this case we are.


     16.Middle Man
        One of the prime features of objects is encapsulation--hiding internal detail from the rest of the world. Encapsulation
     often comes with delegation. You ask a director whether she is free for a meeting; she delegates the message to her
     diary and gives you an answer. All well and good. There is no need to know whether the director uses a diary, an
     electronic gizmo, or a secretary to keep track of here appointments.
        However,this can go too far. You look at a class's interface and find half the method are delegating to this other
     class. After a while it is time to use Remove Middle Man(移除中间人 130) and talk to the object that really knows what's
     going on. If only a few methods aren't doing much, use Inline Method(内联函数 95) to inline them into the caller. If
     there is additional behavior, you can use Replace Delegation With Inheritance(以继承取代委托 289) to turn the middle man
     into a subclass of the real object. That allows you to extend behavior without chasing all delegation.



     17.Inappropriate Intimacy
        Sometimes classes become far too intimate and spend too much time delving in each other's private parts. We may
     not be prudes when it comes to people, but we think our classes should follow strict, puritan rules.
        Overintimate classes need to be broken up as lovers were in ancient days. Use Move Method(搬移函数 115) and
     Move Field(搬移字段 119) to separate the pieces to reduce the intimacy. See whether you can arrange a
     Change Bidirectional Association to Unidirectional(将双向关联转为单向关联 162). If the classes do have common interests,
     use Extract Class(提炼类 122) to put the commonality in a safe place and make honest classes of them. Or use
     Hide Delegate(隐藏"委托关系" 127) to let another class act as go-between.
        Inheritance often can lead to overintimacy. Subclasses are always going to know more about their parents than their
     parents would like them to know. If it's time to leave home, apply Replace Delegation With Inheritance.


     18.Alternative Classes With Different Interfaces
        Use Rename Method on any methods that do the same thing but have different signatures for what they do. Often this
     doesn't go far enough. In these cases the classes aren't yet doing enough. Keep using Move Method(搬移函数 115) to move
     behavior to the classes until the protocols are the same. If you have to redundantly move code to accomplish this you
     may be able to use Extract Supper Class to atone.


     19.Incomplete Library Class
        Reuse is often touted as the purpose of objects. We think reuse is overrated(we just use). However, we can't deny
     that much of our programming skill is based on library classes so that nobody can tell whether we've forgotten our
     sort algorithms.
        Builders of library classes are rarely omniscient. We don't blame them for that; after all, we can rarely figure
     out a design until we've mostly build it, so library builder have a really tough job. The trouble is that it is often
     bad form, and usually impossible, to modify a library class to do something you'd like it to do. This means that
     tried-and-true tactics such as Move Method(搬移函数 115) lie useless.
        We have a couple of special-purpose tools for this job. If there are just a couple of methods that you wish the
     library class had, use Introduce Foreign Method(引入外加函数 131). If there is a whole load of extra behavior, you need
     Introduce Local Extension(引入本地扩展 133)


     20.Data Class
        These are classes that have fields, getting and setting methods for the fields, and nothing else. Such classes are
     dumb data holders and are almost certainly being manipulated in far too much detail by other classes. In early stages
     these classes may have public fields. If so, you should immediately apply Encapsulate Field(封装字段 167) before anyone
     notices.If you have collection fields, check to see whether they are properly encapsulated and apply
     Encapsulate Collection(封装集合 169) if they aren't. Use Remove Setting Method(移除设值函数 242) on any field that should
     not be changed.
        Look for where these getting and setting methods are used by other classes. Try to use Move Method(搬移函数 115)
     to move behavior into the data class. If you can't move a whole method, use Extract Method(提炼函数 89) to create a
     method that can be moved. After a while you can start using Hide Method(隐藏函数 245) on the getters and setters.
        Data classes are like children. They are okay as a starting point, but to participate as a grownup object, they
     need to take some responsibility.



     21.Refused Bequest
        Subclasses get to inherit the method and data from their parents. But what if they don't want or need what they given?
     They are all given these great gifts and pick just a few to play with.
        The traditional story is that the hierarchy is wrong. You need to create a new sibling class and use Push Down Method(函数下移 266)
     and Push Down Field(字段下移 266) to push all the unused methods to the sibling.That way the parent holds only what is common.
     Often you'll hear advice that all superclasses should be abstract.
        You will guess from our snide use of traditional that we aren't going to advice this, at least not all the time.
     We do subclassing to reuse a bit of behavior all the time, and we find it a perfectly good way to doing business. There
     is a smell, we can't deny it, but usually it isn't strong smell. So we say that if the refused bequest is causing confusion
     and problems, follow the traditional advice. However, don't feel you have to do it all the time. Nine times out of ten
     this smell is too faint to be worth cleaning.
        The Smell of refused bequest is much stronger if the subclass is reusing behavior but does not want to support the
     interface of the superclass. We don't mind refusing implementations, but refusing interface gets us on our high horses.
     In this case, however, don't fiddle with the hierarchy; you want to gut it by applying
     Replace Inheritance With Delegation(以委托取代继承 287)


     22.Comments
        Don't worry, we aren't saying that people shouldn't write comments. In our olfactory analogy, comments aren't a bad
     smell; indeed they are sweet smell. The reason here is that comments often are used as a deodorant. It's surprising
     how often you look at thickly commented code and notice that the comments are there because the code is bad.
        Comments lead us to bad code that has all the rotten whiffs we've discussed in the rest of this chapter. Our first
     action is to remove the bad smell by refactoring. When we're finished, we often find that the comments are superfluous.
     If you need a comment to explain what a block of code does, try Extract Method(提炼函数 89).If the method is already
     extracted but you still need a comment to explain what it does, use Rename Method.If you need to state some rule
     about the required state of the system, use Introduce Assertion(引入断言 216).
        When you feel the need to write a comment, first try to refactor the code so that any comment becomes superfluous.
        A good time to use a comment is when you don't know what to do. In addition to describing what is going on, comments
     can indicated areas in which you aren't sure. A comment is a good place to say why you did something. This kind of
     information helps future modifiers, especially forgetful ones.

     */

}
