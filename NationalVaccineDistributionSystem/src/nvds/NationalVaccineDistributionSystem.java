package nvds;

import nvds.Geography.Country;
import nvds.Organization.NvdsParticipatingOrganizationsDirectory;
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

    private final ArrayList<Country> listOfParticipatingCountries;

    private final NvdsParticipatingOrganizationsDirectory listOfParticipatingOrganizations;

    public static NationalVaccineDistributionSystem getNationalVaccineDistributionSystemSingleInstance() {
        if ( nationalVaccineDistributionSystemSingleInstance == null ) {
            // Create a new single Vaccine distribution system instance
            // Or in other terms instantiate a new single Vaccine distribution system object
            nationalVaccineDistributionSystemSingleInstance = new NationalVaccineDistributionSystem();
        }
        return nationalVaccineDistributionSystemSingleInstance;
    }

    private NationalVaccineDistributionSystem() {
        this.listOfParticipatingCountries = new ArrayList<>();
        this.listOfParticipatingOrganizations = new NvdsParticipatingOrganizationsDirectory();

    }

    public NvdsParticipatingOrganizationsDirectory getListOfParticipatingOrganizations() {
        return listOfParticipatingOrganizations;
    }

    public ArrayList<Country> getListOfParticipatingCountries() {
        return listOfParticipatingCountries;
    }

    public Country addNewParticipatingCountry(String countryName) {
        Country country = new Country(countryName);
        listOfParticipatingCountries.add(country);
        return country;
    }

}
