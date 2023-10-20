package ru.vkokourov;

import ru.vkokourov.operation.OperationFactory;
import ru.vkokourov.service.InputOutputService;
import ru.vkokourov.service.InputOutputServiceFactory;

public class ArithmeticApplication {
    public static void main(String[] args) {

        OperationFactory operationFactory = new OperationFactory();
        InputOutputServiceFactory iosFactory = new InputOutputServiceFactory(operationFactory);

        try {
            InputOutputService service = iosFactory.getInputOutputService(args);
            service.printResult();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}