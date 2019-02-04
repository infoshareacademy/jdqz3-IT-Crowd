package pl.infoshare.utils;

import java.util.*;

public class PhoneNumber {

    public static String getRandomPhoneNumber() {
        List<String> listRandomDigits = new ArrayList<>();
        String phoneNumber = "";

        for (int i = 0; i < 9; i++) {
            Integer r = (int) (Math.random() * 9);
            listRandomDigits.add(Integer.toString(r));
        }
        for (String digit : listRandomDigits) {
            phoneNumber = phoneNumber.concat(digit);
        }
        return  phoneNumber;
    }
    public static void printNumber(String number) {
        System.out.println(number);
    }
}
