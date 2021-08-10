package com.refactoring.pattern.ch7.s6_replaceConditionalWithCommand.after;

import java.util.Map;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public abstract class Handler {
    protected final CatalogApp catalogApp;

    public Handler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }

    abstract HandlerResponse execute(Map parameters);
}
