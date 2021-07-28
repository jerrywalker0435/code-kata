package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractParameterObject.after;

import java.awt.*;

/**
 * @author zhangyu201
 * @date 2021/7/28
 */
public class Class {
    private void drawEdge(Graphics g, Edge edge) {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(edge.getEdgeWidth()));
        g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
    }
}
