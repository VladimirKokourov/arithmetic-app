package ru.vkokourov.service.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputService implements InputService {

    private final Path input;

    public FileInputService(Path input) {
        this.input = input;
    }

    @Override
    public String getOperationAndArgs() {
        String operationAndArgs;
        try (BufferedReader br = Files.newBufferedReader(input, StandardCharsets.UTF_8)) {
            operationAndArgs = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("File reading error");
        }

        return operationAndArgs;
    }
}
