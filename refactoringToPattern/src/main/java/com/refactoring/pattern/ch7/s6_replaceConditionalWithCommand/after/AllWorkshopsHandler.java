package com.refactoring.pattern.ch7.s6_replaceConditionalWithCommand.after;

import java.util.Iterator;
import java.util.Map;

public class AllWorkshopsHandler extends Handler {
    private static final String ALL_WORKSHOPS_STYLESHEET = "ALL_WORKSHOPS_STYLESHEET";


    public AllWorkshopsHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    @Override
    HandlerResponse execute(Map parameters) {

        XMLBuilder allWorkshopsXml = new XMLBuilder("workshops");
        WorkshopRepository repository = catalogApp.getWorkshopManager().getWorkshopRepository();
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
        String formattedXml = catalogApp.getFormattedData(allWorkshopsXml.toString());
        return new HandlerResponse(new StringBuffer(formattedXml), ALL_WORKSHOPS_STYLESHEET);
    }
}