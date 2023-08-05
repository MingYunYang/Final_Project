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

    private static NationalVaccineDistributionSystem singleInstance;

    private final ArrayList<Country> participatingCountries;

    private final NvdsParticipatingOrganizationsDirectory participatingOrganizations;

    public static NationalVaccineDistributionSystem getSingleInstance() {
        if ( singleInstance == null ) {
            // Create a new single Vaccine distribution system instance
            // Or in other terms instantiate a new single Vaccine distribution system object
            singleInstance = new NationalVaccineDistributionSystem();
        }
        return singleInstance;
    }

    private NationalVaccineDistributionSystem() {
        this.participatingCountries = new ArrayList<>();
        this.participatingOrganizations = new NvdsParticipatingOrganizationsDirectory();

    }

    public NvdsParticipatingOrganizationsDirectory getParticipatingOrganizations() {
        return participatingOrganizations;
    }

    public ArrayList<Country> getParticipatingCountries() {
        return participatingCountries;
    }

    public Country addParticipatingCountry(String countryName) {
        Country country = new Country(countryName);
        participatingCountries.add(country);
        return country;
    }

}
