package dev.jlarsen.demo.models;

public class Location {

    private long id;
    private String city;
    private String country;

    public Location() {
    }

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
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
}
