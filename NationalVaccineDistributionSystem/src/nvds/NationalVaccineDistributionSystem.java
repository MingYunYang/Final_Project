package nvds;

import nvds.geography.Country;
import nvds.organization.OrganizationDirectory;
import java.util.ArrayList;

public class NationalVaccineDistributionSystem {

    private static NationalVaccineDistributionSystem singleInstance;

    private final OrganizationDirectory participatingOrganizations;

    private final ArrayList<Country> countryList;

    public static NationalVaccineDistributionSystem getInstance() {
        if ( singleInstance == null ) {
            singleInstance = new NationalVaccineDistributionSystem();
        }
        return singleInstance;
    }

    private NationalVaccineDistributionSystem() {
        participatingOrganizations = new OrganizationDirectory();
        countryList = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return participatingOrganizations;
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
