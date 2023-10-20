package ru.vkokourov.service;

import ru.vkokourov.operation.Operation;
import ru.vkokourov.operation.OperationFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputOutputService extends InputOutputService {

    private final Path input;
    private final Path output;

    public FileInputOutputService(OperationFactory operationFactory, Path input, Path output) {
        super(operationFactory);
        this.input = input;
        this.output = output;
    }

    @Override
    public void printResult() {
        try (BufferedReader br = Files.newBufferedReader(input, StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            String line;
            while (br.ready()) {
                line = br.readLine();
                Operation operation = operationFactory.getOperation(line);
                bw.append(String.valueOf(operation.calcResult()));
                if (br.ready()) {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
