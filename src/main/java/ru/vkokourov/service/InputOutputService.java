package ru.vkokourov.service;

import ru.vkokourov.operation.OperationFactory;

public abstract class InputOutputService {

    protected final OperationFactory operationFactory;

    public InputOutputService(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public abstract void printResult();
}
