package ru.vkokourov.operation;

import java.util.List;

public class AddFirstTwoAndMulThirdOperation extends Operation {

    @Override
    public Long calcResult() {
        return (args.get(0) + args.get(1)) * args.get(2);
    }
}
