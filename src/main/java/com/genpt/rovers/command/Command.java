package com.genpt.rovers.command;

import com.genpt.rovers.exception.UnknownCommandException;

public interface Command {
    static Command[] valuesOf(String s) {
        Command[] commands = new Command[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case 'L':
                commands[i] = TurnCommand.L;
                break;
            case 'R':
                commands[i] = TurnCommand.R;
                break;
            case 'M':
                commands[i] = MoveCommand.M;
                break;
            default:
                throw new UnknownCommandException(c);
            }
        }
        return commands;
    }
}
