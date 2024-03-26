package de.telran.lection4;

public class UseErrorCodes {
    public static void main(String[] args) {
        ErrorCode errorCode = ErrorCode.NOT_FOUND;

        System.out.println(errorCode);
        System.out.println(errorCode.getCode());
        System.out.println(errorCode.getMessage());

//      errorCode.setCode(999);
        System.out.println(errorCode.getCode());



    }
}
