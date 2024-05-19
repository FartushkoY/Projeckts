package de.telran.lection22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class IpAddressValidation {


        public static void main(String[] args) {
            // Проверка IP-адреса с помощью регулярных выражений
            //IP-адрес представляет собой строку в виде «A.B.C.D», где значение A, B, C и D может варьироваться от 0 до 255.
            //Допускаются начальные нули. Длина A, B, C или D не может быть больше 3.
            //
            //// ReGex to numbers from 0 to 255
            //zeroTo255 -> (\\d{1, 2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])
            //
            //// ReGex to validate complete IP address
            //IPAddress -> zeroTo255 + "\\." + zeroTo255
            //                + "\\." + zeroTo255
            //                + "\\." + zeroTo255;
            //
            //\d представляет цифры в регулярных выражениях, как [0–9]
            //\\d{1, 2} перехватывает любое однозначное или двузначное число
            //(0|1)\\d{2} перехватывает любое трехзначное число, начинающееся с 0 или 1.
            //2[0-4]\\d улавливает числа от 200 до 249.
            //25[0-5] ловит числа от 250 до 255.

            String ip1 = "000.14.22.134";
            System.out.println(isValidIPAddress(ip1));

            String ip2 = "0.0.0.0";
            System.out.println(isValidIPAddress(ip2));

            String ip3 = "00.1.23.23";
            System.out.println(isValidIPAddress(ip3));

            String ip4 = "127.0.0.1";
            System.out.println(isValidIPAddress(ip4));
        }

        public static boolean isValidIPAddress(String ip) {
            if (ip == null) {
                return false;
            }

            // Regex for digit from 0 to 255.
            String zeroTo255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])";

            // Regex for a digit from 0 to 255
            String regex = zeroTo255 + "\\."
                    + zeroTo255 + "\\."
                    + zeroTo255 + "\\."
                    + zeroTo255;

            // Compile the ReGex
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(ip);

            // Return if the IP address matched the ReGex
            return m.matches();
        }
}
