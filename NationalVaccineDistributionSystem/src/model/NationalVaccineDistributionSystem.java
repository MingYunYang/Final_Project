package model;

import model.GeographicalConfiguration.Country;
import model.organization.NvdsParticipatingOrganizationsDirectory;
import java.util.ArrayList;

/**
 * @author Tugume William Mutara
 * @author Ming Yung Yang
 *
 * Please note that NVDS stands for National vaccine distribution system
 *
 */
public class NationalVaccineDistributionSystem {

    private static NationalVaccineDistributionSystem nationalVaccineDistributionSystemSingleInstance;

    private final ArrayList<Country> nvdsListOfParticipatingCountries;

    private final NvdsParticipatingOrganizationsDirectory nvdsListOfParticipatingOrganizations;

    public static NationalVaccineDistributionSystem getNationalVaccineDistributionSystemSingleInstance() {
        if ( nationalVaccineDistributionSystemSingleInstance == null ) {
            // Create a new single Vaccine distribution system instance
            // Or in other terms instantiate a new single Vaccine distribution system object
            nationalVaccineDistributionSystemSingleInstance = new NationalVaccineDistributionSystem();
        }
        return nationalVaccineDistributionSystemSingleInstance;
    }

    private NationalVaccineDistributionSystem() {
        this.nvdsListOfParticipatingCountries = new ArrayList<>();
        this.nvdsListOfParticipatingOrganizations = new NvdsParticipatingOrganizationsDirectory();

    }

    public NvdsParticipatingOrganizationsDirectory getNvdsListOfParticipatingOrganizations() {
        return nvdsListOfParticipatingOrganizations;
    }

    public ArrayList<Country> getNvdsListOfParticipatingCountries() {
        return nvdsListOfParticipatingCountries;
    }

    public Country addNewParticipatingCountry(String countryName) {
        Country country = new Country(countryName);
        nvdsListOfParticipatingCountries.add(country);
        return country;
    }

}
