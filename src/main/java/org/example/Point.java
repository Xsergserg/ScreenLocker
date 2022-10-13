package org.example;

import lombok.Data;

@Data
public class Point {
    private final char name;
    private final int[] position;
    private boolean available;

    public Point(char name, boolean available, int[] position) {
        this.name = name;
        this.available = available;
        this.position = new int[2];
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    public Point(Point that) {
        this.name = that.getName();
        this.available = that.isAvailable();
        this.position = new int[2];
        this.position[0] = that.position[0];
        this.position[1] = that.position[1];
    }

    public boolean positionEqualTo(Point that) {
        return this.getPosition()[0] == that.getPosition()[0] && this.getPosition()[1] == that.getPosition()[1];
    }
}
