package nvds;

import nvds.geography.Country;
import nvds.organization.OrganizationDirectory;
import java.util.ArrayList;
import nvds.geography.City;
import nvds.organization.Manufacturer;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.vaccine.Batch;
import nvds.vaccine.Vaccine;

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
    
    public int getTotalAvailabilityForSpecificVaccine(Vaccine vaccine, Country country){
        int sum = 0;
        for(Organization organization : organizationList.getListOfOrganizations()){
            if(organization.getType().equals(Type.Manufacturer) && organization.getCountry().equals(country)){
                Manufacturer manufacturer = (Manufacturer) organization;
                for(Batch batch : manufacturer.getInventoryCatalog().getBatchList()){
                    if(batch.getVaccine().equals(vaccine)){
                        sum = sum + batch.getQuantity();
                    }
                }
            }
        }
        return sum;
    }
    
    public int getTotalSatelliteClinicNumForSpecificHospital(City city){
        int sum = 0;
        for(Organization organization : organizationList.getListOfOrganizations()){
            if(organization.getType().equals(Type.Clinic) && organization.getCity().equals(city)){
               sum += 1;
            }
        }
        return sum;
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
