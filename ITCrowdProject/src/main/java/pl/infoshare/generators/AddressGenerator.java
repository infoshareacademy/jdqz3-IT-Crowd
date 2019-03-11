package pl.infoshare.generators;

public class AddressGenerator extends RandomGenerator{

    private static String[] cities = {
            "Belgium", "Brazil", "Canada", "China",
            "Czech Republic", "France", "India",
            "Italy", "Switzerland", "United States" };

    public static String generateCity(){
        return capitalize(genrateRandomString(7));
    }

    public static String generateState(){
        return capitalize(genrateRandomString(9));
    }

    public static String generateStreetAddress(){
        int number = generateRandomNumber(4, 250);
        String street = capitalize(genrateRandomString(12));
        return street + " " + number;
    }

    public static String generateCountry(){
        return cities[generateRandomNumber(0, cities.length - 1)];
    }

    public static String generatePostalCode(){
        int firstHalf = generateRandomNumber(10, 99);
        int secondHalf = generateRandomNumber(100, 999);
        return firstHalf + "-" + secondHalf;
    }
}
