package pl.infoshare.utils;

import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Payment;
import pl.infoshare.dataModels.RegisteredUser;

public class App
{
    public static void main( String[] args )
    {
        Address address = new Address(true);
        RegisteredUser user = new RegisteredUser();
        Payment payment = new Payment();


        System.out.println(address.getStreetAddress() + " " +
                address.getCity() + " " + address.getCountry() + " " + address.getState() + " " + address.getPostalCode());
        System.out.println(user.getFirstname() + " " + user.getLastname() + " " + user.getEmail() + " " + user.getPhoneNumber());


        System.out.println(payment.toString());
        System.out.println(address.toString());
        System.out.println(user.toString());
    }
}
