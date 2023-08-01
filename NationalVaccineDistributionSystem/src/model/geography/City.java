package model.geography;

import java.util.HashSet;

public class City {

    private final int cityId;

    private static int count = 1;

    private String cityName;

    private int cityPopulation;

    private HashSet<Address> listOfAddresses;

    public City(String cityName) {
        cityId = ++count;
        this.cityName = cityName;
        this.listOfAddresses = new HashSet<>();
    }

    public Address addAddress(String street, String postalCode) {
        Address address = new Address(street, postalCode);
        listOfAddresses.add(address);
        return address;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public HashSet<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(HashSet<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return cityName;
    }

}