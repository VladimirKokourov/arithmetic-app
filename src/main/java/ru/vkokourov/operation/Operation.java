package ru.vkokourov.operation;

import java.util.List;

public abstract class Operation {

    protected List<Long> args;

    public void setArgs(List<Long> args) {
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
