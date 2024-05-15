package de.telran.lection20.exception;

public class UseStringProcessor {

    public static void main(String[] args) {
        try {
            method();
        } catch (InputValidationException e) {
            e.printStackTrace();

        }

    }

    private static void method() throws InputValidationException {
        try {
            String result = StringProcessor.process("string");
            System.out.println(result);
            result = StringProcessor.process("text");
            System.out.println(result);

        } catch (InputValidationException e) {
            e.printStackTrace();
        }
    }

}
