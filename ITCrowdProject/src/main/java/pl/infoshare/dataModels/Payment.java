package pl.infoshare.dataModels;

public class Payment {

        private String name;
        private String streetAddress;
        private String city;
        private String country;
        private String stateProvince;
        private String postalCode;

    public Payment(String name, String streetAddress, String city, String stateProvince, String country, String postalCode) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.stateProvince = stateProvince;
        this.postalCode = postalCode;
    }

        public Payment() {
            this.name = "Vintage Bags";
            this.streetAddress = "350 Du Languedoc";
            this.city = "Bourcherville";
            this.country = "Canada";
            this.stateProvince = "QC";
            this.postalCode = "J4B 0A4";
        }

    @Override
    public String toString() {
            return "Payment{name='"
                    + this.name + '\'' + ", streetAddress='"
                    + this.streetAddress + '\'' + ", city='"
                    + this.city + '\'' + ", country='"
                    + this.country + '\'' + ", stateProvince='"
                    + this.stateProvince + '\'' + ", postalCode='"
                    + this.postalCode + '\'' + '}';
        }
}
