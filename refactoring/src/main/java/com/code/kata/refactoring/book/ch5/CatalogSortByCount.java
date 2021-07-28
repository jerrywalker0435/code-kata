package com.code.kata.refactoring.book.ch5;

/**
 * @author zhangyu201
 * @date 2021/7/21
 */
public class CatalogSortByCount {

    /**
     1.  11 Extract Method(提炼函数 89)
     2.  10 Extract Class(提炼类 122)
     3.  10 Move Method(搬移函数 115)
     4.  4 Introduce Parameter Object(引入参数对象 238)
     5.  3 Extract Subclass(提炼子类 267)
     6.  3 Preserve Whole Object(保持对象完整 232)
     7.  3 Move Field(搬移字段 119)
     8.  3 Inline Class(将类内联化 125)
     9.  2 Replace Type Code With Subclass(以子类取代类型码 181)
     10. 2 Collapse Hierarchy(折叠继承体系 279)
     11. 2 Introduce Null Object(引入Null对象 209)
     12. 2 Hide Delegate(隐藏"委托关系" 127)
     13. 2 Replace Type Code With State/Strategy(以State/Strategy取代类型码 184)
     14. 1 Remove Parameter(移除参数 223)
     15. 1 Inline Method(内联函数 95)
     16. 1 Push Down Field(字段下移 266)
     17. 1 Form Template Method(塑造模板方法 280)
     18. 1 Substitute Algorithm(替换算法 113)
     19. 3 1 2 Replace Temp With Query(以查询取代临时变量 97)
     20. 4 1 3Replace Method With Method Object(以函数对象取代函数 110)
     21. 1 Duplicate Observed Data(复制"被监视数据" 153)
     22. 1 Replace Data Value With Object(以对象取代数据值 141)
     23. 1 Replace Type Code With Class(以类取代类型码 176)
     24. 1 Rename Method(函数重命名 221)
     25. 1 Replace Parameter With Explicit Methods(以明确函数取代参数 230)
     26. 1 Remove Middle Man(移除中间人 130)
     27. 1 Change Bidirectional Association to Unidirectional(将双向关联转为单向关联 162)
     28. 1 Introduce Foreign Method(引入外加函数 131)
     29. 1 Remove Setting Method(移除设值函数 242)
     30. 1 Encapsulate Field(封装字段 167)
     31. 1 Encapsulate Collection(封装集合 169)
     32. 1 Hide Method(隐藏函数 245)
     33. 1 Replace Inheritance With Delegation(以委托取代继承 287)
     34. 1 Introduce Assertion(引入断言 216)
     35. 1 Extract Interface(提炼接口 277)
     36. 1 Introduce Local Extension(引入本地扩展 133)
     37. 0 Introduce Explaining Variable(引入解释性变量 101)
     38. 2 0 2 Split Temporary Variable(分解临时变量 104)
     39. 1 0 1 Remove Assignments to Parameters(移除对参数的赋值 107)
     40. 0 Inline Temp(内联临时变量 96)
     41. 0 Self Encapsulate Field(自封装字段 138)
     42. 0 Change Value to Reference(将值对象改为引用对象 144)
     43. 0 Change Reference to Value(将引用对象改为值对象 148)
     44. 0 Replace Array With Object(以对象取代数组 150)
     45. 0 Change Unidirectional Association to Bidirectional(将单向关联转为双向关联 159)
     46. 0 Replace Magic Number With Symbolic Constant(以字面常量取代魔法数 166)
     47. 0 Replace Record With Data Class(以数据类取代记录 175)
     48. 0 Replace Subclass with Field(以字段取代子类 188)
     49. 0 Self Decompose Conditional(分解条件表达式 192)
     50. 0 Consolidate Conditional Expression(合并条件表达式 194)
     51. 0 Consolidate Duplicate Conditional Fragments(合并重复的条件判断 196)
     52. 0 Remove Control Flag(移除控制标记 197)
     53. 0 Replace Nested Conditional With Guard Clauses(以卫语句取代嵌套条件表达式 201)
     54. 0 Replace Conditional With Polymorphism(以多态取代条件表达式 205)
     55. 0 Add Parameter(添加参数 222)
     56. 1 0 1 Separate Query From Modifier(将查询函数与修改函数分离 225)
     57. 0 Parameterize Method(令函数携带参数 228)
     58. 0 Replace Parameter With Methods(以函数取代参数 235)
     59. 0 Replace Constructor With Factory Method(以工厂函数取代构造函数 246)
     60. 0 Encapsulate Downcast(封装向下转型 249)
     61. 0 Replace Error Code With Exception(以异常取代错误码 251)
     62. 0 Replace Exception With Test(以测试取代异常 255)
     63. 0 Pull Up Field(字段上移 259)
     64. 0 Pull Up Method(函数上移 260)
     65. 0 Pull Up Constructor Body(构造函数本体上移 263)
     66. 0 Push Down Method(函数下移 266)
     67. 0 Extract Superclass(提炼超类 272)
     68. 0 Replace Delegation With Inheritance(以继承取代委托 289)
     69. 0 Tease Apart Inheritance(梳理并分解继承体系 294)
     70. 0 Convert Procedural Design To Objects(将过程化设计转化为对象设计 300)
     71. 0 Separate Domain From Presentation(将领域和显示分离 302)
     72. 0 Extract Hierarchy(提炼继承体系 306)


     Note:
       fist number : total summary
       second number: occurs in code smell
       third number: occurs in catalog of refactoring
     */
}
