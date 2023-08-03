package model;

import model.geography.Country;
import model.organization.OrganizationDirectory;
import java.util.ArrayList;

// This is a singleton class meaning their can only be one instance of the class in the system
public class Ecosystem {

    // Ecosystem class variable
    private static Ecosystem ecosystem;

    // list of organizations in the ecosystem
    private final OrganizationDirectory organizationDirectory;

    // list of countries that implement this ecosystem
    private final ArrayList<Country> countryList;

    // Get an Instance of the ecosystem class
    // If none, create one and return that instance.
    public static Ecosystem getInstance() {
        if (ecosystem == null) {
            ecosystem = new Ecosystem();
        }
        return ecosystem;
    }

    // Initializes empty lists of organizations and countries within the ecosystem
    private Ecosystem() {
        organizationDirectory = new OrganizationDirectory();
        countryList = new ArrayList<>();
    }

    // get list of organizations within the ecosystem
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    // get lists of countries within the organization
    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    // Add a country to the organization
    // Each country will have it's own states, cities and list of organizations
    public Country addCountry(String countryName) {
        Country country = new Country(countryName);
        countryList.add(country);
        return country;
    }

}
