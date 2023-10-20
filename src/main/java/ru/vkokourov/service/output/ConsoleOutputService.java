package ru.vkokourov.service.output;

public class ConsoleOutputService implements OutputService {

    private static final String ANSWER = "Ответ: ";

    @Override
    public void printResult(Long result) {
        System.out.println(ANSWER + result);
    }
}
