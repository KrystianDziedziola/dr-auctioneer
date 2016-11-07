package edu.uz.dr.auctioneer.model;

class Address {

    private final String street;
    private final String city;
    private final String country;

    public Address(final String street, final String city, final String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
