package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class Board {
    private List<List<Point>> fields;
    private Point currentPoint;
    private final int size;

    public Board(int size) {
        this.size = size;
    }

    public Board(List<List<Point>> fields, int size) {
        this.fields = fields;
        this.size = size;
    }

    public Board getInitialBoard(char position) {
        List<List<Point>> newFields = new ArrayList<>();
        this.setFields(newFields);
        char currentPointLetter = 'A';
        for (int y = 0; y < this.getSize(); y++) {
            newFields.add(new ArrayList<>());
            for (int x = 0; x < this.getSize(); x++) {
                Point newPoint = new Point(currentPointLetter, currentPointLetter++ != position, new int[]{x, y});
                newFields.get(y).add(newPoint);
                if (!newPoint.isAvailable())
                    this.setCurrentPoint(newPoint);
            }
        }
        return this;
    }

    public static Board getBoarWithNewPosition(Board oldBoard, Point newPosition) {
        List<List<Point>> newFields = new ArrayList<>();
        Board newBoard = new Board(newFields, oldBoard.getSize());
        for (int y = 0; y < oldBoard.getSize(); y++) {
            newFields.add(new ArrayList<>());
            for (int x = 0; x < oldBoard.getSize(); x++) {
                Point newPoint = new Point(oldBoard.getFields().get(y).get(x));
                if (newPoint.positionEqualTo(newPosition)) {
                    newPoint.setAvailable(false);
                    newBoard.setCurrentPoint(newPoint);
                }
                newFields.get(y).add(newPoint);
            }
        }
        return newBoard;
    }

    public List<Point> getAvailableMoves() {
        List<Point> availablePositions = new LinkedList<>();
        int x = this.getCurrentPoint().getPosition()[0];
        int y = this.getCurrentPoint().getPosition()[1];
        availablePositions.addAll(getHorizontalAvailable(x, y));
        availablePositions.addAll(getVerticalAvailable(x, y));
        availablePositions.addAll(getDiagonalAvailable(x, y));
        availablePositions.addAll(getOtherAvailable(x, y));
        return availablePositions;
    }

    private List<Point> getOtherAvailable(int x, int y) {
        List<Point> availablePositions = new LinkedList<>();
        for (int iy = 0; iy < this.getSize(); iy++) {
            if (iy == y)
                continue;
            for (int ix = 0; ix < this.getSize(); ix++){
                Point point = this.getFields().get(iy).get(ix);
                if (ix == x || !point.isAvailable() || Math.abs(x-ix) == Math.abs(y-iy))
                    continue;
                availablePositions.add(point);
            }
        }
        return availablePositions;
    }

    private List<Point> getDiagonalAvailable(int x, int y) {
        List<Point> availablePositions = new LinkedList<>();
        for (int iy = y - 1, ix = x - 1; iy >= 0 && ix >= 0; iy--, ix--){
            Point point = this.getFields().get(iy).get(ix);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        for (int iy = y - 1, ix = x + 1; iy >= 0 && ix < this.getSize(); iy--, ix++){
            Point point = this.getFields().get(iy).get(ix);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        for (int iy = y + 1, ix = x - 1; iy < this.getSize() && ix >= 0; iy++, ix--){
            Point point = this.getFields().get(iy).get(ix);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        for (int iy = y + 1, ix = x + 1; iy < this.getSize() && ix < this.getSize(); iy++, ix++){
            Point point = this.getFields().get(iy).get(ix);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        return availablePositions;
    }

    private List<Point> getVerticalAvailable(int x, int y) {
        List<Point> availablePositions = new LinkedList<>();
        for (int i = y - 1; i >= 0; i--){
            Point point = this.getFields().get(i).get(x);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        for (int i = y + 1; i < this.getSize(); i++){
            Point point = this.getFields().get(i).get(x);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        return availablePositions;
    }

    private List<Point> getHorizontalAvailable(int x, int y) {
        List<Point> availablePositions = new LinkedList<>();
        for (int i = x - 1;i >= 0; i--){
            Point point = this.getFields().get(y).get(i);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        for (int i = x + 1; i < this.getSize(); i++){
            Point point = this.getFields().get(y).get(i);
            if (!point.isAvailable())
                continue;
            availablePositions.add(point);
            break;
        }
        return availablePositions;
    }
}
