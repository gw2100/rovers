package com.genpt.rovers;

import com.genpt.rovers.command.Command;

public interface Rover {
    Rover setBoundary(Location boundary);
    Rover land(String position);
    Rover move(Command[] commands);
}
