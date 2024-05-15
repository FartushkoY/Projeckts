package de.telran.lection20.exception;

import de.telran.lection20.exception.InputValidationException;

public class StringProcessor {

    public static String process(String string) throws InputValidationException {
        if (string == null) throw new InputValidationException("input string cannt be null");
        if (string.length() < 5) throw new InputValidationException("string length is too short");


        return "----" + string + "----";
    }
}
