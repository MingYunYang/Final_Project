package model;

import model.geography.Country;
import model.organization.OrganizationDirectory;
import java.util.ArrayList;

public class Ecosystem {

    private static Ecosystem ecosystem;

    private final OrganizationDirectory organizationDirectory;

    private final ArrayList<Country> countryList;

    public static Ecosystem getInstance() {
        if ( ecosystem == null ) {
            ecosystem = new Ecosystem();
        }
        return ecosystem;
    }

    private Ecosystem() {
        organizationDirectory = new OrganizationDirectory();
        countryList = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country addCountry(String countryName) {
        Country country = new Country(countryName);
        countryList.add(country);
        return country;
    }

}
