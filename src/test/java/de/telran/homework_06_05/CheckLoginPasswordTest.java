package de.telran.homework_06_05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckLoginPasswordTest {
    private static CheckLoginPassword checkLoginPassword;

    @BeforeAll
    public static void init() {
        checkLoginPassword = new CheckLoginPassword();
    }

    @BeforeEach
    public void dataInit() {
        checkLoginPassword.setUserData("test user data");
    }



    @Test
    public void checkLogin() {
        assertTrue(CheckLoginPassword.checkLoginPassword("login", "123", "123"));
        assertTrue(CheckLoginPassword.checkLoginPassword("lOgin", "123", "123"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login1", "123", "123"));
        assertFalse(CheckLoginPassword.checkLoginPassword("loginjguyfjhhlhgifvh", "123", "123"));
        assertTrue(CheckLoginPassword.checkLoginPassword("loginjguyfjhhlhgifv", "123", "123"));
        assertFalse(CheckLoginPassword.checkLoginPassword("loginj!", "123", "123"));
        assertFalse(CheckLoginPassword.checkLoginPassword("", "123", "123"));
        assertThrows(NullPointerException.class, () -> CheckLoginPassword.checkLoginPassword(null, "123", "123"));
        assertThrows(NullPointerException.class, () -> CheckLoginPassword.checkLoginPassword(null, null, null));
    }

    @Test
    public void checkPassword() {
        assertTrue(CheckLoginPassword.checkLoginPassword("login", "1111111111111111111", "1111111111111111111"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "11111111111111111111", "11111111111111111111"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "f", "f"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "1f", "1f"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "1+", "1+"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "", ""));
        assertThrows(NullPointerException.class, () -> CheckLoginPassword.checkLoginPassword("login", null, null));
    }

    @Test
    public void checkconfirmPassword() {
        assertTrue(CheckLoginPassword.checkLoginPassword("login", "123", "123"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "123", "12"));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "123", ""));
        assertFalse(CheckLoginPassword.checkLoginPassword("login", "123", null));
    }


    @Test
    public void testgetUserInfo() {
        String result = checkLoginPassword.getUserInfo();
        String expected = "<user>test user data</user>";
        assertEquals(expected, result);

        checkLoginPassword.setUserData(null);
        result = checkLoginPassword.getUserInfo();
        expected = "<user>null</user>";
        assertEquals(expected, result);

        checkLoginPassword.setUserData("");
        result = checkLoginPassword.getUserInfo();
        expected = "<user></user>";
        assertEquals(expected, result);

    }
}