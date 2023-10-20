package ru.vkokourov.operation;

import ru.vkokourov.util.InputValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationFactory {

    private final Map<String, Operation> operationMap;

    public OperationFactory() {
        operationMap = new HashMap<>();
        operationMap.put("add", new AdditionOperation());
        operationMap.put("mul", new MultiplicationOperation());
        operationMap.put("muladd", new MulFirstTwoAndAddThirdOperation());
        operationMap.put("addmul", new AddFirstTwoAndMulThirdOperation());
    }

    public Operation getOperation(String input) {
        InputValidator.validate(input);

        String[] arrInput = input.split(" ");
        String operationName = arrInput[0];
        List<Long> args = Arrays.stream(arrInput)
                .skip(1)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Operation operation = operationMap.get(operationName);
        if (operation == null) {
            throw new RuntimeException("Operation " + operationName + " is not supported");
        }
        operation.setArgs(args);

        return operation;
    }
}
