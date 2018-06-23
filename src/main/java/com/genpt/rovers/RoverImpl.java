package com.genpt.rovers;

import com.genpt.rovers.command.Command;
import com.genpt.rovers.command.MoveCommand;
import com.genpt.rovers.command.TurnCommand;
import com.genpt.rovers.exception.IllegalInputException;
import com.genpt.rovers.exception.OutOfBoundaryException;
import com.genpt.rovers.exception.UnknownCommandException;

public class RoverImpl implements Rover {

    private Location location;
    private Direction direction;
    private Location boundary;
    @Override
    public RoverImpl land(String position) {
        String[] tokens = position.split(" ");
        if (tokens.length != 3)
            throw new IllegalInputException("Position input line must be two numbers and a direction. Input line: " + position);
        return land(new Location(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), Direction.valueOf(tokens[2].charAt(0)));
    }
    protected RoverImpl land(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
        return this;
    }
    @Override
    public RoverImpl setBoundary(Location boundary) {
        this.boundary = boundary;
        return this;
    }
    protected void move(Command command) {
        if (command instanceof TurnCommand) {
            TurnCommand turn = (TurnCommand) command;
            if (turn == TurnCommand.L)
                direction = direction.left();
            else if (turn == TurnCommand.R)
                direction = direction.right();
            else
                throw new UnknownCommandException(turn);
        } else if (command instanceof MoveCommand) {
            move();
        }
    }
    private void move() {
        location.move(direction);
        if (boundary != null)
            checkBoundary();
    }

    private void checkBoundary() {
        if (location.getX() > boundary.getX() || location.getY() > boundary.getY() || location.getX() < 0 || location.getY() < 0)
            throw new OutOfBoundaryException("Out of boundary: location " + location + " is beyond boundary " + boundary);

    }
    @Override
    public RoverImpl move(Command[] commands) {
        for (Command c : commands)
            move(c);
        return this;
    }
    @Override
    public String toString() {
        return location + " " + direction;
    }
}
