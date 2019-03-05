package pl.infoshare.dataModels;


import pl.infoshare.generators.AddressGenerator;

public class Address {

    private String streetAddress;
    private String city;
    private String country;
    private String state;
    private String postalCode;

    public Address(boolean full){
        this.country = AddressGenerator.generateCountry();
        this.state = AddressGenerator.generateState();
        if (full){
            this.streetAddress = AddressGenerator.generateStreetAddress();
            this.city = AddressGenerator.generateCity();
            this.postalCode = AddressGenerator.generatePostalCode();
        }
    }

    public Address(String streetAddress, String city, String country, String state, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean equals(Address address){
        boolean streetMatch = this.streetAddress.equals(address.streetAddress);
        boolean cityMatch = this.city.equals(address.city);
        boolean countryMatch = this.country.equals(address.country);
        boolean stateMatch = this.state.equals(address.state);
        boolean postalCodeMatch = this.postalCode.equals(address.postalCode);
        return streetMatch && cityMatch && countryMatch && stateMatch && postalCodeMatch;
    }
    @Override
    public String toString() {
        return "Address{street='"
                + this.streetAddress + '\'' + ", city='"
                + this.city + '\'' + ", country='"
                + this.country + '\'' + ", state='"
                + this.state + '\'' + ", postalCode='"
                + this.postalCode + '\'' + '}';
    }
}
