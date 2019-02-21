package pl.infoshare.utils;

import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.RegisteredUser;

public class App
{
    public static void main( String[] args )
    {
        Address address = new Address(true);
        RegisteredUser user = new RegisteredUser();


        System.out.println(address.getStreetAddress() + " " +
                address.getCity() + " " + address.getCountry() + " " + address.getState() + " " + address.getPostalCode());
        System.out.println(user.getFirstname() + " " + user.getLastname() + " " + user.getEmail() + " " + user.getPhoneNumber());
    }
}
