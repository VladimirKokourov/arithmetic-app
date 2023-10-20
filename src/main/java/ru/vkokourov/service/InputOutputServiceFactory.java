package ru.vkokourov.service;

import ru.vkokourov.service.input.ConsoleInputService;
import ru.vkokourov.service.input.FileInputService;
import ru.vkokourov.service.input.InputService;
import ru.vkokourov.service.output.ConsoleOutputService;
import ru.vkokourov.service.output.FileOutputService;
import ru.vkokourov.service.output.OutputService;
import ru.vkokourov.util.Validator;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputOutputServiceFactory {

    public static final String FILE_FORMAT = ".txt";

    private final String[] args;

    public InputOutputServiceFactory(String[] args) {
        Validator.modeValidate(args);
        this.args = args;
    }

    public InputService getInputService() {
        String inputMode = args[0];
        if (inputMode.equals("-")) {
            Scanner scanner = new Scanner(System.in);
            return new ConsoleInputService(scanner);
        } else if (inputMode.endsWith(FILE_FORMAT)) {
            Path input;
            try {
                input = Paths.get(inputMode);
            } catch (InvalidPathException e) {
                throw new RuntimeException(e);
            }

            return new FileInputService(input);
        } else {
            throw new RuntimeException("Unknown command: " + inputMode);
        }
    }

    public OutputService getOutputService() {
        String outputMode = args[1];
        if (outputMode.equals("-")) {
            return new ConsoleOutputService();
        } else if (outputMode.endsWith(FILE_FORMAT)) {
            Path output;
            try {
                output = Paths.get(outputMode);
            } catch (InvalidPathException e) {
                throw new RuntimeException(e);
            }

            return new FileOutputService(output);
        } else {
            throw new RuntimeException("Unknown command: " + outputMode);
        }
    }
}
