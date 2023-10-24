package ru.vkokourov.service.input;

import java.util.Scanner;

public class ConsoleInputService implements InputService {

    private final Scanner scanner;

    public ConsoleInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getOperationAndArgs() {
        return scanner.nextLine();
    }
}
