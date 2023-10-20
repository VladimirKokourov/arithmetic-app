package ru.vkokourov.service.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOutputService implements OutputService {

    private final Path output;

    public FileOutputService(Path output) {
        this.output = output;
    }

    @Override
    public void printResult(Long result) {
        try (BufferedWriter bw = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            bw.write(String.valueOf(result));
        } catch (IOException e) {
            throw new RuntimeException("File writing error");
        }
    }
}
