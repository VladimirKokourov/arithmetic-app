package ru.vkokourov.operation;

public class MultiplicationOperation extends Operation {

    @Override
    public Long calcResult() {
        return args.stream()
                .reduce(1L, (a, b) -> a * b);
    }
}
