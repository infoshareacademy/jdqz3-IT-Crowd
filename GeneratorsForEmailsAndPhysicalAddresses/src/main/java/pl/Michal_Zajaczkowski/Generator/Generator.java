package pl.Michal_Zajaczkowski.Generator;

import java.util.Random;

public class Generator {
    public String getSaltString() {
        String nameUser = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890qwertyuioplkjhgfdsazxcvbnm";
        StringBuilder prefix = new StringBuilder();

        Random random = new Random();
        int randomNameUser = 1 + (int) (Math.random() * ((14 - 1) + 1));

        while (prefix.length() < randomNameUser) { // length of the random string.
            int index = (int) (random.nextFloat() * nameUser.length());
            prefix.append(nameUser.charAt(index));
        }

        String userName = prefix.toString();
        return userName;

    }

    public String domena(String prefixStr) {

        return prefixStr + "@test.com";
    }
}
