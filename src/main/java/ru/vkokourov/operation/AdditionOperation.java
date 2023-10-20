package ru.vkokourov.operation;

public class AdditionOperation extends Operation {

    @Override
    public Long calcResult() {
        return args.stream()
                .reduce(0L, Long::sum);
    }
}
