package ru.vkokourov.service;

import ru.vkokourov.operation.OperationFactory;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputOutputServiceFactory {

    public static final String FILE_FORMAT = ".txt";

    private final OperationFactory operationFactory;

    public InputOutputServiceFactory(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public InputOutputService getInputOutputService(String[] args) {
        if (args.length == 1 && args[0].equals("--")) {
            Scanner scanner = new Scanner(System.in);
            return new ConsoleInputOutputService(operationFactory, scanner);
        } else if (args.length == 2 && args[0].endsWith(FILE_FORMAT) && args[1].endsWith(FILE_FORMAT)) {
            Path input;
            Path output;
            try {
                input = Paths.get(args[0]);
                output = Paths.get(args[1]);
            } catch (InvalidPathException e) {
                throw new RuntimeException(e);
            }

            return new FileInputOutputService(operationFactory, input, output);
        } else {
            throw new RuntimeException("Unknown command: " + args[0]);
        }
    }
}
