package ru.vkokourov.operation;

import java.util.List;

public class AddFirstTwoAndMulThirdOperation extends Operation {

    @Override
    public void setArgs(List<Long> args) {
        super.setArgs(args);
        if (args.size() != 3) {
            throw new RuntimeException("Invalid number of arguments: " + args.size());
        }
    }

    @Override
    public Long calcResult() {
        return (args.get(0) + args.get(1)) * args.get(2);
    }
}
