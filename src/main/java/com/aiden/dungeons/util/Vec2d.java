package com.aiden.dungeons.util;

public class Vec2d {
    private final double x;
    private final double y;

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d() {
        this(0, 0);
    }

    public Vec2d add(double x, double y) {
        return new Vec2d(this.x + x, this.y + y);
    }

    public Vec2d minus(double x, double y) {
        return new Vec2d(this.x - x, this.y - y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
