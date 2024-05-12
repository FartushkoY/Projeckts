package de.telran.homework_06_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLoginPassword {
    public static void main(String[] args){

        System.out.println(checkLoginPassword("john", "123", "123"));
        System.out.println(checkLoginPassword("john", "123", "1234"));
        System.out.println(checkLoginPassword("john", "123@", "123@"));
        System.out.println(checkLoginPassword("john@", "123", "123"));
    }


    public static boolean checkLoginPassword(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20 || !login.matches("[a-zA-Z]+"))
                throw new WrongLoginException("Incorrect login");

            if (password.length() > 20 || !password.matches("[0-9]+"))
                throw new WrongPasswordException("Incorrect password");
            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Password does not match the password filed");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }
}
