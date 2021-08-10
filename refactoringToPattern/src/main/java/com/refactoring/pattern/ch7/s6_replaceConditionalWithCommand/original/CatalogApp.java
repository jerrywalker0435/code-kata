package com.refactoring.pattern.ch7.s6_replaceConditionalWithCommand.original;

import java.util.Iterator;
import java.util.Map;

/**
 * Replace Conditional with Command: 用Command替换条件调度程序
 * 	概要
 * 		条件逻辑用来调度请求和执行操作
 * 			1.缺少足够的运行时灵活性
 * 			2.代码体的膨胀
 * 		为每一个动作创建一个Command。把这些Command存储在一个集合中，并获取及执行Command的代码替换条件逻辑
 * 	优点
 * 		提供了用统一方法执行不同行为的简单机制
 * 		运行在运行时改变所处理的请求，及何时处理请求
 * 		仅仅需要很少的代码实现
 * 	缺点
 * 		当条件调度足够简单时，会增加设计复杂度
 * 	做法
 * 		1.在包含条件调度程序的类中找到处理请求的代码，在这段代码上应用Extract Method重构，直到产生执行该代码行为的执行方法(execution method)为止。
 * 		2.重复步骤(1),把所有的剩余的请求处理代码提炼到各自的执行方法中
 * 		3.在每个执行方法上应用Extract Class重构，产生处理请求的具体命令(concrete command)。通常做法是把具体命令中的执行方法声明为公共。如果在新的具体命令中的执行方法过于庞大或难于理解，应用Composed Method重构
 * 			创建了所有具体命令后，寻找它们中的重复代码。如果存在重复代码，考虑是否可以通过应用Form Template Method重构来去除它
 * 		4.定义一个命令(command)，即声明了与每个具体命令相同的执行方法的接口或抽象类。为了实现这一步。需要分析具体命令，找到它们独特或相似的地方。考虑在具体命令上应用Extract Superclass或Extract Interface，产生命令的早期版本
 * 			必须为通用执行方法传入什么参数？
 * 			在具体命令的构造过程中，可以传入什么参数？
 * 			通过回调参数，而不是直接掺入参数，具体命令可以获得什么信息？
 * 			这个执行方法的最简签名是什么？
 * 		5.使每个具体命令都实现或继承这个命令，并用命令类型更新所有使用具体命令的客户代码。
 * 		6.在包含条件调度程序类中，定义并组装一个命令映射(command map)。这个映射包含每个具体的命令，并用唯一标识符(如命令的名字)作为主键，在运行时可以用这个主键来获取命令
 * 			如果具体命令很多，那么为命令映射添加具体命令的代码就会很多，可以考虑把具体命令实现改为Plugin模式(企业应用架构模式)
 * 		7.在包含条件调度程序的类中，把调度请求的条件代码替换为获取正确的具体命令并调用其执行方法的代码
 */
public class CatalogApp {
    public static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    private static final String ALL_WORKSHOPS_STYLESHEET = "ALL_WORKSHOPS_STYLESHEET";
    private WorkShopManager workshopManager;

    private HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        if (actionName.equals("NEW_WORKSHOP")) {
            String nextWorkshopId = workshopManager.getNextWorkshopId();
            StringBuffer newWorkshopContents = workshopManager.createNewFileFromTemplate(
                    nextWorkshopId,
                    workshopManager.getWorkshopDir(),
                    workshopManager.getWorkshopTemplate()
            );
            workshopManager.addWorkshop(newWorkshopContents);
            parameters.put("id", nextWorkshopId);
            executeActionAndGetResponse(ALL_WORKSHOPS, parameters);
        } else if (actionName.equals(ALL_WORKSHOPS)) {
            XMLBuilder allWorkshopsXml = new XMLBuilder("workshops");
            WorkshopRepository repository = workshopManager.getWorkshopRepository();
            Iterator ids = repository.keyIterator();
            while (ids.hasNext()) {
                String id = (String) ids.next();
                Workshop workshop = repository.getWorkshop(id);
                allWorkshopsXml.addBelowParent("workshop");
                allWorkshopsXml.addAttribute("id", workshop.getId());
                allWorkshopsXml.addAttribute("name", workshop.getName());
                allWorkshopsXml.addAttribute("status", workshop.getStatus());
                allWorkshopsXml.addAttribute("duration", workshop.getDuration());
            }
            String formattedXml = getFormattedData(allWorkshopsXml.toString());
            return new HandlerResponse(new StringBuffer(formattedXml), ALL_WORKSHOPS_STYLESHEET);
        }


        return new HandlerResponse(new StringBuffer(""), ALL_WORKSHOPS);

    }

    private String getFormattedData(String toString) {
        return null;
    }
}
