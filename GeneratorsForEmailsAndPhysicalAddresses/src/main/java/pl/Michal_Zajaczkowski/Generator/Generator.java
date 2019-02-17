package pl.Michal_Zajaczkowski.Generator;

import java.util.Random;

public class Generator {
    public String getRandomString() {
        String availableCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890qwertyuioplkjhgfdsazxcvbnm";
        StringBuilder prefix = new StringBuilder();

        Random random = new Random();
        int randomNameUser = 1 + (int) (Math.random() * ((14 - 1) + 1));

        while (prefix.length() < randomNameUser) { // length of the random string.
            int index = (int) (random.nextFloat() * availableCharacters.length());
            prefix.append(availableCharacters.charAt(index));
        }

        String userName = prefix.toString();
        return userName;

    }

    public String addDomain(String prefixStr) {

        return prefixStr + "@test.com";
    }
}
