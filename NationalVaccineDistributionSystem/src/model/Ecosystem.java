package model;

import model.geography.Country;
import model.organization.OrganizationDirectory;
import java.util.ArrayList;

public class Ecosystem {

    private static Ecosystem ecosystem;

    private final OrganizationDirectory organizationDirectory;

    private final ArrayList<Country> listOfCountries;

    public static Ecosystem getInstance() {
        if (ecosystem == null) {
            ecosystem = new Ecosystem();
        }
        return ecosystem;
    }

    private Ecosystem() {
        organizationDirectory = new OrganizationDirectory();
        listOfCountries = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public ArrayList<Country> getListOfCountries() {
        return listOfCountries;
    }

    public Country addCountry(String name) {
        Country country = new Country(name);
        listOfCountries.add(country);
        return country;
    }

}
