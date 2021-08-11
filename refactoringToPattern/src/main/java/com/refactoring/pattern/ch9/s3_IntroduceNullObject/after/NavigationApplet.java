package com.refactoring.pattern.ch9.s3_IntroduceNullObject.after;

import java.applet.Applet;
import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class NavigationApplet extends Applet {

    private MouseEventHandler mouseEventHandler = new NullMouseHandler(null);

    private String graphicsContext;

    public boolean mouseMove(Event event, int x, int y) {
        return mouseEventHandler.mouseMove(graphicsContext, event, x, y);
    }

    public boolean mouseDown(Event event, int x, int y) {
        return mouseEventHandler.mouseDown(graphicsContext, event, x, y);
    }

    public boolean mouseUp(Event event, int x, int y) {
        return mouseEventHandler.mouseUp(graphicsContext, event, x, y);
    }

    public boolean mouseExit(Event event, int x, int y) {
        return mouseEventHandler.mouseExit(graphicsContext, event, x, y);
    }
}
