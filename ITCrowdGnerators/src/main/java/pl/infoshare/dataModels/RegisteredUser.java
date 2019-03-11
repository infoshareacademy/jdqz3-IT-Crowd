package pl.infoshare.dataModels;


import pl.infoshare.generators.CredentialsGenerator;

public class RegisteredUser extends UserBase {

    private String password;

    public RegisteredUser(){
        this.isRegistred = true;
        this.password = CredentialsGenerator.generatePassword();
        Address add = new Address(true);
        this.setAddress(add);
        this.setShippingAddress(add);
    }

    public RegisteredUser(boolean withAlternativeShippingAddress){
        if (withAlternativeShippingAddress){
            this.isRegistred = true;
            this.password = CredentialsGenerator.generatePassword();
            this.setAddress(new Address(true));
            this.setShippingAddress(new Address(true));
        } else {
            new RegisteredUser();
        }
    }
    @Override
    public String toString() {
        return "User{firstname='"
                + this.firstname  + '\'' + ", lastname='"
                + this.lastname + '\'' + ", \n address='"
                + this.address.toString() + '\'' + ", phoneNumber='"
                + this.phoneNumber + '\'' + ", \n shippingAddress='"
                + this.shippingAddress.toString() + '\'' + ", email='"
                + this.email + '\'' + '}';
    }

}
