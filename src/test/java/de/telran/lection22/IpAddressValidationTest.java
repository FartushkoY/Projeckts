package de.telran.lection22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpAddressValidationTest {

    @Test
    public void test() {
        boolean isValid = IpAddressValidation.isValidIPAddress("127.0.0.1");
        Assertions.assertTrue(isValid);

        isValid = IpAddressValidation.isValidIPAddress("127.0.0.300");
        Assertions.assertFalse(isValid);

        isValid = IpAddressValidation.isValidIPAddress("127.0.0");
        Assertions.assertFalse(isValid);

    }
}