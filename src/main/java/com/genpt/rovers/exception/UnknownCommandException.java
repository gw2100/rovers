package com.genpt.rovers.exception;

import com.genpt.rovers.command.Command;

public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException(char command) {
        super("This command is not recgonized: " + command);
    }
    public UnknownCommandException(Command command) {
        super("This command is not recgonized: " + command);
    }
}
