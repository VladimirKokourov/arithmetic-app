package ru.vkokourov.operation;

import java.util.List;

public class AddFirstTwoAndMulThirdOperation extends ArithmeticOperation {

    public AddFirstTwoAndMulThirdOperation(List<Long> args) {
        super(args);
        if (args.size() != 3) {
            throw new RuntimeException("Invalid number of arguments");
        }
    }

    @Override
    public Long calcResult() {
        return (args.get(0) + args.get(1)) * args.get(2);
    }
}
