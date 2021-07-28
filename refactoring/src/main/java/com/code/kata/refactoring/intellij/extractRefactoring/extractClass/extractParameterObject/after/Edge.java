package com.code.kata.refactoring.intellij.extractRefactoring.extractClass.extractParameterObject.after;

public class Edge {
    private final float edgeWidth;
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public Edge(float edgeWidth, int x1, int x2, int y1, int y2) {
        this.edgeWidth = edgeWidth;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public float getEdgeWidth() {
        return edgeWidth;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
