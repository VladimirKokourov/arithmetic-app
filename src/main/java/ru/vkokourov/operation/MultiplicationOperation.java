package ru.vkokourov.operation;

import java.util.List;

public class MultiplicationOperation extends Operation {

    @Override
    public Long calcResult() {
        return args.stream()
                .reduce(1L, (a, b) -> a * b);
    }
}
