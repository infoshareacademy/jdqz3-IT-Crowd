package pl.infoshare.generators;


public class CredentialsGenerator extends RandomGenerator{
    private static String emailDomain = "@test.com";

    public static String generateFirstname(){
        return capitalize(genrateRandomString(8));
    }

    public static String generateLastname(){
        return capitalize(genrateRandomString(14));
    }

    public static String generateEmail(){
        String login = genrateRandomString(10);
        return login + emailDomain;
    }

    public static String generatePassword(){
        return genrateRandomString(12);
    }

    public static String generatePhoneNumber(){
        return genrateRandomNumbers(9);
    }
}
