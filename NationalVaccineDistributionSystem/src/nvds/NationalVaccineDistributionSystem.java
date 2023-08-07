package nvds;

import nvds.geography.Country;
import nvds.organization.OrganizationDirectory;
import java.util.ArrayList;

public class NationalVaccineDistributionSystem {

    private static NationalVaccineDistributionSystem singleInstance;

    private final OrganizationDirectory organizationList;

    private final ArrayList<Country> countryList;

    public static NationalVaccineDistributionSystem getInstance() {
        if ( singleInstance == null ) {
            singleInstance = new NationalVaccineDistributionSystem();
        }
        return singleInstance;
    }

    private NationalVaccineDistributionSystem() {
        organizationList = new OrganizationDirectory();
        countryList = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationList;
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country addCountry(String name) {
        Country country = new Country(name);
        countryList.add(country);
        return country;
    }

}
