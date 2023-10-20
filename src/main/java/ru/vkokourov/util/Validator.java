package ru.vkokourov.util;

public class Validator {

    public static void operationValidate(String operationAndArgs) {
        checkNullAndEmpty(operationAndArgs);
        if (operationAndArgs.split(" +").length <= 1) {
            throw new RuntimeException("Number of arguments is less than zero");
        }
        if (!operationAndArgs.matches("[A-Za-z]+( +([0-9]+))+")) {
            throw new RuntimeException("Invalid inputs: " + operationAndArgs);
        }
    }

    public static void modeValidate(String mode) {
        checkNullAndEmpty(mode);
        if (mode.split(" +").length != 2) {
            throw new RuntimeException("Number of arguments is less than zero");
        }
    }

    private static void checkNullAndEmpty(String str) {
        if (str == null) {
            throw new RuntimeException("Input is null");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
    }
}