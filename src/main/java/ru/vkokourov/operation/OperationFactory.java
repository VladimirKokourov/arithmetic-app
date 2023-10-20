package ru.vkokourov.operation;

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
//        InputValidatator.validate(input);

        String operationName = getOperationName(input);
        List<Long> args = getListOfArgs(input);

        Operation operation = operationMap.get(operationName);
        if (operation == null) {
            throw new RuntimeException("Operation " + operationName + " is not supported");
        }
        operation.setArgs(args);

        return operation;
    }

    private String getOperationName(String input) {
        return input.split(" ")[0].toLowerCase();
    }

    private List<Long> getListOfArgs(String input) {
        return Arrays.stream(input.split(" "))
                .skip(1)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
