package com.genpt.rovers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.genpt.rovers.command.Command;

/**
 * Mars Rover App
 *
 */
public class App {
    public App(String inputFileName) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFileName)).collect(Collectors.toList());
        Location boundary = Location.valueOf(lines.get(0));
        for (int i = 1; i < lines.size(); i = i + 2) {
            Rover rover = new Rover().setBoundary(boundary).land(lines.get(i)).move(Command.valuesOf(lines.get(i + 1)));
            System.out.println(rover);
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java App <inputFileName>");
        } else
            new App(args[0]);
    }
}
