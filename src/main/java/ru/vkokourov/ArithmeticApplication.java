package ru.vkokourov;

import ru.vkokourov.operation.Operation;
import ru.vkokourov.operation.OperationFactory;
import ru.vkokourov.service.InputOutputServiceFactory;
import ru.vkokourov.service.input.InputService;
import ru.vkokourov.service.output.OutputService;

public class ArithmeticApplication {
    public static void main(String[] args) {

        try {
            InputOutputServiceFactory serviceFactory = new InputOutputServiceFactory(args);
            OperationFactory operationFactory = new OperationFactory();

            InputService inputService = serviceFactory.getInputService();
            OutputService outputService = serviceFactory.getOutputService();

            String operationAndArgs = inputService.getOperationAndArgs();
            Operation operation = operationFactory.getOperation(operationAndArgs);
            Long result = operation.calcResult();
            outputService.printResult(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}