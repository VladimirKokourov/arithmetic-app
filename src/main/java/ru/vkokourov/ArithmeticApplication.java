package ru.vkokourov;

import ru.vkokourov.operation.Operation;
import ru.vkokourov.operation.OperationFactory;
import ru.vkokourov.service.InputOutputServiceFactory;
import ru.vkokourov.service.input.InputService;
import ru.vkokourov.service.output.OutputService;
import ru.vkokourov.util.Validator;

public class ArithmeticApplication {
    public static void main(String[] args) {

        try {
            Validator validator = new Validator();
            validator.modeValidate(args);

            InputOutputServiceFactory serviceFactory = new InputOutputServiceFactory(args);
            InputService inputService = serviceFactory.getInputService();
            OutputService outputService = serviceFactory.getOutputService();

            String operationAndArgs = inputService.getOperationAndArgs();

            OperationFactory operationFactory = new OperationFactory();
            validator.operationValidate(operationAndArgs);
            Operation operation = operationFactory.getOperation(operationAndArgs);
            Long result = operation.calcResult();
            outputService.printResult(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}