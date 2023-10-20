package ru.vkokourov.operation;

import java.util.List;

public class AdditionOperation extends ArithmeticOperation {

    public AdditionOperation(List<Long> args) {
        super(args);
    }

    @Override
    public Long calcResult() {
        return args.stream()
                .reduce(0L, Long::sum);
    }
}
