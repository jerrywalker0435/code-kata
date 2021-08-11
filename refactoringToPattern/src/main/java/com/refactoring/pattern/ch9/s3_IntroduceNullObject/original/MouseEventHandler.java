package com.refactoring.pattern.ch9.s3_IntroduceNullObject.original;

import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/8/11
 */
public class MouseEventHandler {
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
