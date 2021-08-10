package com.refactoring.pattern.ch7.s6_replaceConditionalWithCommand.after;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class CatalogApp {
    public static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    public static final String NEW_WORKSHOP = "NEW_WORKSHOP";
    private Map<String,Handler> handlers;
    private WorkShopManager workshopManager;

    public CatalogApp(Map<String, Handler> handlers) {
        this.handlers = createHandlers();
    }

    private Map<String, Handler> createHandlers() {
        handlers = new HashMap<>();
        handlers.put(ALL_WORKSHOPS,new AllWorkshopsHandler(this));
        handlers.put(NEW_WORKSHOP,new NewWorkshopHandler(this));
        return handlers;
    }

    HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        Handler handler = lookupHandlerBy(actionName);
        return handler.execute(parameters);

    }

    private Handler lookupHandlerBy(String actionName) {
        return handlers.get(actionName);
    }


    String getFormattedData(String toString) {
        return null;
    }

    public WorkShopManager getWorkshopManager() {
        return workshopManager;
    }

    public void setWorkshopManager(WorkShopManager workshopManager) {
        this.workshopManager = workshopManager;
    }
}
