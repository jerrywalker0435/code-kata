package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractParameterObject.original;

import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    private void drawEdge(Graphics g, float edgeWidth,
                          int x1, int x2, int y1, int y2) {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(edgeWidth));
        g.drawLine(x1, y1, x2, y2);
    }
}
