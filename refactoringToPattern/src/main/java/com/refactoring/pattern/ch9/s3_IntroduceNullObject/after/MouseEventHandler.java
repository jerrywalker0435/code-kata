package com.refactoring.pattern.ch9.s3_IntroduceNullObject.after;

import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class MouseEventHandler {
    public MouseEventHandler(Object o) {

    }

    public boolean mouseMove(String graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseDown(String graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseUp(String graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseExit(String graphicsContext, Event event, int x, int y) {
        return false;
    }
}
