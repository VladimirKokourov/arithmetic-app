package ru.vkokourov.util;

public class InputValidator {

    public static void validate(String input) {
        if (input == null) {
            throw new RuntimeException("Input is null");
        }
        if (input.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
        if (input.split(" +").length <= 1) {
            throw new RuntimeException("Number of arguments is less than zero");
        }
        if (!input.matches("[A-Za-z]+( +([0-9]+))+")) {
            throw new RuntimeException("Invalid inputs");
        }
    }
}