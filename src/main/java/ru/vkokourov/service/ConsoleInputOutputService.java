package ru.vkokourov.service;

import ru.vkokourov.operation.Operation;
import ru.vkokourov.operation.OperationFactory;

import java.util.Scanner;

public class ConsoleInputOutputService extends InputOutputService {

    private static final String ANSWER = "Ответ: ";
    private final Scanner scanner;

    public ConsoleInputOutputService(OperationFactory operationFactory, Scanner scanner) {
        super(operationFactory);
        this.scanner = scanner;
    }

    @Override
    public void printResult() {
        String input = scanner.nextLine();
        Operation operation = operationFactory.getOperation(input);

        System.out.println(ANSWER + operation.calcResult());
    }
}
