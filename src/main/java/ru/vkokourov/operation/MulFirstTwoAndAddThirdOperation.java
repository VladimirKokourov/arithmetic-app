package ru.vkokourov.operation;

public class MulFirstTwoAndAddThirdOperation extends Operation {

    @Override
    public Long calcResult() {
        return args.get(0) * args.get(1) + args.get(2);
    }
}
