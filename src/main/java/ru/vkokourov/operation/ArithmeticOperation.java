package ru.vkokourov.operation;

import java.util.List;

public abstract class ArithmeticOperation {

    protected final List<Long> args;

    public ArithmeticOperation(List<Long> args) {
        if (args == null) {
            throw new RuntimeException("List of args is null");
        }
        if (args.isEmpty()) {
            throw new RuntimeException("List of args is empty");
        }
        this.args = args;
    }

    public abstract Long calcResult();
}
