package ru.vkokourov.operation;

import java.util.List;

public abstract class ArithmeticOperation {

    protected final List<Long> args;

    public ArithmeticOperation(List<Long> args) {
        this.args = args;
    }

    public abstract Long calcResult();
}
