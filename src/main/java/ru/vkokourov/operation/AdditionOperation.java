package ru.vkokourov.operation;

import java.util.List;

public class AdditionOperation extends Operation {

    @Override
    public Long calcResult() {
        return args.stream()
                .reduce(0L, Long::sum);
    }
}
