package pl.infoshare.dataModels;

import pl.infoshare.generators.CredentialsGenerator;

public class UserBase {

    protected String firstname;
    protected String lastname;
    protected Address address;
    protected Address shippingAddress;
    protected String email;
    protected String phoneNumber;
    protected boolean isRegistred;


    protected UserBase(){
        this.firstname = CredentialsGenerator.generateFirstname();
        this.lastname = CredentialsGenerator.generateLastname();
        this.address = new Address(false);
        this.shippingAddress = this.address;
        this.email = CredentialsGenerator.generateEmail();
        this.phoneNumber = CredentialsGenerator.generatePhoneNumber();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
