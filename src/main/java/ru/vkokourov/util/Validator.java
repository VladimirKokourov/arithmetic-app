package ru.vkokourov.util;

public class Validator {

    public static void operationValidate(String operationAndArgs) {
        if (operationAndArgs == null) {
            throw new RuntimeException("Input is null");
        }
        if (operationAndArgs.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
        if (operationAndArgs.split(" +").length <= 1) {
            throw new RuntimeException("Number of arguments is less than zero");
        }
        if (!operationAndArgs.matches("[A-Za-z]+( +([0-9]+))+")) {
            throw new RuntimeException("Invalid inputs: " + operationAndArgs);
        }
    }

    public static void modeValidate(String[] modes) {
        if (modes == null) {
            throw new RuntimeException("Input modes is null");
        }
        if (modes.length == 0) {
            throw new RuntimeException("Input modes is empty");
        }
        if (modes.length != 2) {
            throw new RuntimeException("Incorrect number of modes");
        }
    }
}