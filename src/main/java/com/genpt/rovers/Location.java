package com.genpt.rovers;

import com.genpt.rovers.exception.IllegalInputException;

public class Location {
    private int x;
    private int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public static Location valueOf(String s) {
        String[] tokens = s.split(" ");
        if (tokens.length != 2)
            throw new IllegalInputException("Location must be of two numers separated by a space: " + s);
        return new Location(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }
    @Override
    public String toString() {
        return x + " " + y;
    }

    public void move(Direction direction) {
        switch (direction) {
        case N:
            y++;
            break;
        case S:
            y--;
            break;
        case E:
            x++;
            break;
        case W:
            x--;
            break;
        default:
            throw new IllegalInputException(direction.toString());
        }

    }
}
