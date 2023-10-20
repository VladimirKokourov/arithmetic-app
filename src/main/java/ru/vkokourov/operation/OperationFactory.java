package ru.vkokourov.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationFactory {

    public static final String ADD = "add";
    public static final String MUL = "mul";
    public static final String MULADD = "muladd";
    public static final String ADDMUL = "addmul";

    public static ArithmeticOperation getOperation(String input) {
//        InputValidatator.validate(input);

        String operationName = getOperationName(input);
        List<Long> args = getListOfArgs(input);

        switch (operationName) {
            case ADD:
                return new AdditionOperation(args);
            case MUL:
                return new MultiplicationOperation(args);
            case MULADD:
                return new MulFirstTwoAndAddThirdOperation(args);
            case ADDMUL:
                return new AddFirstTwoAndMulThirdOperation(args);
            default:
                throw new RuntimeException();
        }
    }

    private static String getOperationName(String input) {
        return input.split(" ")[0].toLowerCase();
    }

    private static List<Long> getListOfArgs(String input) {
        return Arrays.stream(input.split(" "))
                .skip(1)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
