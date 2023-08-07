package nvds.geography;

import java.util.HashSet;
import nvds.organization.Hospital;

public class City {

    private final int id;

    private static int count = 1;

    private String name;

    private int population;

    private HashSet<Address> addressList;

    private Hospital affiliatedHospital;


    public City(String name) {
        id =  ++ count;
        this.name = name;
        addressList = new HashSet<>();
    }

    public Address addAddress(String street , String postalCode) {
        Address address = new Address(street , postalCode);
        addressList.add(address);
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String cityName) {
        this.name = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public HashSet<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(HashSet<Address> addressList) {
        this.addressList = addressList;
    }

    public Hospital getAffiliatedHospital() {
        return affiliatedHospital;
    }

    public void setAffiliatedHospital(Hospital affiliatedHospital) {
        this.affiliatedHospital = affiliatedHospital;
    }


    @Override
    public String toString() {
        return name;
    }

}
