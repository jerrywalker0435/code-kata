package com.refactoring.pattern.ch7.s6_replaceConditionalWithCommand.after;

import java.util.Map;

public class NewWorkshopHandler extends Handler {

    public NewWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    HandlerResponse execute(Map parameters) {
        String nextWorkshopId = catalogApp.getWorkshopManager().getNextWorkshopId();
        StringBuffer newWorkshopContents = catalogApp.getWorkshopManager().createNewFileFromTemplate(
                nextWorkshopId,
                catalogApp.getWorkshopManager().getWorkshopDir(),
                catalogApp.getWorkshopManager().getWorkshopTemplate()
        );
        catalogApp.getWorkshopManager().addWorkshop(newWorkshopContents);
        parameters.put("id", nextWorkshopId);
      return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    }
}